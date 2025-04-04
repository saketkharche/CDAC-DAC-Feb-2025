package Day08;

class Node {
    int data;
    Node left;
    Node right;

    public Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

class BinaryTree {
    Node root;

    public BinaryTree() {
        root = null;
    }

    // Preorder Traversal: Root -> Left -> Right
    public void preorder(Node node) {
        if (node == null) {
            return;
        }
        System.out.print(node.data + " "); // Print current node
        preorder(node.left);               // Traverse left subtree
        preorder(node.right);              // Traverse right subtree
    }

    // Inorder Traversal: Left -> Root -> Right
    public void inorder(Node node) {
        if (node == null) {
            return;
        }
        inorder(node.left);                // Traverse left subtree
        System.out.print(node.data + " "); // Print current node
        inorder(node.right);               // Traverse right subtree
    }

    // Postorder Traversal: Left -> Right -> Root
    public void postorder(Node node) {
        if (node == null) {
            return;
        }
        postorder(node.left);              // Traverse left subtree
        postorder(node.right);             // Traverse right subtree
        System.out.print(node.data + " "); // Print current node
    }
}

public class Tree {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree(); // Create a binary tree

        // Manually create nodes
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);

        // Print Tree Traversals
        System.out.print("Preorder: ");
        tree.preorder(tree.root); // Expected: 1 2 4 5 3
        System.out.println();

        System.out.print("Inorder: ");
        tree.inorder(tree.root);  // Expected: 4 2 5 1 3
        System.out.println();

        System.out.print("Postorder: ");
        tree.postorder(tree.root); // Expected: 4 5 2 3 1
        System.out.println();
    }
}