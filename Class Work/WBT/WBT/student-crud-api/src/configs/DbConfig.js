import {createConnection} from 'mysql';
var conn = createConnection({
    host:"localhost",
    user:"root",
    password:"root",
    database:"cdac_22_april"
});
conn.connect((error)=>{
    if(error){
        console.log(error);
    }
    else{
        console.log("Db connected !");
    }
});

export function getConnectionObject(){
    return conn;
}