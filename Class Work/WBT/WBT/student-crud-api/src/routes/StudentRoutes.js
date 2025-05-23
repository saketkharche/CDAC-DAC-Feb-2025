import express from 'express';
import { deleteStudent, getAllStudents, getStudentById, registerStudent, updateStudent } from '../controllers/StudentController.js';
import { verifyToken } from '../middlewares/VerifyToken.js';

const studentRouter = express.Router(); // becasue routing is not getting handled into a separate js file

studentRouter.post("/",verifyToken,registerStudent);

studentRouter.get("/",verifyToken,getAllStudents);

studentRouter.get("/:id",verifyToken,getStudentById);

studentRouter.delete("/:id",verifyToken,deleteStudent);

studentRouter.put("/:id",verifyToken,updateStudent);

export default studentRouter;

