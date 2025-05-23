// Cloning Array

class ArrayDemo13{
		
			
	public static void main(String args[]){
		int clonearr[] = new int[5];
		
		for( int x : clonearr){
			System.out.println(x);
		}
		//-----------------------
		int arr[] = {10,20,30};
		int clonearr[] = arr.clone();
		
		System.out.println(arr == clonearr);
		System.out.println(arr[0] == clonearr[0]);
		
		
		for( int x : arr){
			System.out.println(x);
		}
		System.out.println("------------");
		for( int x : clonearr){
			System.out.println(x);
		}
		int arr[] = {10,20,30,40,50};	
		for( int x : clonearr){
			System.out.println(x);
		}
	
	}
		
		
}








