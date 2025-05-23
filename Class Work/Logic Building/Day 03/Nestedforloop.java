class Nestedforloop{
  public static void main(String[] args) {
    // for (int a=10;a>=5 ;a-- ) {
    //   for (int b=10;b>=5 ;b-- ) {
    //     System.out.println(a+" "+b);
//}
    // int a =10;
    // int b =20;
    // int c = b++ + --b + a++ - a++;
    //
    // System.out.println(c);

  
        int a = 10;
        int b = 20;

        System.out.println("Initial values: a = " + a + ", b = " + b);

        // Post-increment b++
        int postIncrementB = b++;
        System.out.println("After post-increment b++: b = " + b + " (postIncrementB = " + postIncrementB + ")");

        // Pre-decrement --b
        int preDecrementB = --b;
        System.out.println("After pre-decrement --b: b = " + b + " (preDecrementB = " + preDecrementB + ")");

        // Post-increment a++
        int postIncrementA1 = a++;
        System.out.println("After first post-increment a++: a = " + a + " (postIncrementA1 = " + postIncrementA1 + ")");

        // Post-increment a++ again
        int postIncrementA2 = a++;
        System.out.println("After second post-increment a++: a = " + a + " (postIncrementA2 = " + postIncrementA2 + ")");

        // Final computation
        int c = postIncrementB + preDecrementB + postIncrementA1 - postIncrementA2;
        System.out.println("Final value of c: " + c);


    }
  }
