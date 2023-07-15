import { useState, useEffect } from "react";

const useRole = () => {
  const [isFaculty, setIsFaculty] = useState(false);

  useEffect(() => {
    setIsFaculty(true);
  });

  return {
    isFaculty,
  };
};

export default useRole;
