import { DataItem } from "../Charts/charts.types";
import { IUser } from "../types/IUser";

export const getUsersByState = (users: Array<IUser>): Array<DataItem> => {
  const map: Map<string, number> = new Map();

  users.forEach((user) => {
    if (map.has(user.state)) {
      let mapItem = map.get(user.state) as number;
      mapItem += 1;
      map.set(user.state, mapItem);
    } else {
      map.set(user.state, 1);
    }
  });

  const result: DataItem[] = [];

  map.forEach((value, key) => {
    result.push({ name: key, value });
  });

  return result;
};

export const getUsersByCity = (
  users: Array<IUser>,
  state: string
): Array<DataItem> => {
  const map: Map<string, number> = new Map();
  users = users.filter(({ state: userState }) => userState === state);

  users.forEach((user) => {
    if (map.has(user.city)) {
      let mapItem = map.get(user.city) as number;
      mapItem += 1;
      map.set(user.city, mapItem);
    } else {
      map.set(user.city, 1);
    }
  });

  const result: DataItem[] = [];

  map.forEach((value, key) => {
    result.push({ name: key, value });
  });

  return result;
};

export const getStates = (users: Array<IUser>) => {
  const states = users.map((user) => user.state);
  return [...new Set(states)];
};
