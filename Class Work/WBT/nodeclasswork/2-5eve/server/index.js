import { createServer } from "http";

const server = createServer((request, response) => {
  response.write("Hello saket\n");
  response.end("Hello saket\n");
});

server.listen(3000, () => {
  console.log("Server running at http://localhost:3000/");
});
