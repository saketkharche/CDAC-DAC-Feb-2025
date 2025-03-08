class Employee{
    int EmpId;
    String EmpName;
    int Salary;
    String Address;
    long MobNo;
    
    Employee(int id,String name,int sal,String add,long mob){
        this.EmpId=id;
        this.EmpName=name;
        this.Salary=sal;
        this.Address=add;
        this.MobNo=mob;
    }
    void print(){
        System.out.println(EmpId);
        System.out.println(EmpName);
        System.out.println(Salary);
        System.out.println(Address);
        System.out.println(MobNo);
    }

}
public class EmployeeManagementSystem {
    public static void main(String[] args) {
        
    }
    
}
