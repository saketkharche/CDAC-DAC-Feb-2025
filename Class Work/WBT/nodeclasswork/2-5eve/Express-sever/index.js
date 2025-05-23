import express, { request, response } from "express";
//const express =require('express');simillar to above line

//create a express app
//it will act as server
const app = express(); //returns an instance(object) of express app

app.listen(3000, () => {
  console.log("server is running on port 3000");
});

//create a route
app.get("/", (request, response) => {
  response.send("Hello from express"); //send a response to the client
});

app.get("/login", (request, response) => {
  response.send("Welcome to home"); //send a response to the client
});

app.get("/sum/:var1/:var2", (request, response) => {
  console.log(request.params); //log the request parameters to the console

  //var var1; //get the value of a from query string
  //var var2; //get the value of b from query string
  //var sum = var1 + var2; //calculate the sum of a and b

  //response.send(request.params); //send a response to the client

  var a = parseInt(request.params.var1);
  var b = parseInt(request.params.var2);
  let sum = a + b; //calculate the sum of a and b

  response.send(`The sum of ${a} and ${b} is ${sum}`); //send a response to the client

  //response.send(`The sum of ${a} and ${b} is ${sum}`); //send a response to the client
});

app.get("/about", (request, response) => {
  response.send("Welcome to about"); //send a response to the client
});

app.get("/contact", (request, response) => {
  response.send("Welcome to contact"); //send a response to the client
});
app.get("/services", (request, response) => {
  response.send("Welcome to services"); //send a response to the client
});
app.get("/products", (request, response) => {
  response.send("Welcome to products"); //send a response to the client
});

app.listen(3000, () => {
  console.log("server is running on port 3000");
});
