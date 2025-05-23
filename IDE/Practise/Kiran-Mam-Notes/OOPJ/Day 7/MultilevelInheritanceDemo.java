class Animal{
	int id =5;
	void display(){
		System.out.println("Parent class: P1");
	}
}


class Dog extends Animal{
	int cid =4;
	void childDisplay(){
		System.out.println("Child class: C1");
	}
}


class Babydog extends Dog{
	int bcid =6;
	void babyDisplay(){
		System.out.println("BabyChild class: BC1");
	}
}


class MultilevelInheritanceDemo{
	public static void main(String args[]){
		Babydog b1 = new Babydog();
		b1.babyDisplay();
		b1.childDisplay();
		b1.display();
		
		System.out.println(b1.id);
		System.out.println(b1.cid);
		System.out.println(b1.bcid);
		
	}	
}
