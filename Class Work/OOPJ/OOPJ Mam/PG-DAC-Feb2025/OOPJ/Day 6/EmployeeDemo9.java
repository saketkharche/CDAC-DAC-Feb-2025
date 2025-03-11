	class Employee{
		int i;
		String name;
		int age;
		
		
		//constructor overloading
		Employee(){
			
			//System.out.println(i+name);
		}
		//2 parameters
		Employee(int i, String name){
			this();
			this.i = i;
			this.name = name;
			
			System.out.println(i+name);
		}
		//3 parameters
		Employee(int i, String name, int age){
			this(11,"Abc");
			this.i = i;
			this.name = name;
			this.age = age;
			System.out.println(i+name+age);
		}
		//3 parameters
		Employee(int i, int age, String name ){
			this();
			this.i = i;
			this.name = name;
			this.age = age;
			System.out.println(i+name+age);
		}
		
		
	}
	class EmployeeDemo9{
		public static void main(String args[]){
			
			Employee e = new Employee();
			Employee e1 = new Employee(11, "ccvv");
			Employee e2 = new Employee(111, 45, "sdfg");
			Employee e11 = new Employee(11, "ccvv", 34);
		}
		
		
	}