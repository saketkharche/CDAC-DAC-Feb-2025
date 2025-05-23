import { StatusCodes } from "http-status-codes";
import jwt from 'jsonwebtoken';

export function verifyToken(request,response,next){
    // request.params request.body request.get
    const authHeader = request.get('Authorization');
    if(authHeader){
        const token = authHeader.split(" ")[1];
        jwt.verify(token,"hello123",(error,payload)=>{
            if(error){
                response.status(StatusCodes.UNAUTHORIZED).send({message:'Token is invalid'});   
            }
            else{
                next();
            }
        })
    }
    else{
        response.status(StatusCodes.UNAUTHORIZED).send({message:'Token is missing'});
    }
}