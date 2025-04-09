package Day05.HomeWork;

class Node2 {
    int data;
    Node2 next;

    public Node2(int data) {
        this.data = data;
        this.next = null;
    }
}

public class HW567LinkedList {
    private Node2 head;

    // Insert at the beginning
    public void insertAtBeginning(int data) {
        Node2 newNode2 = new Node2(data);
        newNode2.next = head;
        head = newNode2;
    }

    // Insert at the end
    public void insertAtEnd(int data) {
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

    // Insert at a specific position
    public void insertAtPosition(int data, int position) {
        if (position == 0) {
            insertAtBeginning(data);
            return;
        }
        Node2 newNode2 = new Node2(data);
        Node2 temp = head;
        for (int i = 0; temp != null && i < position - 1; i++) {
            temp = temp.next;
        }
        if (temp == null) {
            System.out.println("Position out of bounds");
            return;
        }
        newNode2.next = temp.next;
        temp.next = newNode2;
    }

    // Delete a node by value
    public void deleteByValue(int key) {
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

    // Delete a node at a specific position
    public void deleteAtPosition(int position) {
        if (head == null) return;
        if (position == 0) {
            head = head.next;
            return;
        }
        Node2 temp = head;
        for (int i = 0; temp != null && i < position - 1; i++) {
            temp = temp.next;
        }
        if (temp == null || temp.next == null) {
            System.out.println("Position out of bounds");
            return;
        }
        temp.next = temp.next.next;
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
        HW567LinkedList list = new HW567LinkedList();
        list.insertAtEnd(10);
        list.insertAtEnd(20);
        list.insertAtEnd(30);
        list.traverse();

        list.insertAtBeginning(5);
        list.traverse();

        list.insertAtPosition(15, 2);
        list.traverse();

        System.out.println("Search 20: " + list.search(20));
        list.deleteByValue(20);
        list.traverse();

        list.deleteAtPosition(1);
        list.traverse();
    }
}
