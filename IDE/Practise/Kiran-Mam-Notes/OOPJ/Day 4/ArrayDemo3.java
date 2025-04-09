import java.util.Scanner;

class ArrayDemo3{
			
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		//length : Array
		//length() : String
		
		int arr[] = new int[5];
		//Input in the array
		for(int i=0;i<arr.length;i++)
		{
			System.out.println("Enter element:");
			arr[i] = sc.nextInt();
		}
	
		/*for(int i=0;i<arr.length;i++)
		{
			System.out.println(arr[i]);
		}*/
		//For-each loop
		
		for(int a : arr){
			System.out.println(a);
		}
		
		
	}
		
		
}
