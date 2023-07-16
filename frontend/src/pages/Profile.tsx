import { FC, useState } from "react";
import { useUserContext } from "../context/UserContext";
import { Box, Button, Modal, TextField } from "@mui/material";
import { useForm } from "react-hook-form";

const style = {
  position: "absolute" as "absolute",
  top: "50%",
  left: "50%",
  transform: "translate(-50%, -50%)",
  bgcolor: "background.paper",
  border: "1px solid #000",
  boxShadow: 24,
};

type typeForm = {
  password: string;
};

const Profile: FC = () => {
  const { user } = useUserContext();

  //modal
  const [open, setOpen] = useState(false);
  const handleOpen = () => setOpen(true);
  const handleClose = () => setOpen(false);

  const {
    handleSubmit,
    register,
    formState: { errors, isValid },
  } = useForm<typeForm>();

  const onSubmit = async (val: typeForm) => {
    console.log("submit", val.password);
    setOpen(false);
  };

  const handleFetchingComments = async () => {
    console.log("handleFetchingComments");
  };

  return (
    <div>
      <Modal
        open={open}
        onClose={handleClose}
        aria-labelledby="modal-modal-title"
        aria-describedby="modal-modal-description"
      >
        <Box sx={style}>
          <form onSubmit={handleSubmit(onSubmit)} className="wrapper">
            <div className="form-group d-flex justify-around">
              <div className="d-flex flex-column text-center flex">
                <TextField
                  {...register("password")}
                  id="password"
                  label="New Password"
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
              Update
            </Button>
          </form>
        </Box>
      </Modal>
      <div className="profile">
        <div className="p-5">
          <div className="header"></div>
          <div className="name">
            <h3>{user?.firstName + " " + user?.lastName}</h3>
          </div>
          <div className="address">{user?.city + " " + user?.state}</div>
          <div className="email">{user?.email}</div>
          <div className="comments-btn">
            <Button onClick={handleFetchingComments}>comments</Button>
            <Button onClick={handleOpen}>Change Password</Button>
          </div>
        </div>
      </div>
      <div className="skills">
        <div></div>
      </div>
    </div>
  );
};
export default Profile;
