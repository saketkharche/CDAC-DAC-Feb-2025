import express from "express";
//const express=require('express')

//create express application
const app = express();

const myMiddleware = (req, res, next) => {
  console.log("Middleware function called");
  next(); //call next middleware or route handler
};

app.use(express.json()); //use middleware function for each an every url

app.get("/", (req, res) => {
  res.send("welcome");
}); //return obj of newly created express app
app.post("/sum", (req, res) => {
  //req.params
  const data = req.body;
  console.log(data);
  res.send("Sum is");
});
app.listen(4000, () => {
  console.log("Server running on http://localhost:4000");
});
