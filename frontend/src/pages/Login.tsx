import { Button, Checkbox, FormControlLabel, TextField } from "@mui/material";
import { FC } from "react";
import { FieldValues, useForm } from "react-hook-form";
import { z } from "zod";
import { zodResolver } from "@hookform/resolvers/zod";

const schema = z.object({
  email: z.string().nonempty("Email is required").email(),
  password: z.string().nonempty("Password is required"),
});

type formType = z.infer<typeof schema>;

interface Props {}

const Login: FC<Props> = () => {
  const {
    handleSubmit,
    register,
    formState: { errors, isValid },
  } = useForm<formType>({
    resolver: zodResolver(schema),
  });

  const onSubmit = (data: FieldValues) => {
    console.log(data);
  };

  return (
    <div className="container d-flex">
      <form onSubmit={handleSubmit(onSubmit)} className="wrapper">
        <div className="form-group d-flex justify-around">
          <div className="d-flex flex-column text-center">
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
            <FormControlLabel control={<Checkbox />} label="Remmber Me" />
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
