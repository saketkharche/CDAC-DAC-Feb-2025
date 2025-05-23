class Laptop1{
	int ram;
	String name;
	double price;

	Laptop1(){
		ram = 8;
		name = "HP";
		price = 50000.0;
		System.out.println(" in laptop constr. ");
	}

	Laptop1(int a, String s, double d){
		ram = a;
		name = s;
		price = d;
		System.out.println(" in laptop 3 para constr. ");
	}


	void accessCamera(){
		System.out.println(" in accessCamera() ");

	}

	String display(){
		System.out.println("Inside display()");
		return "Details of Laptop :"+ram+" "+name+" "+price;
	}

	}


class LaptopDemo1{

	public static void main(String args[]){

	Laptop1 laptopObj = new Laptop1();

	Laptop1 laptopObj1 = new Laptop1(16,"Dell",60000.0);

	System.out.println(laptopObj.display());
	System.out.println(laptopObj1.display());



	}


}
	
