class Q3{
  public static void main(String[] args) {
    int n = 1546;
    int sum =0;

    while(n>0){
      int lastDigit=n%10;
      sum =sum + lastDigit;
      n=n/10;

    }
    System.out.print(sum);
  }
}