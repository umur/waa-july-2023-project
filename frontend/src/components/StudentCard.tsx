import { FC, useState } from "react";
import { JobAdvertisement } from "../types/ITypes";
import Box from "@mui/material/Box";
import Card from "@mui/material/Card";
import CardActions from "@mui/material/CardActions";
import CardContent from "@mui/material/CardContent";
import Button from "@mui/material/Button";
import Typography from "@mui/material/Typography";
import useRole from "../hooks/useRole";
import { Modal } from "@mui/material";
import { useForm } from "react-hook-form";

interface Props {}

const style = {
  position: "absolute" as "absolute",
  top: "50%",
  left: "50%",
  transform: "translate(-50%, -50%)",
  bgcolor: "background.paper",
  border: "1px solid #000",
  boxShadow: 24,
};

const StudentCard: FC<Props> = () => {
  const { isFaculty } = useRole();

  const [open, setOpen] = useState(false);
  const handleOpen = () => setOpen(true);
  const handleClose = () => setOpen(false);

  //form
  const { handleSubmit, register } = useForm();

  const onSubmit = () => {
    console.log("hello");
  };

  return (
    <>
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
                {/* <TextField
                  {...register("positionTitle")}
                  id="positionTitle"
                  label="Position Title"
                  variant="outlined"
                />
                {errors.positionTitle && <p>{errors.positionTitle.message}</p>}
                */}
              </div>
            </div>
            <Button type="submit" variant="contained">
              Add
            </Button>
          </form>
        </Box>
      </Modal>
      <Box sx={{ maxWidth: 250 }}>
        <Card variant="outlined">
          <CardContent>
            <Typography
              sx={{ fontSize: 18, fontWeight: 500 }}
              gutterBottom
            ></Typography>
            <Typography
              sx={{ fontSize: 16, fontWeight: 500 }}
              color="text.secondary"
              gutterBottom
            ></Typography>
            <Typography
              sx={{ fontSize: 14, fontWeight: 400 }}
              color="text.secondary"
              gutterBottom
            ></Typography>
            <Typography
              sx={{ fontSize: 14, fontWeight: 400 }}
              gutterBottom
            ></Typography>
            <Typography
              sx={{ fontSize: 14, fontWeight: 400 }}
              gutterBottom
            ></Typography>
          </CardContent>
          <CardActions>
            {isFaculty && (
              <Button onClick={handleOpen} size="small">
                Write Comment
              </Button>
            )}
          </CardActions>
        </Card>
      </Box>
    </>
  );
};
export default StudentCard;
