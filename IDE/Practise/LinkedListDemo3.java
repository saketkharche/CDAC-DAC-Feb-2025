class LinkedListDemo3 {

    // Node class
    static class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    // Head of the list
    Node start;

    // Display all nodes
    void display() {
        Node n = start;
        while (n != null) {
            System.out.print(n.data + " ---> ");
            n = n.next;
        }
        System.out.println("null");
    }

    // Insert at beginning
    void insert(int new_data) {
        Node new_node = new Node(new_data);
        new_node.next = start;
        start = new_node;
    }

    // Insert after a given node
    void inserAfter(Node prev_node, int new_data) {
        if (prev_node == null) {
            System.out.println("Previous node cannot be null");
            return;
        }
        Node new_node = new Node(new_data);
        new_node.next = prev_node.next;
        prev_node.next = new_node;
    }

    // Append to end of the list
    void append(int new_data) {
        Node new_node = new Node(new_data);
        if (start == null) {
            start = new_node;
            return;
        }
        Node n = start;
        while (n.next != null)
            n = n.next;
        n.next = new_node;
    }

    // Reverse the linked list
    void reverseLL() {
        Node prev = null;
        Node current = start;
        Node next = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        start = prev;
    }

    // Delete node by value
    void deleteNode(int key) {
        Node temp = start, prev = null;

        // Deletion at the beginning
        if (temp != null && temp.data == key) {
            start = temp.next;
            return;
        }

        // Find the node to delete
        while (temp != null && temp.data != key) {
            prev = temp;
            temp = temp.next;
        }

        // If not found
        if (temp == null) return;

        // Unlink node
        prev.next = temp.next;
    }

    // Main method to test
    public static void main(String[] args) {
        LinkedListDemo3 l1 = new LinkedListDemo3();

        l1.insert(30);
        l1.insert(20);
        l1.insert(10);
        l1.insert(5);
        l1.insert(100);

        System.out.println("Initial list:");
        l1.display();

        System.out.println("\nAfter inserting 150 after 20:");
        l1.inserAfter(l1.start.next, 150); // Insert after 20
        l1.display();

        System.out.println("\nAfter appending 250:");
        l1.append(250);
        l1.display();

        System.out.println("\nAfter reversing the list:");
        l1.reverseLL();
        l1.display();

        System.out.println("\nAfter deleting 30:");
        l1.deleteNode(30);
        l1.display();
    }
}
