# Home-work

Implement the following questions to understand Exception handling properly:

### **Unchecked Exceptions (Runtime Exceptions)**
Unchecked exceptions extend `RuntimeException` and do not require explicit handling with `throws` or `try-catch`.  

#### **1. Implement `NullPointerException`**  
Write a Java program where you initialize a `String` as `null` and try to call the `.length()` method on it. Handle the exception using a `try-catch` block.  

#### **2. Implement `ArithmeticException`**  
Write a Java program that performs **division by zero** and catches the `ArithmeticException`.  

#### **3. Implement `ArrayIndexOutOfBoundsException`**  
Create an array of 5 elements and try to access an index that does not exist (e.g., index `10`). Handle the exception properly.  

#### **4. Implement `NumberFormatException`**  
Write a Java program that tries to convert a **non-numeric string** to an integer using `Integer.parseInt()` and catches the `NumberFormatException`.  

#### **5. Implement `IllegalArgumentException`**  
Write a Java method `setAge(int age)` that throws an `IllegalArgumentException` if the age is negative or greater than 150.  

---

### **Checked Exceptions**
Checked exceptions extend `Exception` and must be either **handled using `try-catch`** or **declared with `throws`**.  

#### **6. Implement `IOException`**  
Write a Java program that attempts to read from a file that does not exist and catches `IOException`.  
#### **7. Implement `FileNotFoundException`**  
Write a Java program that tries to open a file that does not exist using `FileReader`, and handle the `FileNotFoundException`.  



