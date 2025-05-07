import express from 'express';
import { adminLogin, registerAdmin } from '../controllers/AdminController.js';
import { verifyToken } from '../middlewares/VerifyToken.js';

const adminRouter = express.Router();

adminRouter.post("/",verifyToken,registerAdmin);
adminRouter.post("/login",adminLogin);

export default adminRouter;