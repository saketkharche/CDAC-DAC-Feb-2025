

class Hsort{
	
	void heapify(int arr[],int n, int i){
		
		int largest = i;//Parent
		int l = 2*i+1; //LC
		int r = 2*i+2; //RC
		
		
		//LC = largest
		if(l < n && arr[l] > arr[largest])
			largest = l;
		//RC = largest
		if(r < n && arr[r] > arr[largest])
			largest = r;
		
		//swap
		if( largest != i){
			int temp = arr[i];
			arr[i] = arr[largest];
			arr[largest] = temp;
			
			heapify(arr, n, largest);
		}
	}
			
		
		void heapsort(int arr[]){
			int n =arr.length;
			
			for(int i=n/2-1;i>=0;i--){
				heapify(arr,n,i);
			}
			
			for(int i=n-1;i>0;i--){
				int temp = arr[0];
				arr[0] = arr[i];//root=last node
				arr[i] = temp;
				
				heapify(arr,i,0);
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
		Hsort h1 = new Hsort();
		h1.heapsort(arr);
		h1.display(arr);
		
		
		
		
		
		
	}		
}