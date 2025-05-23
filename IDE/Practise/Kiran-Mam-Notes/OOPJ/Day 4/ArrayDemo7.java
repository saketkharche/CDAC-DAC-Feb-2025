import java.util.Scanner;

class ArrayDemo7{
			
	public static void main(String args[]){
		int arr1[][] = new int[2][];
		int arr2[][] = new int[4][3];
		
		
		
		for(int ar[] : arr1)
		{
			System.out.println("*");
			
		}
		System.out.println("------------------");
		for(int ar[] : arr2)
		{
			for(int x : ar){
			
			System.out.print("$");
			}
			System.out.println();
			
		}
	}
		
		
}
