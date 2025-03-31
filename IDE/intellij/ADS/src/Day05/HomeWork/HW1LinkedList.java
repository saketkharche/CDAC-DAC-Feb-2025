package Day05.HomeWork;

class Node {
    int data;
    Node2 next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class HW1LinkedList {
    private Node2 head;

    // Insert at the end
    public void insert(int data) {
        Node2 newNode2 = new Node2(data);
        if (head == null) {
            head = newNode2;
            return;
        }
        Node2 temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode2;
    }

    // Delete a node
    public void delete(int key) {
        if (head == null) return;
        if (head.data == key) {
            head = head.next;
            return;
        }
        Node2 temp = head;
        while (temp.next != null && temp.next.data != key) {
            temp = temp.next;
        }
        if (temp.next != null) {
            temp.next = temp.next.next;
        }
    }

    // Search for a value
    public boolean search(int key) {
        Node2 temp = head;
        while (temp != null) {
            if (temp.data == key) return true;
            temp = temp.next;
        }
        return false;
    }

    // Traverse the list
    public void traverse() {
        Node2 temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        HW1LinkedList list = new HW1LinkedList(); // Fixed object instantiation
        list.insert(10);
        list.insert(20);
        list.insert(30);
        list.traverse();

        System.out.println("Search 20: " + list.search(20));
        list.delete(20);
        list.traverse();
    }
}
