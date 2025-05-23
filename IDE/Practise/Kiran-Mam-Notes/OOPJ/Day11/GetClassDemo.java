class GetClassDemo{
		
    public static void main(String[] args) {
		GetClassDemo g1 = new GetClassDemo();
		System.out.println(g1.getClass().getName());
		
      
    }
}
Note:
------
Class   ----->   Object ? instanceof (true/flase)


Object  ------>  Class  ? getClass()

Object  ------>  Class  (Name)? getClass().getName()