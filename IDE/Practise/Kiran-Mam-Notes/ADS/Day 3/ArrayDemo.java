
class ArrayDemo {
	static int a1[] = new int[15];
	static int n=0;
	
	//display
	static void display(){
		for(int i=0;i<n;i++){
			System.out.print(a1[i]+" ");
		}
	}
	
	//Insertion method:
	static void insert(int value){
		if(n < a1.length){
			a1[n] = value;
			n++;
			
		}else{
			System.out.print("Array is full!");
		}
		
	}
	
	//Key element Find operation:
	static boolean find(int key){
		for(int i=0;i<n;i++){
			if(a1[i] == key){
				return true;
			}
		}
		return false;
		
	}
		
	//Deletion operation:
	static void delete(int key){
		int i;
		//find element
		for( i=0;i<n;i++){
			if(a1[i] == key){
				break;//Found: exit the loop
			}
		}
		//If element doesnot exist
		if(i == n){
			System.out.println("Element doesnot exist!");
			return;
		}
		//If exist then shifting the elements
		for(int k=i;k<n;k++){
			a1[k] = a1[k+1];//shifting of all elements
		}
		n--;
		
	}
	
		
    public static void main(String[] args) {
		
		
		display();
		System.out.print("\n---------------------------\n");
		insert(10);
		insert(20);
		insert(30);
		insert(40);
		insert(50);
		//insert(40);
		
		System.out.print("\n---------------------------\n");
		display();
		
		System.out.print("\n---------------------------\n");
		/*int key =40;
		if(find(key))
			System.out.print("Element found! "+ key);
		else
			System.out.print("Element not found! "+ key);*/
		
		System.out.print("\n---------------------------\n");	
		int key =20;
		delete(key);	
			
		display();
	}
}