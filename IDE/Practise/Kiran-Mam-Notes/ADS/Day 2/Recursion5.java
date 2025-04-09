
class Recursion5 {
	
	static int sum(int n){
		if(n > 0)
			return n+sum(n-1);
		else
			return 0;
	}
	
    public static void main(String[] args) {
			
			
		
			System.out.print("Sum of nos: "+sum(10));
	}
}