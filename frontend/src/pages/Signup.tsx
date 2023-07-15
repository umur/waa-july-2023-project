import { Button, Checkbox, FormControlLabel, TextField } from "@mui/material";
import { FC } from "react";

interface Props {}

const Signup: FC<Props> = () => {
  return (
    <div className="container d-flex">
      <div className="wrapper">
        <div className="form-group d-flex justify-around">
          <div className="d-flex flex-column text-center">
            <TextField id="email" label="Email" variant="outlined" />
            <TextField id="password" label="Password" variant="outlined" />
            <TextField id="firstname" label="Firstname" variant="outlined" />
            <TextField id="lastname" label="Lastname" variant="outlined" />
          </div>
          <div className="d-flex flex-column text-center">
            <TextField id="city" label="City" variant="outlined" />
            <TextField id="state" label="State" variant="outlined" />
            <TextField id="major" label="Major" variant="outlined" />
            <FormControlLabel control={<Checkbox />} label="Remmber Me" />
          </div>
        </div>
        <Button variant="contained">Signup</Button>
      </div>
    </div>
  );
};
export default Signup;
