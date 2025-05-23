class ToStringDemo{
	String name;
	int id;
	
	ToStringDemo(String name, int id){
		this.name = name;
		this.id =id;
	}
	
	@Override//done overriding with toSting() of Object class
	public String toString(){
		return name+ " " +id;//return Sting values of id and name
		
	}
	
    public static void main(String[] args) {
		ToStringDemo t1 = new ToStringDemo("Abc",111);
		System.out.println(t1);//By default toSting method is called 
		
      
    }
}