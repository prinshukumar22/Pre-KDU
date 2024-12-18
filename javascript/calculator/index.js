/* eslint-disable no-unused-vars */
// DECLARE VARIABLES
let num1 = document.querySelector("#num1");
let num2 = document.querySelector("#num2");

let addBtn = document.querySelector("#add");
let subBtn = document.querySelector("#subtract");
let mulBtn = document.querySelector("#multiply");
let divBtn = document.querySelector("#divide");

addBtn.addEventListener("click", (e) => {
  console.log(num1, num2);
  if (num1.value.trim() == "" || num2.value.trim() == "") {
    alert("Please enter both numbers");
  } else {
    let n1 = +num1.value;
    let n2 = +num2.value;

    alert(`Addition of these 2 numbers is -> ${n1 + n2}`);
  }
});

subBtn.addEventListener("click", (e) => {
  console.log(num1, num2);
  if (num1.value.trim() == "" || num2.value.trim() == "") {
    alert("Please enter both numbers");
  } else {
    let n1 = +num1.value;
    let n2 = +num2.value;

    alert(`Subtraction of these 2 numbers is -> ${n1 - n2}`);
  }
});

mulBtn.addEventListener("click", (e) => {
  console.log(num1, num2);
  if (num1.value.trim() == "" || num2.value.trim() == "") {
    alert("Please enter both numbers");
  } else {
    let n1 = +num1.value;
    let n2 = +num2.value;

    alert(`Multiplication of these 2 numbers is -> ${n1 * n2}`);
  }
});

divBtn.addEventListener("click", (e) => {
  console.log(num1, num2);
  if (num1.value.trim() == "" || num2.value.trim() == "") {
    alert("Please enter both numbers");
  } else {
    let n1 = +num1.value;
    let n2 = +num2.value;

    alert(`Division of these 2 numbers is -> ${n1 / n2}`);
  }
});
