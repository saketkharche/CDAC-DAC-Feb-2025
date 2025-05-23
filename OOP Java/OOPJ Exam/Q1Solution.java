import java.io.*;
import java.util.*;
interface VehicleFeature{
    void startEngine();
    void stopEngine();
    
}
abstract class Vehicle{
    public String brand;
    public int year;
    
    public Vehicle(String brand,int year){
        this.brand=brand;
        this.year =year;
    }
    public void displayDetails()
    {
        System.out.println("Brand: " + brand);
        System.out.println("Year: " + year);
    }
}
class Car extends Vehicle{
    private String model;
    
    public Car(String brand, int year, String model)
    {
        super(brand, year);
        this.model=model;
    }
    @Override
    public void displayDetails(){
        super.displayDetails();
        System.out.println("Model: " + model);
        
    }
}
class ElectricCar extends Car implements VehicleFeature{
    public int batteryCapacity;
    public ElectricCar(String brand,int year,String model,int batteryCapacity){
    super(brand,year,model);
    this.batteryCapacity=batteryCapacity; 
}
@Override
public void displayDetails(){
    super.displayDetails();
    System.out.println("Battery Capacity: " + batteryCapacity + " kWh");
}
public void startEngine(){
    System.out.println("Electric engine started.");
}
public void stopEngine(){
    System.out.println("Electric engine stopped.");
}
                                                        }
public class Q1Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        String brand=sc.nextLine();
        int year = sc.nextInt();
        sc.nextLine();
        String model=sc.nextLine();
        int batteryCapacity=sc.nextInt();
        ElectricCar car = new ElectricCar(brand,year,model,batteryCapacity);
        car.displayDetails();
        car.startEngine();
        car.stopEngine();
        
        
    }
}