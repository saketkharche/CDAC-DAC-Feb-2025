

class BST{
	Node root;
		
	static class Node{
		int data;
		Node left, right;
		
		Node(int d){
			data = d;
			left=right=null;
		}
	}
	
	BST(){
		root = null; //Empty tree
	}
	
	
	BST(int d){
		root = new Node(d);
	}
	
	
		
	Node insertdata(Node root, int key){
		//Empty tree
		if(root == null){
			root = new Node(key);
			return root;
		}
		if(key <= root.data)
			//Inserting data in left subtree
			root.left = insertdata(root.left, key);
		else
			//Inserting data in Right subtree
			root.right = insertdata(root.right,key);
			
		return root;
		
	}
	
	//wrapper method: recursive call ko instance method call kar rahe hai
	 void insert(int key) {
     root = insertdata(root, key);
	}
	
	//Mostly Inorder giver sorted order in BST. This is just a simple BT.
	//Inorder: LC,Root,RC
	void inorder(Node n){
		
		if( n == null)
			return;
		inorder(n.left);
		System.out.print(n.data + " ");
		inorder(n.right);
		
	}
	
	Node deleteNode(Node root, int key){
			if(root == null)
				return root;
			
			if(key < root.data)
				root.left = deleteNode(root.left,key);
			else if(key > root.data)
				root.right = deleteNode(root.right, key);
			else{
				//Case 1: Leaf node delete
				//case 2: Single child delete
				if(root.left == null)
					return root.right;
				if(root.right == null)
					return root.left;
				//case 3: Two children deletion
				root.data = minvalue(root.right);
				root.right = deleteNode(root.right, root.data);
				
				
				
			}
			return root;
			
		}
		
		int minvalue(Node root)
		{
			int x = root.data;
			while(root.left != null){
				x = root.left.data;
				root = root.left;
			}
			return x;
		}

	void delete(int key){
		root = deleteNode(root,key);
	}
	
	public static void main(String[] args) {
		
		BST t1 = new BST();
				
		t1.insert(20);
		t1.insert(34);
		t1.insert(56);
		t1.insert(15);
		t1.insert(34);
		t1.insert(23);
		t1.insert(55);
		t1.insert(74);
		t1.insert(93);
		t1.insert(2);
		
		//Inorder: LC, Root, RC
		System.out.println("\n----Inorder--------\n");
		t1.inorder(t1.root);
		
		//Case 1: Leaf node
		t1.delete(2);
		System.out.println("\n----Inorder--------\n");
		t1.inorder(t1.root);
		
		//Case 2 : Single child deletion
		t1.delete(74);
		System.out.println("\n----Inorder--------\n");
		t1.inorder(t1.root);
		
		//Case 3 : Two child deletion
		t1.delete(20);
		System.out.println("\n----Inorder--------\n");
		t1.inorder(t1.root);
		
		
		
		
		
		
				
		
		
		
		
	}		
}