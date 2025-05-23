const express = require('express');
const mysql = require('mysql2');  // Supports MySQL 8+ auth [[web_search:3]]
const bodyParser = require('body-parser');

const app=express();
const PORT =3000;

//Middleware
app.use(bodyParser.json());

//mysql connectivte
const db=mysql.createConnection({
    host: 'localhost',
    user: 'root',
    password: 'cdac',
    database: 'cdac_wpt',
});

db.connect(err=>{
    if(err){
        throw err;
    }
    console.log("MYsql connected succesfully!!"); 
});

//Create
app.post('/book', (req, res) => {
    const {bookid,bookname,price} = req.body;
    const sql='INSERT INTO book (bookid,bookname,price) VALUES (?,?,?);'
    db.query(sql,[bookid,bookname,price],(err)=>{
        if(err){
            return res.status(500).json({error:err.message});
        }
        res.json({message:'Book Created Successfully!'});
    });
});

//display all
app.get('/book', (req, res)=>{
    const sql ='select * from book';
    db.query(sql,(err,results) => {
        if(err){
            res.status(500).json({error:err.message});
        }
        res.json(results);
    });
});

//display 1 item
app.get('/book/:id', (req, res)=>{

    const sql ='select * from book where bookid =?';

    db.query(sql,[req.params.id],(err,results) => {
        if(err){
            res.status(500).json({error:err.message});
        }
        res.json(results[0]||{error:'Book not found'});
    });
});

//UPDate
app.put('/book/:id', (req, res)=> {
    const {bookname,price}=req.body;
    const sql='Update book set bookname=?,price=? where bookid=?';
    db.query(sql,[bookname,price,req.params.id],(err)=>{
        if (err) {
            return res.status(500).json({ error: err.message });
    }
    res.json({ message: 'Book updated successfully' });
    })
});

//delete
app.delete('/book/:id',(req,res)=>{
    const sql = 'DELETE FROM book WHERE bookid = ?';
    db.query(sql, [req.params.id], (err) => {
      if (err) {
        return res.status(500).json({ error: err.message })};
      res.json({ message: 'Book deleted successfully' });
    });
})

// Start Server
app.listen(PORT, () => {
    console.log(`Server running at http://localhost:${PORT}`);
  });