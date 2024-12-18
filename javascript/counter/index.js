/* eslint-disable no-unused-vars */
// DECLARE VARIABLES
let count = document.querySelector("#counter-value");

let incBtn = document.querySelector("#increment");
let decBtn = document.querySelector("#decrement");

incBtn.addEventListener("click", (e) => {
  console.log(count);
  let num = +count.textContent;
  num++;
  count.textContent = num;
});

decBtn.addEventListener("click", (e) => {
  console.log(count);
  let num = +count.textContent;
  if (num === 0) return;
  num--;
  count.textContent = num;
});
