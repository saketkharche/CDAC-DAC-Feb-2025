
class LinkedListDemo2{
	
	Node start;//start
	
	static class Node{
		int data;//data
		Node next;//next link
		
		Node(int d){
			data = d;
			next = null;
		}
		
	}
	
	void display(){
		
		Node n = start;
		while( n!= null)
		{
			System.out.print(n.data+"--->");
			n=n.next;
		}
	}
	
	
	
	void insert(int new_data){
			Node new_node = new Node(new_data);
			new_node.next = start;
			start = new_node;
		}
		
	void inserAfter(Node prev_node, int new_data){
			
			Node new_node = new Node(new_data);
			new_node.next = prev_node.next;
			prev_node.next = new_node;
			
		}
		
	void append(int new_data){
		
			Node new_node = new Node(new_data);
			if(start == null)
			{
				start = new Node(new_data);// first node in the list
				return;
			}
			Node n = start;
			while(n.next != null)
				n=n.next;
			n.next = new_node;
			return;
						
		}
	
		public void reverseLL(){
		
		Node prev = null;
		Node current = start;
		Node next = null;
		while( current != null)
		{
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
			
		}
		start = prev;
		//return prev;
	}
	public static void main(String[] args) {
		LinkedListDemo2 l1 = new LinkedListDemo2();
		l1.insert(30);
		l1.insert(20);
		l1.insert(10);
		l1.insert(5);
		l1.insert(100);
		l1.display();
		System.out.println(" \n");
		l1.inserAfter(l1.start.next, 150);
		l1.display();
		System.out.println(" \n");
		l1.append(250);
		l1.display();
		System.out.println(" \n");
		l1.reverseLL();
		l1.display();
		
		
		
		
	}
}