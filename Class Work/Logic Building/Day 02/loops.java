class loops{
  public static void main(String[] args) {


    // for (int a =10; a>=5 ;a-- ) {
    //   System.out.println(a);}

    // unrechable statement
    // for (int a =10; false ;a-- ) {
    //   System.out.println(a);
    //
    // }

    // for (int a =10; true ;a-- ) {
    //   System.out.println(a);
    // }
    for (int a =10, b=20; (a==5) || (b>=15) ;a--,b-- )
    {
      System.out.println(a+""+b);
    }


    System.out.println("Outside for");
  }
}
