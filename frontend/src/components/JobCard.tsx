import { FC } from "react";
import { JobAdvertisement } from "../types/ITypes";
import Box from "@mui/material/Box";
import Card from "@mui/material/Card";
import CardActions from "@mui/material/CardActions";
import CardContent from "@mui/material/CardContent";
import Button from "@mui/material/Button";
import Typography from "@mui/material/Typography";
import { useUserContext } from "../context/UserContext";
interface Props {
  jobAdvertisement?: JobAdvertisement;
}

const JobCard: FC<Props> = ({
  jobAdvertisement = {
    company: "company",
    description: "description",
    maxSalary: 200,
    minSalary: 100,
    positionTitle: "positionTitle",
    requiredSkills: "requiredSkills",
    tags: [],
    user: null,
  },
}) => {
  const { user } = useUserContext();

  return (
    <Box sx={{ maxWidth: 250 }}>
      <Card variant="outlined">
        <CardContent>
          <Typography sx={{ fontSize: 18, fontWeight: 500 }} gutterBottom>
            {jobAdvertisement?.positionTitle}
          </Typography>
          <Typography
            sx={{ fontSize: 16, fontWeight: 500 }}
            color="text.secondary"
            gutterBottom
          >
            {jobAdvertisement?.company}
          </Typography>
          <Typography
            sx={{ fontSize: 14, fontWeight: 400 }}
            color="text.secondary"
            gutterBottom
          >
            {jobAdvertisement?.description}
          </Typography>
          <Typography sx={{ fontSize: 14, fontWeight: 400 }} gutterBottom>
            {jobAdvertisement?.minSalary + "$"} -{" "}
            {jobAdvertisement?.maxSalary + "$"}
          </Typography>
          <Typography sx={{ fontSize: 14, fontWeight: 400 }} gutterBottom>
            {jobAdvertisement.requiredSkills}
          </Typography>
        </CardContent>
        <CardActions>
          {user == jobAdvertisement.user && <Button size="small">Edit</Button>}
          <Button size="small">Apply</Button>
        </CardActions>
      </Card>
    </Box>
  );
};
export default JobCard;
