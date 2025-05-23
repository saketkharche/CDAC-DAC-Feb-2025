class ArrayDemo{
	public static void main(String args[]){ 
int a;
	
	int[][] arr1 = new int[3][3]; 

	System.out.println(arr1.length); 
	System.out.println(arr1[0].length);
	System.out.println(arr1[1].length);
	System.out.println(arr1[2].length);
	for(int i = 0; i<arr1.length;i++){
		for(int j = 0; j<arr1[i].length;j++){
		System.out.print(arr1[i][j]+" ");		
	}
	System.out.println();
	}

	for(int i = 0; i<3;i++){
		for(int j = 0; j<3;j++){
		
		arr1[i][j]=10;		
	}
	}

	for(int i = 0; i<arr1.length;i++){
		for(int j = 0; j<arr1[i].length;j++){
		System.out.print(arr1[i][j]+" ");		
	}
	System.out.println();
	}


	}
}