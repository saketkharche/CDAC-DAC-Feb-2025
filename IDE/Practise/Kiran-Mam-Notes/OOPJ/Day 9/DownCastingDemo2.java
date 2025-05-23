

class Animal{
	void show(){
		System.out.println("Parent class");
	}
	
}
class Cat extends Animal{
	void show(){
		System.out.println("Child class");
	}
	
}


class DownCastingDemo2{	
	public static void main(String args[]){//method
			//case 1
			Animal a = new Cat();//Upcasting: 
			Cat c = (Cat) a;//Downcasting
			c.show();//child method 
			
			//case 2
			/*Animal a1 = new Animal();
			Cat c1 = (Cat) a1;//Downcasting: Exception
			c1.show();//child method */
			
			//case 3
			Animal a2 = new Cat();//Upcasting: 
			
			if(a2 instanceof Cat){
				Cat c2 = (Cat) a2;
				c2.show();//child method 
			}else{
				System.out.println("Downcasting : Not Possible");
			}
			
			//case 4
			Animal a3 = new Animal();
			if(a3 instanceof Cat){
				Cat c3 = (Cat) a3;
				c3.show();//child method 
			}else{
				System.out.println("Downcasting : Not Possible");
			}
			
			
	
	
	}
	
	
}

