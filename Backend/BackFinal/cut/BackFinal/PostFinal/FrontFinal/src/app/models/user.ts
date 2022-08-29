export interface User {
  fullName: string;
  email: string;
  password: string;
  role: string;
  createdAt?: Date;
  updatedAt?: Date;
}
