//Method 2
//Sorting Approach 
//Time Complexity: O(n^2)
//Space complexity: O(1)


package Day03;


import java.util.*;

class ArrayDuplicateDemo1{
	
	public static void main(String[] args) {
		int[] arr = new int[] {1,2,3,4,2,7,8,8,3};
		//unsorted array
		System.out.println(Arrays.toString(arr));
		//sorted arrays
		Arrays.sort(arr);//O(nlogn)
		System.out.println(Arrays.toString(arr));
		
		//Logic for duplicate identification
		for(int i=0;i<arr.length-1;i++){
			
				if(arr[i] == arr[i+1])
					System.out.println(arr[i]);
		}
		
		
		
	}
}