class ArrayDemo{
	public static void main(String args[]){ 
	
	//int i;
	//System.out.println(i);

	//int a[] = {1,2,3,4};
	//int b[] = new int[5];    //b.length - 5
	//float f[] = new float[5];
	//char c[] = new char[5];


	//System.out.println(a); // prints the hashcode
	//System.out.println(b); // prints the hashcode

	//System.out.println(a[0]);// 1 
	//System.out.println(b[0]);
	//System.out.println(f[0]);
	//System.out.println(c[0]);

	/*b[0]=10;
	b[1]=10;
	b[2]=10;
	b[3]=10;
	b[4]=10;*/
	
	/*
	for(int a = 0; a<5;a++){
		b[a]=10;
	}

	for(int a = 0; a<5;a++){
		System.out.println(b[a]);
	}
	*/


	int a[][] = {
			{1,2,3,4},
			{5,6,7,8}
		    };

	/*for(int i = 0; i<2;i++){
		for(int j = 0; j<4;j++){
			System.out.print(a[i][j]);
		}
	System.out.println();
	}*/
	
	
	for(int i = 0; i<a.length;i++){
		for(int j = 0; j<a[i].length;j++){
			System.out.print(a[i][j]+" ");
		}
	System.out.println();
	}
	
	//System.out.print(a.length);
	//System.out.print(a[0].length);
	//System.out.print(a[1].length);

int arr[][];
//int arr1[4][4]={{1},{1,2},{1,2,3},{1,2,3,4}};
//int arr2[][4];

int arr1[][] = new int[2][2];
//int arr2[][] = new int[][4];

	for(int i = 0; i<arr1.length;i++){
		for(int j = 0; j<arr1[i].length;j++){
		arr1[i][j]=10;		
	}
	System.out.println();
	}

	for(int i = 0; i<arr1.length;i++){
		for(int j = 0; j<arr1[i].length;j++){
		System.out.print(arr1[i][j]);		
	}
	System.out.println();
	}


	
	






























	

	}
}