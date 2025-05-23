class SwitchDemo2{
	public static void main(String args[]){
	int a = 257;
	char b = 'a';
	switch(a){
		default:
			System.out.println(" Default Case");
			break;
		case 'v':
			System.out.println(10);
			break;
		case 'c':
			System.out.println(20);
			break;
		case 'b':
			System.out.println(30);
			break;
		case 97:
			System.out.println(40);
			break;

		
	}
	
	System.out.println(" Outside Switch"); 

	}
}