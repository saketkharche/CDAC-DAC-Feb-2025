

class Qsort{
	
	static void quicksort(int arr[], int low, int high){
	
		if(low < high)
		{
			int pi = partition(arr, low, high);
			quicksort(arr, low, pi-1);//Left array : P1
			quicksort(arr, pi+1, high);//Right array : P2
			
		}
	}
	
	static int partition(int arr[], int low, int high){
		int pivot = arr[high];
		int i = low-1;
		for(int j=low;j<=high-1;j++){
			if(arr[j] < pivot)
			{
				i++;
				swap(arr,i,j);
			}
			
		
		}
		swap(arr, i+1, high);
		return(i+1);
	}
	
	static void swap(int arr[], int i, int j){
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	void display(int arr[]){
		int n = arr.length;
		for(int i=0;i<n;i++){
			System.out.print(arr[i]+" ");
		}
	
	}
	
	
	public static void main(String[] args) {
		
		int arr[] = {99,44,77,22,88,33,11,66,55};
		int n = arr.length;
		Qsort q1 = new Qsort();
		//h1.heapsort(arr);
		quicksort(arr, 0 , n-1);
		q1.display(arr);
		
		
		
		
		
		
	}		
}