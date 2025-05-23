class ArrDemo{
  public static void main(String[] args) {
    //int a[]={1,2,3,4};
    //int b[]=new int[5];
    //float f[]=new float[5];
    //char c[]=new char[5];
    //String s[]=new String[5];
    //boolean bl[]=new boolean[5];

    // System.out.println(a);
    // System.out.println(b);
    // System.out.println(a[0]);
    // System.out.println(b[0]);
    // System.out.println(f[0]);
    // System.out.println(c[0]+ " "+c[1]+"char");
    // System.out.println(s[0]);
    // System.out.println(bl[0]);
    // b[0]=10;
    // b[1]=10;
    // b[2]=10;
    // b[3]=10;
    // b[4]=10;


    // for (int a=0;a<5 ;a++ ) {
    //   b[a]=a;
    //   //System.out.println(b[0]);
    //
    // }
    // for (int a=0;a<5 ;a++ ) {
    //   System.out.println(b[a]);
    //
    // }

    int a[][]={{1,2,3,4},{5,6,7,8}};
  /*  for (int i=0;i<2 ;i++ ) {
      for (int j=0;j<4 ;j++ ) {
        System.out.print(a[i][j]);
      }
      System.out.println();

    }*/
    for (int i=0;i<a.length ;i++ ) {
        for (int j=0;j<a[i].length ;j++ ) {
          System.out.print(a[i][j]);
        }
        System.out.println();

      }
  }
}
