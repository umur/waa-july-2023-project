import { zodResolver } from "@hookform/resolvers/zod";
import { Button, TextField } from "@mui/material";
import jwt_decode from "jwt-decode";
import { FC, useEffect } from "react";
import { FieldValues, useForm } from "react-hook-form";
import { z } from "zod";

import { useNavigate } from "react-router-dom";
import { useUserContext } from "../context/UserContext";
import http from "../interceptor/interceptor";
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
      navigate("/dashbord");
      updateUser({
        version: 1,
        email: "test",
        firstName: "test",
        lastName: "test",
        city: "test",
        state: "test",
        major: "test",
        roles: [],
        enabled: false,
        jobApplications: "test",
      });
      // const decoded = jwt_decode(data.accessToken);
      // const user = await http.post('/uaa/users/', data);
      // updateUser && updateUser(decoded.user)
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
