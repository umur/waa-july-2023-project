import Advertisement from "./Advertisement";
import { useEffect, useState } from "react";
import axios from "axios";
import Application from "./Application";

export default function ShowAdvertisement() {
  const initialAdvertisements = [
    {
      id: 1,
      companyName: "company",
      title: "title",
      state: "state",
      city: "city",
      tag: "tage",
      date: "data",
      salary: "salary",
      description: "desription",
    },
    {
      id: 1,
      companyName: "company",
      title: "title",
      state: "state",
      city: "city",
      tag: "tage",
      date: "data",
      salary: "salary",
      description: "desription",
    },
    {
      id: 1,
      companyName: "company",
      title: "title",
      state: "state",
      city: "city",
      tag: "tage",
      date: "data",
      salary: "salary",
      description: "desription",
    },
    {
      id: 1,
      companyName: "company",
      title: "title",
      state: "state",
      city: "city",
      tag: "tage",
      date: "data",
      salary: "salary",
      description: "desription",
    },
    {
      id: 1,
      companyName: "company",
      title: "title",
      state: "state",
      city: "city",
      tag: "tage",
      date: "data",
      salary: "salary",
      description: "desription",
    },
    {
      id: 1,
      companyName: "company",
      title: "title",
      state: "state",
      city: "city",
      tag: "tage",
      date: "data",
      salary: "salary",
      description: "desription",
    },
    {
      id: 1,
      companyName: "company",
      title: "title",
      state: "state",
      city: "city",
      tag: "tage",
      date: "data",
      salary: "salary",
      description: "desription",
    },
    {
      id: 1,
      companyName: "company",
      title: "title",
      state: "state",
      city: "city",
      tag: "tage",
      date: "data",
      salary: "salary",
      description: "desription",
    },
    {
      id: 1,
      companyName: "company",
      title: "title",
      state: "state",
      city: "city",
      tag: "tage",
      date: "data",
      salary: "salary",
      description: "desription",
    },
    {
      id: 1,
      companyName: "company",
      title: "title",
      state: "state",
      city: "city",
      tag: "tage",
      date: "data",
      salary: "salary",
      description: "desription",
    },
    {
      id: 1,
      companyName: "company",
      title: "title",
      state: "state",
      city: "city",
      tag: "tage",
      date: "data",
      salary: "salary",
      description: "desription",
    },
    {
      id: 1,
      companyName: "company",
      title: "title",
      state: "state",
      city: "city",
      tag: "tage",
      date: "data",
      salary: "salary",
      description: "desription",
    },
    {
      id: 1,
      companyName: "company",
      title: "title",
      state: "state",
      city: "city",
      tag: "tage",
      date: "data",
      salary: "salary",
      description: "desription",
    },
    {
      id: 1,
      companyName: "company",
      title: "title",
      state: "state",
      city: "city",
      tag: "tage",
      date: "data",
      salary: "salary",
      description: "desription",
    },
    {
      id: 1,
      companyName: "company",
      title: "title",
      state: "state",
      city: "city",
      tag: "tage",
      date: "data",
      salary: "salary",
      description: "desription",
    },
  ];

  const initialApplications = [
    {
      id: 1,
      companyName: "company",
      title: "title",
      state: "state",
      city: "city",
      tag: "tage",
      date: "data",
      salary: "salary",
      description: "desription",
    },
    {
      id: 1,
      companyName: "company",
      title: "title",
      state: "state",
      city: "city",
      tag: "tage",
      date: "data",
      salary: "salary",
      description: "desription",
    },
    {
      id: 1,
      companyName: "company",
      title: "title",
      state: "state",
      city: "city",
      tag: "tage",
      date: "data",
      salary: "salary",
      description: "desription",
    },
    {
      id: 1,
      companyName: "company",
      title: "title",
      state: "state",
      city: "city",
      tag: "tage",
      date: "data",
      salary: "salary",
      description: "desription",
    },
    {
      id: 1,
      companyName: "company",
      title: "title",
      state: "state",
      city: "city",
      tag: "tage",
      date: "data",
      salary: "salary",
      description: "desription",
    },
    {
      id: 1,
      companyName: "company",
      title: "title",
      state: "state",
      city: "city",
      tag: "tage",
      date: "data",
      salary: "salary",
      description: "desription",
    },
    {
      id: 1,
      companyName: "company",
      title: "title",
      state: "state",
      city: "city",
      tag: "tage",
      date: "data",
      salary: "salary",
      description: "desription",
    },
    {
      id: 1,
      companyName: "company",
      title: "title",
      state: "state",
      city: "city",
      tag: "tage",
      date: "data",
      salary: "salary",
      description: "desription",
    },
    {
      id: 1,
      companyName: "company",
      title: "title",
      state: "state",
      city: "city",
      tag: "tage",
      date: "data",
      salary: "salary",
      description: "desription",
    },
    {
      id: 1,
      companyName: "company",
      title: "title",
      state: "state",
      city: "city",
      tag: "tage",
      date: "data",
      salary: "salary",
      description: "desription",
    },
    {
      id: 1,
      companyName: "company",
      title: "title",
      state: "state",
      city: "city",
      tag: "tage",
      date: "data",
      salary: "salary",
      description: "desription",
    },
    {
      id: 1,
      companyName: "company",
      title: "title",
      state: "state",
      city: "city",
      tag: "tage",
      date: "data",
      salary: "salary",
      description: "desription",
    },
    {
      id: 1,
      companyName: "company",
      title: "title",
      state: "state",
      city: "city",
      tag: "tage",
      date: "data",
      salary: "salary",
      description: "desription",
    },
    {
      id: 1,
      companyName: "company",
      title: "title",
      state: "state",
      city: "city",
      tag: "tage",
      date: "data",
      salary: "salary",
      description: "desription",
    },
    {
      id: 1,
      companyName: "company",
      title: "title",
      state: "state",
      city: "city",
      tag: "tage",
      date: "data",
      salary: "salary",
      description: "desription",
    },
  ];

  const [Advertisements, setAdvertisements] = useState(initialAdvertisements);

  const [applications, setApplications] = useState(initialApplications);

  const loadData = async () => {
    // const storageUser = JSON.parse(localStorage.getItem("user"));
    // const token = storageUser.token;
    // const axiosConfig = {
    //   headers: {
    //     Authorization: `Bearer ${token}`,
    //   },
    // };

    const resultAdvertisemennts = await axios.get(
      "http://localhost:8080/api/advertisements"
    ); //,axiosConfig
    const resultApplications = await axios.get(
      "http://localhost:8080/api/applications"
    ); //,axiosConfig

    setAdvertisements(resultAdvertisemennts.data);
    setApplications(resultApplications.data);
  };

  useEffect(() => {
    loadData();
  }, []);

  return (
    <div>
      <h2 className="left-margin">last 10 job advertisements</h2>
      <div className="grid-container">
        {Advertisements.slice(0, 10).map((user) => {
          return (
            <Advertisement
              id={user.id}
              description={user.description}
              salary={user.salary}
              companyName={user.companyName}
              state={user.state}
              tag={user.tag}
              city={user.city}
              title={user.title}
            />
          );
        })}
      </div>

      <h2 className="left-margin">
        10 most recently applied job advertisements
      </h2>
      <div className="grid-container">
        {initialApplications.slice(0, 10).map((user) => {
          return (
            <Application
              id={user.id}
              description={user.description}
              salary={user.salary}
              companyName={user.companyName}
              state={user.state}
              tag={user.tag}
              city={user.city}
              title={user.title}
            />
          );
        })}
      </div>
    </div>
  );
}
