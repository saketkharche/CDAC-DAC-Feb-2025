class Node{
	int data;
	Node next;
	Node(int d)
	{
		data = d;
		next = null;
	}
}

class StackDemo3{
	Node head;
	
	StackDemo3()
	{
		this.head = null;
	}
	
	boolean IsEmpty(){
		return head == null;
	}
	
	void push(int new_data){
		Node new_node = new Node(new_data);
		new_node.next = head;
		head = new_node;
		
	}
	
	void pop(){
		
		if(IsEmpty()){
			System.out.println("Stack Underflow!!!");
			return;
		}
		Node temp = head;
		head = head.next;
		temp.next = null;
		temp = null;
		
		
	}
	
	int peek(){
		if(!IsEmpty())
			return head.data;
		else{
			System.out.println("Stack Underflow!!!");
			return -1;
		}
	}
	
	public static void main(String[] args) {
		
	StackDemo3 s1 = new StackDemo3();
	
	s1.push(80);
	s1.push(20);
	s1.push(40);
	System.out.println(s1.peek());
	s1.pop();
	System.out.println(s1.peek());
		
	}		
}
