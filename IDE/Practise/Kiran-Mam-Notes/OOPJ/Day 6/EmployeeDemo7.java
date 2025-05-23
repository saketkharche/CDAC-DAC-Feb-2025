	class Employee{
		int i;
		String name;
		
		Employee(){
			System.out.println(i+name);
		}
		Employee(int i, String name){
			this.i = i;
			this.name = name;
			System.out.println(i+name);
		}
		
		
	}
	class EmployeeDemo7{
		public static void main(String args[]){
			
			
			Employee e1 = new Employee(1,"Rama");
			Employee e = new Employee();
			
		}
		
		
	}