//const http=require('http');
import {createServer} from "http";

// var server = http.createServer((request,response)=>{
    var server = createServer((request,response)=>{
    response.write("Hello world!");
    response.end("bye");
});//create server and will retun server obj
server.listen(4500,()=>{
    console.log("server started");//start listen to server
});