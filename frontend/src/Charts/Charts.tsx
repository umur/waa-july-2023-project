import { FC, useEffect, useState } from "react";
import BarChart from "./BarChart";
import PieChart from "./PieCart";
import DonutChart from "./DonutChart";
import http from "../interceptor/interceptor";
import { IUser } from "../types/IUser";
import { getCities, getUsersByState } from "../utils/chart-data.helper";
import { DataItem } from "./charts.types";
import { Autocomplete, TextField } from "@mui/material";

const Charts: FC = () => {
  const [cities, setCities] = useState<Array<string>>();
  const [users, setUsers] = useState<Array<IUser> | undefined>();
  const [isLoading, setIsLoading] = useState<boolean>();
  const [selectedState, setSelectedState] = useState<boolean>();

  const [barChartData, setBarChartData] = useState<Array<DataItem>>();
  const [donutChart, setDonutChart] = useState<Array<DataItem>>();
  const [pieChartData, setPieChartData] = useState<Array<DataItem>>();

  useEffect(() => {
    setIsLoading(true);

    Promise.all([http.get<Array<IUser>>("/users")])
      .then(
        (result) => {
          if (result[0].status === 200) {
            setUsers(result[0].data);
          }
          // if (result[1].status === 200) {
          //   setDonutChart(result[1].data as DataItem[]);
          // }
        },
        (err) => {
          console.log(err);
        }
      )
      .finally(() => {
        setIsLoading(false);
      });
  }, []);

  useEffect(() => {
    if (users) {
      setBarChartData(getUsersByState(users));
      setCities(getCities(users));
    }
  }, [users]);

  if (isLoading) {
    return <div>Loading</div>;
  }

  return (
    <div>
      <Autocomplete
        disablePortal
        id="combo-box-demo"
        options={cities || []}
        sx={{ width: 300 }}
        renderInput={(params) => <TextField {...params} label="Cities" />}
      />
      {barChartData && <BarChart data={barChartData} />}
      {selectedState && pieChartData && <PieChart data={pieChartData} />}
      {donutChart && <DonutChart data={donutChart} />}
    </div>
  );
};
export default Charts;
