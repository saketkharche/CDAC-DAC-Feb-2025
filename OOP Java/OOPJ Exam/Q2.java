import java.io.*;
import java.util.*;
Class Customer{
    int customerId;
    String customerName;
    double totalSpending;
    int loyaltyLevel;
    String JoiningDate;
    
    public Customer(int customerId,String customerName,double totalSpending,int loyaltyLevel,String JoiningDate){
        this.customerId=customerId;
        this.customerName=customerName;
        this.totalSpending=totalSpending;
        this.loyaltyLevel=loyaltyLevel;
        this.JoiningDate=JoiningDate;
    }
}

public class Q2Solution {

    public static void main(String[] args) {
        Sccanner sc=new Scanner(System.in);
            int n =Interger.parseInt(sc.nextLine());
        List<Customer> customers=new ArrayList<>();
        for(int i;i<n;i++){
            int customerId=nextInt();
            int customerName=sc.next();
            double totalSpending= sc.nextDouble();
            int loyaltyLevel=sc.nextInt();
            String JoiningDate =sc.next();
            customers.add(new Customer(customerID,customerId,customerName,totalSpending,loyaltyLevel, JoiningDate));
        }
        customers.sort((a,b)->{
            if(Double.compare(b.totalSpending,a.totalSpending)!=0)
                return
                Double.compare(b.totalSpending,a.totalSpending);
            if(a.loyaltyLevel !=b.loyaltyLevel)
                return
                Interger.compareTo(a.totalSpending,b.totalSpending);
            return
                a.totalSpending.compareTo(b.JoingDate);
        });
        System.out.println("Sorted by Total Spending: ");
        for(Customer c:customer ){
            System.out.println(c.customerId + " => " + c.customerName + ", Spending: " + String format("%.2f",c.totalSpending)+", Loyalty Level: "+ c.loyaltyLevel + ", Joined: "+ c.JoiningDate);
            
        }
        customer.sort((a,b)->{
            if(!a.JoiningDate.equals(b.JoiningDate))
                return
                a.JoiningDate.compareTo(b.JoiningDate);
            if(a.loyaltyLevel!=b,loyaltyLevel)
                return
                Integer.compare(a.loyaltyLevel,b.loyaltyLevel)
                return
                a.customerName.compareTo(b.customerName);
            
        });
        System.out.println("\nSorted by Joining Date:");
        for(Customer c:customers){
            System.out.println(c.customerId+ "=> "+c.ccustomerName+", Spending: "+ String format("%.2f",c.totalSpending)+", Loyalty Level: "+ c.loyaltyLevel + ", Joined: "+ c.JoiningDate);
        }
        sc.close();
    }
}