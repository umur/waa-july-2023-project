import { FC, useEffect, useState } from "react";
import { zodResolver } from "@hookform/resolvers/zod";
import { z } from "zod";
import { Box, Button, IconButton, Modal, TextField } from "@mui/material";
import AddIcon from "@mui/icons-material/Add";
import { useForm } from "react-hook-form";

import { FormJobAdv, JobAdvertisement } from "../types/ITypes";
import http from "../interceptor/interceptor";
import { useUserContext } from "../context/UserContext";
import JobCard from "../components/JobCard";

const style = {
  position: "absolute" as "absolute",
  top: "50%",
  left: "50%",
  transform: "translate(-50%, -50%)",
  bgcolor: "background.paper",
  border: "1px solid #000",
  boxShadow: 24,
};

const schema = z.object({
  positionTitle: z.string().nonempty("position Title is required"),
  minSalary: z.number(),
  maxSalary: z.number(),
  requiredSkills: z.string().nonempty("required Skills is required"),
  company: z.string().nonempty("Company is required"),
  description: z.string().nonempty("description is required"),
});

type formType = z.infer<typeof schema>;

const Jobs: FC = () => {
  const [jobs, setJobs] = useState<JobAdvertisement[]>([]);

  const { user } = useUserContext();

  //modal
  const [open, setOpen] = useState(false);
  const handleOpen = () => setOpen(true);
  const handleClose = () => setOpen(false);

  const {
    handleSubmit,
    register,
    formState: { errors, isValid },
  } = useForm<formType>({
    resolver: zodResolver(schema),
  });

  useEffect(() => {
    async function getData() {
      const { data, status } = await http.get("/job-advertisements");
      if (status == 200) {
        setJobs(data);
      }
    }
    getData();
  }, []);

  const onSubmit = async (formData: FormJobAdv) => {
    let dto: JobAdvertisement = { ...formData, tags: [], user: user };
    const { data, status } = await http.post<JobAdvertisement>(
      "/job-advertisements",
      dto
    );
    
    if (status === 200) {
      if (data) setJobs([...jobs, data]);
    }
  };
  return (
    <>
      <IconButton
        color="primary"
        aria-label="add to shopping cart"
        onClick={handleOpen}
      >
        <AddIcon></AddIcon>
      </IconButton>

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
                  {...register("positionTitle")}
                  id="positionTitle"
                  label="Position Title"
                  variant="outlined"
                />
                {errors.positionTitle && <p>{errors.positionTitle.message}</p>}
                <TextField
                  {...register("company")}
                  id="company"
                  type="text"
                  label="Company"
                  variant="outlined"
                />
                {errors.company && <p>{errors.company.message}</p>}
                <TextField
                  {...register("description")}
                  id="description"
                  type="text"
                  label="Description"
                  variant="outlined"
                />
                {errors.description && <p>{errors.description.message}</p>}
                <TextField
                  id="minSalary"
                  label="Number"
                  {...register("minSalary", { valueAsNumber: true })}
                  type="number"
                  InputLabelProps={{
                    shrink: true,
                  }}
                />
                {errors.minSalary && <p>{errors.minSalary.message}</p>}
                <TextField
                  id="maxSalary"
                  label="Number"
                  {...register("maxSalary", { valueAsNumber: true })}
                  type="number"
                  InputLabelProps={{
                    shrink: true,
                  }}
                />
                {errors.maxSalary && <p>{errors.maxSalary.message}</p>}
                <TextField
                  {...register("requiredSkills")}
                  id="requiredSkills"
                  type="text"
                  label="Required Skills"
                  variant="outlined"
                />
                {errors.requiredSkills && (
                  <p>{errors.requiredSkills.message}</p>
                )}
              </div>
            </div>
            <Button
              disabled={!isValid ? true : false}
              type="submit"
              variant="contained"
            >
              Add
            </Button>
          </form>
        </Box>
      </Modal>
      <div className="text-center">
        {jobs.length != 0 ? (
          jobs.map((job) => <JobCard jobAdvertisement={job} />)
        ) : (
          <p>No Data</p>
        )}
      </div>
    </>
  );
};
export default Jobs;
