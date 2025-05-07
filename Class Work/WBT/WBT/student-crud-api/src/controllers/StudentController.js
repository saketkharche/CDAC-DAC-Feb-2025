import { StatusCodes } from "http-status-codes";
import { getConnectionObject } from "../configs/DbConfig.js";

const conn = getConnectionObject();

export function registerStudent(request,response){
    try {
        const data = request.body; //
        const qry = `insert into student values(${data.id},'${data.name}','${data.phone}',${data.marks})`;
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
                response.status(StatusCodes.OK).send({message:'Student Registered'});
            }
        });
    } catch (error) {
        response.status(StatusCodes.INTERNAL_SERVER_ERROR).send({message:'Something went wrong'});
    }
}

export function getAllStudents(request,response){
    try {
        const qry ="select * from student";
        conn.query(qry,(error,result)=>{
            if(error){
                console.log(error);
                response.status(StatusCodes.INTERNAL_SERVER_ERROR).send({message:'Problem in fetching data'});
            }
            else{
                response.status(StatusCodes.OK).send(result);
            }
        });
    } catch (error) {
        response.status(StatusCodes.INTERNAL_SERVER_ERROR).send({message:'Something went wrong'});
    }
}

export function getStudentById(request,response){
    try {
        const id = parseInt(request.params.id);
        const qry =`select * from student where id=${id}`;
        conn.query(qry,(error,result)=>{
            if(error){
                console.log(error);
                response.status(StatusCodes.INTERNAL_SERVER_ERROR).send({message:'Problem in fetching data'});
            }
            else{
                if(result.length===0){
                    response.status(StatusCodes.NOT_FOUND).send({message:`Student with id ${id} not found !`});
                }
                else{
                    response.status(StatusCodes.OK).send(result[0]);
                }
                
            }
        });
    } catch (error) {
        response.status(StatusCodes.INTERNAL_SERVER_ERROR).send({message:'Something went wrong'});
    }
}

export function deleteStudent(request,response){
    try {
        const id = parseInt(request.params.id);
        const qry =`delete from student where id=${id}`;
        conn.query(qry,(error,result)=>{
            if(error){
                console.log(error);
                response.status(StatusCodes.INTERNAL_SERVER_ERROR).send({message:'Problem in fetching data'});
            }
            else{
                response.status(StatusCodes.OK).send({message:'Student Deleted!'}); 
                
            }
        });
    } catch (error) {
        response.status(StatusCodes.INTERNAL_SERVER_ERROR).send({message:'Something went wrong'});
    }
}

export function updateStudent(request,response){
    try {
        const id = parseInt(request.params.id);
        const data = request.body;
        const qry =`update student set name='${data.name}', phone='${data.phone}', marks='${data.marks}' where id=${id}`;
        conn.query(qry,(error,result)=>{
            if(error){
                console.log(error);
                response.status(StatusCodes.INTERNAL_SERVER_ERROR).send({message:'Problem in updating data'});
            }
            else{
                response.status(StatusCodes.OK).send({message:'Student Updated!'}); 
                
            }
        });
    } catch (error) {
        response.status(StatusCodes.INTERNAL_SERVER_ERROR).send({message:'Something went wrong'});
    }
}