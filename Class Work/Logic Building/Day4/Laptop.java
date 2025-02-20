class Laptop{
	int ram;
	String name;
	double price;

	void accessCamera(){
		System.out.println(" in accessCamera() ");

	}
	
	String display(){
		System.out.println("Inside display()");
		return "Details of Laptop :"+ram+" "+name+" "+price;
	}
	
	/*
	public static void main(String args[]){ 
	System.out.println(" laptop class ");
	}*/

/* 	RT name() 

	void, DT, Array, Objects	
*/

	
}


class LaptopDemo{

	public static void main(String args[]){ 
	int a = 10;

	//Laptop laptopObj = new Laptop(); //heap
	//Laptop laptopObj1 ; // ref variable
 	
	//System.out.println(laptopObj.ram);
	//System.out.println(laptopObj.name);
	//System.out.println(laptopObj.price);
	//laptopObj.accessCamera();
	
	//String s = laptopObj.display();
	//System.out.println(s);

	//System.out.println(laptopObj.display());

	laptopObj.display();

	}


}	
	