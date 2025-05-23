class OperatorDemo5 {
    public static void main(String[] args) {
        int a=10;
		int b=4;
		//Arithmetic 
        System.out.println(a+b);
		//Relational
		System.out.println(a<b);
		//Logical
		boolean x = true, y=false;
		System.out.println(x && y);
		System.out.println(x || y);
		System.out.println(!x);
		//Assignment
		//System.out.println(x+=5); //Error:
		System.out.println(a+=5); 
		//Bitwise 
		int m=5,n=3;
		System.out.println(m & n); 
		System.out.println(m | n); 
		System.out.println(~m); 
		
		//Bitwise shifting
		int num = 1; // Left shift									Binary 0000 0101
		int result = num << 31; // Leftside by 2					   0001 0100	
		System.out.println(num);
		System.out.println(result); 	
			
		/*int num1 = 20; // 	Positive Right shit								Binary 0000 0101
		int result1 = num1 >> 2; // Leftside by 2					   0001 0100	
		System.out.println(num1);
		System.out.println(result1); 
		
		int num2 = -20; // 	Negative Right shift								Binary 0000 0101
		int result2 = num2 >> 2; // Leftside by 2					   0001 0100	
		System.out.println(num2);
		System.out.println(result2); */
		
       
    }
}