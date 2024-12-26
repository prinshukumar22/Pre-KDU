/*
  Define a generic function filterArray<T>(arr: T[], predicate: (item: T) => boolean): T[] that filters an array based on a predicate function.
  Use this function to filter an array of numbers and return only even numbers.
  Use the same function to filter an array of User objects and return users whose email includes "@company.com".

  Export the filterArray function so that the code can be tested in the test file.
*/

import { User } from "./q1";

export function filterArray<T>(arr: T[], predicate: (item: T) => boolean): T[] {
  return arr.filter(predicate);
}

const filteredArr: number[] = filterArray<number>(
  [1, 2, 3, 4, 5, 6, 7, 8, 9, 10],
  (item: number) => item % 2 === 0
);

const filteredArr2: User[] = filterArray<User>(
  [
    {
      id: 1,
      name: "John Doe",
      email: "john.doe@example.com",
    },
    {
      id: 2,
      name: "Prinshu Behera",
      email: "prinshu.behera@company.com",
    },
  ],
  (item: User) => item.email.includes("@company.com")
);

console.log(filteredArr);
console.log(filteredArr2);
