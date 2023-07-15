import { FC, ReactNode, useMemo, useState } from 'react';
import { IUser } from '../types/IUser';
import { UserContext, UserContextProps } from './UserContext';

type UserProviderProps = {
  children: ReactNode;
};

const UserProvider: FC<UserProviderProps> = ({ children }) => {
  const [user, setUser] = useState<IUser | null>(null);

  const value = useMemo<UserContextProps>(
    () => ({ user, updateUser: setUser }),
    [user, setUser]
  );

  return (
    <UserContext.Provider value={value}>
      <>{children}</>
    </UserContext.Provider>
  );
};

export default UserProvider;
