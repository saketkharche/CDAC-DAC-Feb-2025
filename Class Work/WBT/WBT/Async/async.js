// console.log("hey");
// console.log("hey2");
// setTimeout(function () {
//     console.log("hey3");
//
// }, 0);
// console.log("hey4");

//CALL BACK Function
//Promise

// var ans = new Promise((res, rej) => {
//     if (true) {
//         return res();
//     } else {
//         return rej();
//     }
//     }
// );
//
// ans.then(function () {
//     console.log("resolve zhale");
// }).catch(function () {
//     console.log("reject zhale");
// })

//myDisplayer(result);
//
// function myDisplayer(result) {
//     console.log(result);
// }
//
// function myCalculator(num1, num2) {
//     let sum = num1 + num2;
//     return sum;
// }
//
// let result = myCalculator(5, 5);


// setTimeout(function () {
//     var a = 5;
//     var b = 10;
//     var c = a + b;
//     console.log(c)
// }, 2200);
// setTimeout(function () {
//     var a = 5;
//     var b = 10;
//     var c = a * b;
//     console.log(c)
// }, 3000);
// setTimeout(function () {
//     var a = 5;
//     var b = 10;
//     var c = a % b;
//     console.log(c)
// },1000)

//promise
// var myPromise = new Promise(function (resolve, reject) {
//     if (false) {
//         return resolve(myPromise);
//     } else {
//         return reject(myPromise);
//     }
// })
//     .then(function () {
//         console.log("resolve zhale");
//     }).catch(function () {
//         console.log("reject zhale");
//     });
//
//
// var evenPromise = new Promise((resolve,reject)=>{
//     var num = 9;
//     if(num%2==0){
//         resolve();
//     }
//     else{
//         reject();
//     }
// });
//
// evenPromise.then(()=>{
//     console.log("promise resolved and number is even");
// }).catch(()=>{
//     console.log("promise rejected and number is not even");
// });

// var evenPromise = new Promise((resolve,reject)=>{
//     var num = 7;
//     if(num%2==0){
//         resolve("promise resolved and number is even");
//     }
//     else{
//         reject("Error: promise rejected and number is not even");
//     }
// });
//
// evenPromise.then((result)=>{
//     console.log(result);
// }).catch((error)=>{
//     console.log(error);
// });

// Define the toUpperCase callback function
// function toUpperCase(str) {
//     return str.toUpperCase();
// }
//
// // Define the processData function
// function processData(inputStr, callback) {
//     return callback(inputStr);
// }
//
// // Call processData with the string and callback
// const result = processData("hello world", toUpperCase);
//
// // Log the output
// console.log(result); // Output: "HELLO WORLD"

var ans = new Promise(function (resolve, reject) {
    return resolve("gate close kar");

});

var p2 = ans.then(function (data) {
    console.log(data);
    return new Promise(function (resolve, reject) {
        return resolve("gate khole aur band kar");

    });
});


var p3 = p2.then(function (data) {
    console.log(data);
    return new Promise(function (resolve, reject) {
        return resolve("cook and eat ");
    })
})

p3.then(function (data) {
    console.log(data);
})