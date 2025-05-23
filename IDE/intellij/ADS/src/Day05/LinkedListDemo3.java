package Day05;

public class LinkedListDemo3 {
    Node start;
    static class Node {
        int data;
        Node next;
        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    void display() {
        Node n=start;
        while(n!=null) {
            System.out.print(n.data+"--> ");
            n=n.next;
        }
    }

    void insert(int data) {
        Node new_node = new Node(data);
        new_node.next = start;
        start = new_node;
    }

    void insertAfter(Node prev_node, int new_data) {
        //Node new_node = new Node(new_data);
        //new_data.next = prev_node.next;
        //prev_node.next = new_node;

    }
    public static void main(String[] args) {

    }
}
