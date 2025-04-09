package Day05.HomeWork;

class Node891011 {
    int data;
    Node891011 next;

    public Node891011(int data) {
        this.data = data;
        this.next = null;
    }
}

public class HWLinkedList891011 {
    private Node891011 head;

    // Find the length of the linked list
    public int getLength() {
        int count = 0;
        Node891011 temp = head;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }

    // Check if the linked list is empty
    public boolean isEmpty() {
        return head == null;
    }

    // Print all elements of the linked list
    public void printElements() {
        Node891011 temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    // Reverse the linked list
    public void reverse() {
        Node891011 prev = null, current = head, next;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;
    }

    // Utility method to add elements for testing
    public void insertAtEnd(int data) {
        Node891011 newNode = new Node891011(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node891011 temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
    }

    public static void main(String[] args) {
        HWLinkedList891011 list = new HWLinkedList891011();
        list.insertAtEnd(10);
        list.insertAtEnd(20);
        list.insertAtEnd(30);

        System.out.println("List elements:");
        list.printElements();

        System.out.println("Length of list: " + list.getLength());
        System.out.println("Is list empty? " + list.isEmpty());

        System.out.println("Reversing the list...");
        list.reverse();
        list.printElements();
    }
}
