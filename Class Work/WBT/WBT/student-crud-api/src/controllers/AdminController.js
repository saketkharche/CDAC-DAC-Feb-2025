import { compareSync, hashSync } from "bcrypt";
import { StatusCodes } from "http-status-codes";
import { getConnectionObject } from "../configs/DbConfig.js";
import jwt from 'jsonwebtoken';

const conn = getConnectionObject();

export function registerAdmin(request,response){
    try {
        const data = request.body; //
        const encryptedPasswrod = hashSync(data.password, 10); // sync
        data.password="";
        const qry = `insert into admin values(${data.id},'${data.name}','${data.username}','${encryptedPasswrod}')`;
        conn.query(qry,(error,result)=>{
            if(error){
                console.log(error);
                if(error.errno==1062){
                    response.status(StatusCodes.BAD_REQUEST).send({message:'Id is duplicate !'});
                }
                else{
                    response.status(StatusCodes.INTERNAL_SERVER_ERROR).send({message:'Problem in inserting data'});
                }
                
            }
            else{
                response.status(StatusCodes.OK).send({message:'Admin Registered'});
            }
        });
    } catch (error) {
        response.status(StatusCodes.INTERNAL_SERVER_ERROR).send({message:'Something went wrong'});
    }
}

export function adminLogin(request,response){
    try {
        const requestData = request.body;
        const qry =`select * from admin where username='${requestData.username}'`;
        conn.query(qry,(error,result)=>{
            if(error){
                console.log(error);
                response.status(StatusCodes.INTERNAL_SERVER_ERROR).send({message:'Problem while logging you in...please try again later'});
            }
            else{
                console.log(result);
                if(result.length===0){
                    response.status(StatusCodes.BAD_REQUEST).send({message:'Username or Password is invalid'});
                }
                else{
                    if(compareSync(requestData.password,result[0].password)){
                        const token = jwt.sign({adminId:result[0].id},"hello123");
                        response.status(StatusCodes.OK).send({message:'Login successful',token:token});
                    }
                    else{
                        response.status(StatusCodes.BAD_REQUEST).send({message:'Username or Password is invalid'});
                    }
                    
                }
            }
        });
    } catch (error) {
        response.status(StatusCodes.INTERNAL_SERVER_ERROR).send({message:'Something went wrong'});
    }
}