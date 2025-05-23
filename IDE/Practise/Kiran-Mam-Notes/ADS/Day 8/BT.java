

class BT{
	Node root;
		
	static class Node{
		int data;
		Node left, right;
		
		Node(int d){
			data = d;
			left=right=null;
		}
	}
	
	BT(){
		root = null; //Empty tree
	}
	
	BT(int d){
		root = new Node(d);
	}
	
	//Preorder: Root,LC,RC
	void preorder(Node n){
		if( n == null)
			return;
		System.out.print(n.data + " ");
		preorder(n.left);
		preorder(n.right);
		
	}
	
	//Inorder: LC,Root,RC
	void inorder(Node n){
		if( n == null)
			return;
		inorder(n.left);
		System.out.print(n.data + " ");
		inorder(n.right);
		
	}
	
	//Postorder: LC,RC,Root
	void postorder(Node n){
		if( n == null)
			return;
		postorder(n.left);
		postorder(n.right);
		System.out.print(n.data + " ");
		
	}

	public static void main(String[] args) {
		
		BT t1 = new BT();
		t1.root = new Node(20);
		t1.root.left = new Node(34);
		t1.root.right = new Node(56);
		t1.root.left.left = new Node(15);
		t1.root.left.right = new Node(34);
		t1.root.right.left = new Node(23);
		t1.root.right.right = new Node(34);
		
		
		System.out.println("----Preorder--------");
		t1.preorder(t1.root);
		System.out.println("----Inorder--------");
		t1.inorder(t1.root);
		System.out.println("-----Postorder-------");
		t1.postorder(t1.root);
		
		
		
				
		
		
		
		
	}		
}