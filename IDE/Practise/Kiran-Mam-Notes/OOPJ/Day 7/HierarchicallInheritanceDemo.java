class Animal{
	void eat(){
		System.out.println("Parent class: Eat()");
	}
	
}

class Dog extends Animal{
	void bark(){
		System.out.println("Child class1: Bark()");
	}
}

class Cat extends Animal{
		void sound(){
		System.out.println("Child class2: Sound()");
	}
}

class HierarchicallInheritanceDemo{
	public static void main(String args[]){
		Cat c1 = new Cat();
		c1.eat();
		c1.sound();
		//c1.bark();
		
		Dog c11 = new Dog();
		c11.eat();
		//c11.sound();
		c11.bark();
		
		
	}	
}
