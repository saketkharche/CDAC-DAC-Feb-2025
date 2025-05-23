	class Employee{
		int i;
		String name;
		
		/*Employee(){
			System.out.println(i+name);
		}*/
		
		/*Employee(){
			this.i = 100;
			this.name="unknown";
			System.out.println("Default");
			System.out.println(i+" "+name);
		}*/
		
		Employee(int i,String name){
			this.i = i;
			this.name=name;
			System.out.println("Parameterized");
			System.out.println(i+" "+name);
		}
		
		//Copy constructor
		Employee(Employee emp){
			this.i = emp.i;
			this.name=emp.name;
			System.out.println("Copy constructor");
			System.out.println(i+" "+name);
		}
		
		void data(String name,int i)
		{
			this.i = i;
			this.name=name;
			System.out.println(i+" "+name);
			
		}
		
		
		static void data1(String name,int i)
		{
			i = i;
			name=name;
			System.out.println(i+" "+name);
			
		}
	}
	class EmployeeDemo5{
		public static void main(String args[]){
			
			Employee e1 = new Employee(7232, "sdsf");
			Employee.data1("dffd",232);
			
			Employee e = new Employee();
			e.data("dffd1",1232);
			
			Employee e1 = new Employee(7232, "sdsf");
			Employee.data1("dffd",232);
			
			Employee emp1 = new Employee(e1);
			
		}
		
		
	}