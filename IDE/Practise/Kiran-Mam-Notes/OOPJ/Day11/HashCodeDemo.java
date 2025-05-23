class HashCodeDemo{
	String name;
	int id;
	
	HashCodeDemo(String name, int id){
		this.name = name;
		this.id =id;
	}
	
	@Override
	public int hashCode(){
		return id;//Using id as a unique hash code must be return
		
	}
	
    public static void main(String[] args) {
		HashCodeDemo t1 = new HashCodeDemo("Abc",111);
		System.out.println(t1.hashCode());
		
      
    }
}