package com.mycompany.cdacjava;

class Circle{
    public double radius;
    
    public double area(){
        return Math.PI *radius*radius;
        
    }
    
    public double perimeter(){
        return 2*Math.PI*radius;
    }
    public double circumference(){
        return perimeter();
    }
    
}

public Cylinder extends Circle{
    public double height;
    public double volume(){
return area()*height;
}
}
public class Main {
    
}
