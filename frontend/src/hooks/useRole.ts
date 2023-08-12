import { useState, useEffect } from "react";
import { useUserContext } from "../context/UserContext";

const useRole = () => {
  const [isFaculty, setIsFaculty] = useState(false);
  const { user } = useUserContext();

  useEffect(() => {
    if (user?.roles[0].role == "FACULTY") {
      setIsFaculty(true);
    } else setIsFaculty(false);
  });

  return {
    isFaculty,
  };
};

export default useRole;
