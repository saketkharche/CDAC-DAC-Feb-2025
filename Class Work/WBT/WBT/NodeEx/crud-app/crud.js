import express, { response } from 'express';
import { createConnection } from 'mysql2';

const PORT = 7777;
const app = express(); //middleware

app.use(express.json());

const conn = createConnection({
    host: 'localhost',
    user: 'root',
    password: 'cdac',
    database: 'cdac_wpt'
});

conn.connect((error)=>{
    if(error) {
        console.log(error);
    }else{
        console.log("Database connected !");
    }
});

app.get('/',(request,response)=>{
    try{
        response.status(200).send({message:"Welcome to crud app"});
    }catch(e){
        console.log("error in fetching data");
    }
});


app.get('/students',(request,response)=>{
    const selectqry = `select * from students`;

    conn.query(selectqry,(error,result)=>{
        if(error){
            response.status(500).send(error);
        }
        else{
            response.status(200).send(result);
        }
    });
});

app.post('/students',(request,response)=>{
    const {id,name,marks} = request.body;
    const insertqry = `insert into students(id,name,marks) values(?,?,?)`;

    conn.query(insertqry,[id,name,marks],(error,result)=>{
        if(error){
            response.status(500).send(error);
        }
        else{
            response.status(200).send("succsesfully added !");
        }
    });
});

app.put('/students/:id',(request,response)=>{
    const {name,marks} = request.body;
    const updateqry = `update students set name=?,marks=? where id=?`;

    conn.query(updateqry,[name,marks,request.params.id],(error)=>{
        if(error){
            response.status(500).send(error);
        }
        else{
            response.status(200).send("sucsessfully updated !");
        }
    });
});

app.delete('/students/:id',(request,response)=>{
    const deleteqry = `delete from students where id=${request.params.id}`;
    
    conn.query(deleteqry,(error)=>{
        if(error){
            response.status(500).send(error);
        }
        else{
            response.status(200).send("sucsessfully deleted !");
        }
    });
});

app.listen(PORT,()=>{
    console.log(`server listening on PORT:${PORT}`);
});