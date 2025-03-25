    //Let us see another example of default constructor    
    //which displays the default values    
    class Student{    
        int id;    
        String name;    
        //method to display the value of id and name    
        void display(){
            System.out.println(id+" "+name);}    
    }  
    //Main class to create objects and calling methods  
    public class Main{  
        public static void main(String args[]){    
            //creating objects    
            Student s1=new Student();    
            Student s2=new Student();    
            //displaying values of the object    
            s1.display();    
            s2.display();    
        }    
    }    