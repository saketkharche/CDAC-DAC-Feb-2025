
class LinkedListDemo1{
	
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
	public static void main(String[] args) {
		LinkedListDemo1 l1 = new LinkedListDemo1();
		
		l1.start = new Node(5);
		Node second = new Node(10);
		Node third = new Node(20);
		Node four = new Node(30);
		
		l1.start.next = second;
		second.next = third;
		third.next = four;
		
		l1.display();
		
		
		
	}
}