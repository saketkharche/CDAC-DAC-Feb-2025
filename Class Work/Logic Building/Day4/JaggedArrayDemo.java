class JaggedArrayDemo{
	public static void main(String args[]){ 
	
	int[][] arr1 = new int[3][];
	
	arr1[0] = new int[2];
	arr1[1] = new int[4];
	arr1[2] = new int[3];
	
	//arr2[3]

	//System.out.println(arr1[0][0]);
 
	for(int i = 0; i<arr1.length;i++){
		for(int j = 0; j<arr1[i].length;j++){
		System.out.print(arr1[i][j]+" ");		
	}
	System.out.println();
	}


	
	for(int i = 0; i<3;i++){
		for(int j = 0; j<4;j++){
		
		arr1[i][j]=10;		
	}
	}
	

/* row size 3
col = null

arr1[0] = 2 
     1	= 4
     2  = 3	


i	j		sop
0	0		10(arr1 0,0)
	1		10(arr1 0,1)
	2		--------




















i    j			sop
0    0			0_0_ 
     1			0_0_0_0_
     2			0_0_0_
1    0
     1	
     2 		
     3
     4		
2    0 
     1
     2		
     3
















*/








	

	}	
}