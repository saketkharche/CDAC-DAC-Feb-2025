import java.util.Scanner;

class ArrayDemo8{
			
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in); 
		int arr[][] = new int[3][3];
		
		//Input:
		for(int i=0;i<3;i++){//Row
			for(int j=0;j<3;j++){//Col
				System.out.println("Enter element:");
				arr[i][j] = sc.nextInt();
			}
		}
		
		
		System.out.println("------------------");
		for(int ar[] : arr)
		{
			for(int x : ar){
			
			System.out.print(" "+x);
			}
			System.out.println();
			
		}
	}
		
		
}
