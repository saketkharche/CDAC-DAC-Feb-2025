
package Day03;

class LSearch{
	
	static int search(int arr[],int x){
		int n = arr.length;
		for(int i=0;i<n;i++){
			if(arr[i] == x){
				return i;//2
			}
		}
		return -1;
		
	}
	
	public static void main(String[] args) {
		
		int arr[] = {10,50,70,30,20};
		int key =50;
		int result = search(arr, key);
		if(result == -1)
			System.out.println("Element not found!");
		else
			System.out.println("Element found!");
		
		
		
	}
}