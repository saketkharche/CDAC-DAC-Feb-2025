// Passing Arrays to Methods

class ArrayDemo10{
			
			static void printArray(int[] arr){
				//Printing of array element
				for(int num : arr){
				System.out.println(num);
				}
			}
			
	public static void main(String args[]){
		//Declared the array
		int[] arr = {1,2,3,4,5};
		
		printArray(arr);//Called function: passing array reference
		
		
	}
		
		
}








