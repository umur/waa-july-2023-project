import axios from "axios";
import { useEffect, useState } from "react";

export const Home = () => {
  const [name, setName] = useState("");

  useEffect(() => {
    (async () => {
      const { data } = await axios.get(
        "http://localhost:8080/faculties/email/nguillond1@auda.org.au"
      );
      setName(data.firstName);
    })();
  }, []);

  return (
    <div className="form-signin mt-5 text-center">
      <h3>Hello {name}</h3>
    </div>
  );
};
