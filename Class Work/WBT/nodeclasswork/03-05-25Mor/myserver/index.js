import express, { response } from "express";
import { WELCOME_TO_HOME } from "./src/constants/responecemessages";

const PORT = 9400;

const app = express();

app.use(express.json());

app.get("/", (req, res) => {
  res.status(200).send("welcome to home!");
});

app.post("/factorial/:n", (req, res) => {
  try {
    const num = parseInt(req.params.n);
    if (isNaN(num) || num < 0) {
      return res
        .status(400)
        .send({ message: "Please provide a valid positive integer!" });
    }
    let fact = 1;
    for (let i = 1; i <= num; i++) {
      fact *= i;
    }
    return res.status(200).send({ message: `Factorial of ${num} is ${fact}` });
  } catch (error) {
    response.status(500).send({ message: "Something went wrong!" });
  }
});

app.listen(PORT, () => {
  console.log(`Server is running on port ${PORT}`);
});
