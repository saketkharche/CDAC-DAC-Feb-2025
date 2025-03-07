	class Employee{
		int i;
		String name;
		
		 Employee(){
			this.i = 100;
			this.name="unknown";
			System.out.println("Default");
			
		}
		
		 Employee(int i,String name){
			this.i = i;
			this.name=name;
			System.out.println("Parameterized");
		}
		
		void data(String name,int i)
		{
			this.i = i;
			this.name=name;
			
		}
		
		
		static void data1(String name,int i)
		{
			i = i;
			name=name;
			
		}
		class EmployeeDemo{

		public static void main(String args[]){
			
			Employee e = new Employee();
			e.data("dffd1",1232);
			Employee e1 = new Employee(7232,"sdsf");
			Employee.data1("dffd",232);
			
		}
		
	}
	}