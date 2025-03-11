	class Employee{
		int i;
		String name;
		int age;
		
		
		//constructor overloading
		Employee(){
			System.out.println(i+name);
		}
		//2 parameters
		Employee(int i, String name){
			this.i = i;
			this.name = name;
			System.out.println(i+name);
		}
		//3 parameters
		Employee(int i, String name, int age){
			this.i = i;
			this.name = name;
			this.age = age;
			System.out.println(i+name+age);
		}
		//3 parameters
		Employee(int i, int age, String name ){
			this.i = i;
			this.name = name;
			this.age = age;
			System.out.println(i+name+age);
		}
		
		
	}
	class EmployeeDemo8{
		public static void main(String args[]){
			
			
			Employee e1 = new Employee(1,"Rama",22);
			Employee e = new Employee();
			Employee e2 = new Employee(11,"Ramayan",32);
			
		}
		
		
	}