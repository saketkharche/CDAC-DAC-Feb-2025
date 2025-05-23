import express from 'express';
import {StatusCodes} from 'http-status-codes';
import studentRouter from './src/routes/StudentRoutes.js';
import adminRouter from './src/routes/AdminRoutes.js';

const PORT = 7800;
const app = express();
app.use(express.json());
app.use("/student",studentRouter);
app.use("/admin",adminRouter);

app.get("/",(request,response)=>{
    response.status(StatusCodes.OK).send({message:'Welcome to student CRUD'});
});


app.listen(PORT,()=>{
    console.log(`Server is running on ${PORT}`);
});