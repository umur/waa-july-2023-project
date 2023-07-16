import { zodResolver } from "@hookform/resolvers/zod";
import { Button, TextField } from "@mui/material";
import jwt_decode from "jwt-decode";
import { FC } from "react";
import { FieldValues, useForm } from "react-hook-form";
import { useNavigate } from "react-router-dom";
import { z } from "zod";

import { useUserContext } from "../context/UserContext";
import http from "../interceptor/interceptor";
import IAccessToken from "../types/IAccessToken";
import { IUser } from "../types/IUser";

const schema = z.object({
  email: z.string().nonempty("Email is required").email(),
  password: z.string().nonempty("Password is required"),
});

type formType = z.infer<typeof schema>;

type LoginResult = { accessToken: string; refreshToken: string } & IUser;

const Login: FC = () => {
  const navigate = useNavigate();
  const { updateUser } = useUserContext();
  const {
    handleSubmit,
    register,
    formState: { errors, isValid },
  } = useForm<formType>({
    resolver: zodResolver(schema),
  });

  //handlers
  const onSubmit = async (formData: FieldValues) => {
    const { data, status } = await http.post<LoginResult>(
      "/uaa/signin",
      formData
    );

    if (status === 200) {
      localStorage.setItem("accessToken", data.accessToken);
      localStorage.setItem("refreshToken", data.refreshToken);
      navigate("/dashboard");
      const decoded: IAccessToken = jwt_decode(data.accessToken);
      updateUser({
        version: 0,
        email: decoded.sub,
        firstName: decoded.firstName,
        lastName: decoded.lastName,
        city: decoded.city,
        state: decoded.state,
        major: decoded.major,
        roles: [
          {
            role: decoded.roles[0].authority,
          },
        ],
        enabled: true,
        jobApplications: [],
      });
    }
  };

  return (
    <div className="container d-flex">
      <form onSubmit={handleSubmit(onSubmit)} className="wrapper">
        <div className="form-group d-flex justify-around">
          <div className="d-flex flex-column text-center flex">
            <TextField
              {...register("email")}
              id="email"
              label="Email"
              variant="outlined"
            />
            {errors.email && <p>{errors.email.message}</p>}
            <TextField
              {...register("password")}
              id="password"
              type="password"
              label="Password"
              variant="outlined"
            />
            {errors.password && <p>{errors.password.message}</p>}
          </div>
        </div>
        <Button
          disabled={!isValid ? true : false}
          type="submit"
          variant="contained"
        >
          login
        </Button>
      </form>
    </div>
  );
};
export default Login;
