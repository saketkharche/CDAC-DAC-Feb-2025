

class Bsort{
	void bsort(int arr[])
	{
		int n = arr.length;
		for(int i =0 ;i<n-1;i++){
			for(int j=0;j<n-i-1;j++){
				if(arr[j] > arr[j+1])
				{
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
			
			
		
		}
	}
	
	void display(int arr[]){
		int n = arr.length;
		for(int i=0;i<n;i++){
			System.out.print(arr[i]+" ");
		}
	
	}
	
	
	public static void main(String[] args) {
		
		int arr[] = {99,44,77,22,88,33,11,66,55};
		Bsort b1 = new Bsort();
		
		b1.display(arr);
		System.out.println();
		b1.bsort(arr);
		b1.display(arr);
		
		
		
		
		
		
	}		
}