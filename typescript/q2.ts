/*
  Create an enum Status with the following members:
  Active
  Inactive
  Suspended

  Define a tuple type UserStatus that contains:
  A User object (from Question 1)
  A Status value

  Write a function printUserStatus that accepts a UserStatus tuple as a parameter and logs a message in the format:
  "[UserName] is currently [Status]."
  
  Create a sample tuple and call the function with it.

  Export the enum Status, the UserStatus tuple type, and the printUserStatus function.
  So that the code can be tested in the test file.
 */

import { User } from "./q1";

export enum Status {
  Active = "Active",
  Inactive = "Inactive",
  Suspended = "Suspended",
}

export type UserStatus = [User, Status];

export function printUserStatus(userStatus: UserStatus): void {
  console.log(`${userStatus[0].name} is currently ${userStatus[1]}.`);
}

const sampleTuple: UserStatus = [
  {
    id: 1,
    name: "John Doe",
    email: "john.doe@example.com",
  },
  Status.Active,
];

printUserStatus(sampleTuple);
