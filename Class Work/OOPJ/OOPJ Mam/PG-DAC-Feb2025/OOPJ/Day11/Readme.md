# Homework:
### Ques.1 

Create an **abstract class `Shape`** that represents different geometric shapes. This class should contain:  
1. A **protected attribute** `shapeName` to store the name of the shape.  
2. A **constructor** that initializes `shapeName`.  
3. A **method `getShapeName()`** that returns the name of the shape.  
4. An **abstract method `calculateArea()`** that will be implemented by subclasses.  

Next, create two concrete classes, **`Circle`** and **`Rectangle`**, that extend `Shape` and implement the `calculateArea()` method:  
- The `Circle` class should have a **private attribute `radius`**, a constructor to initialize it, and implement `calculateArea()` using the formula:  
![image](https://github.com/user-attachments/assets/0a1b861d-a3eb-497f-85cd-56c08e6d9606)
 
- The `Rectangle` class should have **private attributes `length` and `width`**, a constructor to initialize them, and implement `calculateArea()` using the formula:  
![image](https://github.com/user-attachments/assets/6bf43225-3c1e-4b19-889b-c81b5b87f74b)

Finally, write a **test program** in the `main` method that:  
1. Creates an object of `Circle` with a radius of `5.0` and displays the area.  
2. Creates an object of `Rectangle` with a length of `4.0` and width of `6.0` and displays the area.  
3. Uses **polymorphism** by referring to objects of `Circle` and `Rectangle` using `Shape` references.  


Note: Implement the concepts of **abstraction, method overriding, polymorphism, and encapsulation in Java OOP concepts**.

---

### Ques.2

Create an **interface `Photosynthesis`**, which represents the ability of plants to absorb sunlight and perform photosynthesis. This interface should contain a method `void absorbSunlight();` that defines how plants absorb sunlight. Additionally, create another **interface `Respiration`**, which represents the respiration process in plants. This interface should include a method `void releaseOxygen();` that defines how plants release oxygen.  

Next, implement a **concrete class `Plant`** that inherits from both interfaces, demonstrating multiple inheritance. The `Plant` class should have a **private attribute `plantName`** to store the name of the plant, which should be initialized using a constructor `Plant(String name)`. Additionally, it should have a method `getPlantName()` to return the name of the plant. The class should override the `absorbSunlight()` method to print the message **"Plant is absorbing sunlight for photosynthesis."** and override the `releaseOxygen()` method to print **"Plant is releasing oxygen through respiration."**.  

In the main method, test the implementation by creating objects of the `Plant` class for two different plants: `"Mango Tree"` and `"Fern"`. For each object, display the plant's name, call the `absorbSunlight()` method, and call the `releaseOxygen()` method.  

===

### Ques.3

### **Java Coding Question (20 Marks)**  

Implement **Runtime Polymorphism** in Java using a **BMW vehicle hierarchy**. Create a **parent class `BMW`** with two methods: `showDetails()`, which prints `"This is a BMW vehicle."`, and `maxSpeed()`, which prints `"Speed varies by model."`.  

Extend this class into **three subclasses**: `BMWSeries3`, `BMWSeries5`, and `BMWSeries7`, each overriding the methods to display their respective series names and max speeds (`240 km/h`, `260 km/h`, and `300 km/h`).  

In the `main` method, create an **array of `BMW` references**, assign subclass objects, and use a loop to call `showDetails()` and `maxSpeed()`. The program should demonstrate **method overriding, runtime polymorphism, and dynamic method dispatch**.
