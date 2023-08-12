export interface IUser {
  id?: number | null;
  version: number;
  email: string;
  firstName: string;
  lastName: string;
  city: string;
  state: string;
  major: string;
  roles: Role[];
  enabled: boolean;
  jobApplications: any[];
}

export interface Role {
  id?: number;
  version?: number;
  role: string;
}
