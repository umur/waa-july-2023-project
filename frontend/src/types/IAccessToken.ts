type IAccessToken = {
  firstName: string;
  lastName: string;
  sub: string;
  major: string;
  city: string;
  roles: Role[];
  state: string;
  exp: number;
  iat: number;
};

export interface Role {
  authority: string;
}

export default IAccessToken;
