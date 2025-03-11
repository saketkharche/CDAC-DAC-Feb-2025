class Engine{
	String type;
	
	Engine(String type){
		this.type = type;
	}
}

class Car{
	String model;
	Engine e;//Composition (Strong HAS-A Relationship)
	
	Car(String model, String type)
	{
		this.model =model;
		this.e = new Engine(type);//Creating an object inside the constructor
	}
	
	void display()
	{
		System.out.println(model+" "+e.type);
	}
}

class CompositionDemo{
	public static void main(String args[]){
		
		Car c1 = new Car("BMW","X6");
		c1.display();
		
		
	}
}