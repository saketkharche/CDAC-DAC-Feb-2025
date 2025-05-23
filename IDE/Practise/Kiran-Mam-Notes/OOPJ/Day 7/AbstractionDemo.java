
abstract class Shape{
	abstract void draw();
	
	
}

class Circle extends Shape{
	 void draw();
	{
		System.out.println("Draw: Circle");
	}
}

class Rectangle extends Shape{
	void draw(){
		System.out.println("Draw: Rectangle");
	}
}

class AbstractionDemo{
	public static void main(String args[]){
		Shape s1 = new Circle();
		s1.draw();
		
		
		Shape s2 = new Rectangle();
		s2.draw();
		
		Rectangle s3 = new Rectangle();//Normal class execution
		s2.draw();
		
		//Shape s4 = new Shape();//Error: abstraction
		s4.draw();
	}	
}