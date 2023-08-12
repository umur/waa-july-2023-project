import { IUser } from "./IUser";

export type JobAdvertisement = {
  id?: number;
  positionTitle: string;
  minSalary: number;
  maxSalary: number;
  requiredSkills: string;
  tags: Tag[];
  user: IUser|null;
  company: string;
  description: string;
};

export type FormJobAdv = Pick<
  JobAdvertisement,
  | "company"
  | "positionTitle"
  | "description"
  | "maxSalary"
  | "minSalary"
  | "requiredSkills"
>;

export interface Tag {
  id: number;
  version: number;
  name: string;
  resume: Resume[];
}

export interface Resume {
  id: number;
  version: number;
  careerGoal: string;
  jobTitle: string;
  experiences: Experience[];
  tags: string[];
  user: IUser;
}

export interface Experience {
  id: number;
  version: number;
  companyName: string;
  city: string;
  companyDescription: string;
  jobTitle: string;
  startDate: string;
  exitDate: string;
  state: string;
}
