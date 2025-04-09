

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
	
	void ssort(int arr[]){
		int n = arr.length;
		for(int i=0;i<n-1;i++){
			int min = i;
			for(int j=i+1;j<n;j++){
				if(arr[j] < arr[min])
					min = j;
		
			}
			int temp = arr[min];
			arr[min] = arr[i];
			arr[i] = temp;
		}
	}
	
	void isort(int arr[]){
		int n = arr.length;
		for(int i=1;i<n;i++){
			int key = arr[i];//element to be shifted
			int j=i-1;
			
			//shifting elements
			while(j>=0 && arr[j] > key){
				arr[j+1] = arr[j];
				j=j-1;
			}
			arr[j+1] = key;
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
		//b1.bsort(arr);
		//b1.ssort(arr);
		b1.isort(arr);
		b1.display(arr);
		
		
		
		
		
		
		
		
	}		
}