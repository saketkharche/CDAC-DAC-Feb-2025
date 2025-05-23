//Fibnacci series:

//f1=0, f2=1

//series: 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, ...

class Recursion4 {
	
	static int fibonacci(int n){
		if(n <= 1){
			return n;
		}
		return fibonacci(n-1) + fibonacci(n-2);
	}
	
    public static void main(String[] args) {
		int number = 50;
		for(int i=0;i<= number;i++){
		
			System.out.print(fibonacci(i)+" ");
		}
    }
}