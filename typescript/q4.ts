/*
  Create a utility function findById that takes an array of User objects and a number as arguments and returns a User | undefined (if the user with the given ID exists).
  Extend the function to support a new parameter, which specifies if the returned user should include undefined or throw an error. Use TypeScript's never type to represent the error-throwing case.
  Test the function using a sample array of User objects and handle both scenarios (with and without throwing an error).

  Export the function findById so that it can be used in the test file.
*/
import { User } from "./q1";

export function findById(
  users: User[],
  id: number,
  throwErr: boolean = false
): User | never | undefined {
  const user = users.find((user) => user.id === id);
  if (user) {
    return user;
  } else if (throwErr) {
    throw new Error(`User with ID ${id} not found.`);
  } else {
    return undefined;
  }
}

const sampleUsers: User[] = [
  { id: 1, name: "Alice", email: "alice@example.com" },
  { id: 2, name: "Bob", email: "bob@example.com" },
  { id: 3, name: "Charlie", email: "charlie@example.com" },
];

try {
  const user1 = findById(sampleUsers, 1);
  console.log(user1); 
  
  const user2 = findById(sampleUsers, 4);
  console.log(user2); 

  const user3 = findById(sampleUsers, 4, true);
  console.log(user3); 
} catch (error) {
  console.error(error.message); 
}
