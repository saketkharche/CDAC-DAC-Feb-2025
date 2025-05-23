class WrapperDemo{
		
    public static void main(String[] args) {
		
		int a =20;//Primitive data
		//Autoboxing: Primitve to wrapper class object
		
		Byte b = Byte.valueOf("20");
		Short s = Short.valueOf("20");//
		Integer i = Integer.valueOf(a);
		Long  l = Long.valueOf("20");
		
		Integer j = a;
		
		System.out.println(j);
      
    }
}
