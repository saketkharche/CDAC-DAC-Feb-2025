class Employee{
    private int empId;
    //instance variable
    private String empName;
    private static int total;

    //Instance Method
    void set (int id,String name,int t){
        empId = id;
        empName = name;
        total = t;
    }
    //static method
    static int add(int a,int b){
        System.out.println(a+b);

        return a+b;


    }
    //instance method
    void show(){
        System.out.println(empId+" "+empName+" "+total);

    }

}
class Main{
    public static void main(String[] args) {
        Employee e1 =new Employee();
        e1.set(111,"saket",11);
        e1.show();

        Employee e2 = new Employee();

        e1.set(22,"kharche",2345);
        e1.show();

        Employee.add(2,3);
        System.out.println(Employee.add(5,7));
        Employee.add(5,7);
        System.out.println("addition ="+ Employee.add(15,65));

    }
}