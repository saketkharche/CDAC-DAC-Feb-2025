-- Create the faculty table
CREATE TABLE faculty (
    id INT PRIMARY KEY,
    name VARCHAR(100),
    department VARCHAR(100),
    email VARCHAR(100),
    qualification VARCHAR(100)
);

-- Insert dummy Maharashtra-based faculty data
INSERT INTO faculty (id, name, department, email, qualification) VALUES
(1, 'Ajay Deshmukh', 'Computer Science', 'ajay.deshmukh@gmail.com', 'M.Tech'),
(2, 'Sneha Patil', 'Electronics', 'sneha.patil@gmail.com', 'Ph.D'),
(3, 'Rahul Jadhav', 'Mechanical', 'rahul.jadhav@gmail.com', 'M.E'),
(4, 'Pooja Shinde', 'Electrical', 'pooja.shinde@gmail.com', 'M.Tech'),
(5, 'Nilesh Bhosale', 'Civil', 'nilesh.bhosale@gmail.com', 'Ph.D'),
(6, 'Sheetal Kadam', 'Information Technology', 'sheetal.kadam@gmail.com', 'MCA'),
(7, 'Vikram Pawar', 'Computer Science', 'vikram.pawar@gmail.com', 'M.Tech'),
(8, 'Komal Sawant', 'Electronics', 'komal.sawant@gmail.com', 'B.E'),
(9, 'Sagar Thakur', 'Mechanical', 'sagar.thakur@gmail.com', 'M.E'),
(10, 'Priya Gawande', 'Information Technology', 'priya.gawande@gmail.com', 'Ph.D');
