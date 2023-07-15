import { Button, Checkbox, FormControlLabel, TextField } from "@mui/material";
import { FC } from "react";
import { FieldValues, useForm } from "react-hook-form";
import { z } from "zod";
import { zodResolver } from "@hookform/resolvers/zod";

import http from "../interceptor/interceptor";
import { useNavigate } from "react-router-dom";

const schema = z.object({
  email: z.string().nonempty("Email is required").email(),
  password: z.string().nonempty("Password is required"),
});

type formType = z.infer<typeof schema>;

interface Props {}

const Login: FC<Props> = () => {
  const navigate = useNavigate();

  const {
    handleSubmit,
    register,
    formState: { errors, isValid },
  } = useForm<formType>({
    resolver: zodResolver(schema),
  });

  const onSubmit = async (data: FieldValues) => {
    const result = await http.post("/uaa/signin", data);

    if (result.status === 200) {
      localStorage.setItem("accessToken", result.data["accessToken"]);
      localStorage.setItem("refreshToken", result.data["refreshToken"]);
      navigate("/signup");
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
