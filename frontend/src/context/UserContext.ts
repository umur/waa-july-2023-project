import { createContext } from "react";
import { IUser } from "../types/IUser";


export interface UserContextProps {
    user: IUser | null;
    updateUser: (user: IUser | null) => void;
  }

export const UserContext = createContext<UserContextProps>({
    user: null,
    updateUser: () => {},
  });