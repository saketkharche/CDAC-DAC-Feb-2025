const fs = require('fs');

//ASYNC way
// fs.writeFile("myfile.txt", "hello world", (error) => {
//     if (!error) {
//         console.log("write operation completed!..");
//
//     } else {
//         console.log("write operation failed!");
//     }
// });

//sync file write
//fs.writeFileSync("demofile.txt", "this is a dummy log");

//Async read
fs.readFile("NodePractise/inbuid module/myfile.txt", (error, data) => {
    if (error) {
        console.log(data.toString());

    } else {
        console.log(error);
    }
})


console.log("after write into file.....");