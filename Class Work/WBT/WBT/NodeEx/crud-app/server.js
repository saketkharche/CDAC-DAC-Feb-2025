const express = require('express');
const mysql = require('mysql2');  // Supports MySQL 8+ auth [[web_search:3]]
const bodyParser = require('body-parser');
const cors = require('cors');

const app = express();
const PORT = 3000;

// Middleware
app.use(bodyParser.json());
app.use(cors());
app.use(express.static(__dirname)); // Serve static files

// MySQL Connection
const db = mysql.createConnection({
  host: 'localhost',
  user: 'root',
  password: 'cdac', // Update with your MySQL password
  database: 'cdac_wpt'
});

db.connect(err => {
  if (err) throw err;
  console.log('MySQL Connected...');
});

// CRUD Routes

// CREATE
app.post('/api/book', (req, res) => {
  const { bookid, bookname, price } = req.body;//data user
  const sql = 'INSERT INTO book (bookid, bookname, price) VALUES (?, ?, ?)';//sql query backend 
  //pass query to terminal of mysql
  db.query(sql, [bookid, bookname, price], (err) => {
    if (err) return res.status(500).json({ error: err.message });
    res.json({ message: 'Book created successfully' });
  });
});

// READ ALL
app.get('/api/books', (req, res) => {
  const sql = 'SELECT * FROM book';
  db.query(sql, (err, results) => {
    if (err) return res.status(500).json({ error: err.message });
    res.json(results);
  });
});

// READ SINGLE
app.get('/api/book/:id', (req, res) => {
  const sql = 'SELECT * FROM book WHERE bookid = ?';
  db.query(sql, [req.params.id], (err, result) => {
    if (err) return res.status(500).json({ error: err.message });
    res.json(result[0] || { error: 'Book not found' });
  });
});


// UPDATE
app.put('/api/book/:id', (req, res) => {
  const { bookname, price } = req.body;
  const sql = 'UPDATE book SET bookname = ?, price = ? WHERE bookid = ?';
  db.query(sql, [bookname, price, req.params.id], (err) => {
    if (err) return res.status(500).json({ error: err.message });
    res.json({ message: 'Book updated successfully' });
  });
});

// DELETE
app.delete('/api/book/:id', (req, res) => {
  const sql = 'DELETE FROM book WHERE bookid = ?';
  db.query(sql, [req.params.id], (err) => {
    if (err) return res.status(500).json({ error: err.message });
    res.json({ message: 'Book deleted successfully' });
  });
});

// Start Server
app.listen(PORT, () => {
  console.log(`Server running at http://localhost:${PORT}`);
});