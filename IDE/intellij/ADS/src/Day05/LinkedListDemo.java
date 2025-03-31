package Day05;

// Single file implementation of Singly Linked List in Java
class LinkedList {
    Node head; // Head node (first node in the list)

    // Node class (inner class)
    class Node {
        int data;
        Node next;

        // Constructor
        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // 1️⃣ Insert at the beginning
    public void insertAtBeginning(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    // 2️⃣ Insert at the end
    public void insertAtEnd(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
    }

    // 3️⃣ Insert at a specific position
    public void insertAtPosition(int data, int position) {
        if (position == 0) {
            insertAtBeginning(data);
            return;
        }
        Node newNode = new Node(data);
        Node temp = head;
        for (int i = 0; i < position - 1 && temp != null; i++) {
            temp = temp.next;
        }
        if (temp == null) return; // Position out of bounds
        newNode.next = temp.next;
        temp.next = newNode;
    }

    // 4️⃣ Delete by value
    public void deleteByValue(int key) {
        if (head == null) return;
        if (head.data == key) {
            head = head.next;
            return;
        }
        Node temp = head;
        while (temp.next != null && temp.next.data != key) {
            temp = temp.next;
        }
        if (temp.next == null) return;
        temp.next = temp.next.next;
    }

    // 5️⃣ Delete from beginning
    public void deleteFromBeginning() {
        if (head != null) head = head.next;
    }

    // 6️⃣ Delete from end
    public void deleteFromEnd() {
        if (head == null || head.next == null) {
            head = null;
            return;
        }
        Node temp = head;
        while (temp.next.next != null) {
            temp = temp.next;
        }
        temp.next = null;
    }

    // 7️⃣ Display linked list
    public void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    // 8️⃣ Search for a value
    public boolean search(int key) {
        Node temp = head;
        while (temp != null) {
            if (temp.data == key) return true;
            temp = temp.next;
        }
        return false;
    }

    // 9️⃣ Reverse linked list
    public void reverse() {
        Node prev = null, curr = head, next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
    }

    // 🔟 Find length of linked list
    public int length() {
        int count = 0;
        Node temp = head;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }

    // 1️⃣1️⃣ Find the middle element
    public int findMiddle() {
        Node slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow.data;
    }

    // 1️⃣2️⃣ Detect a loop in the linked list
    public boolean detectLoop() {
        Node slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) return true;
        }
        return false;
    }

    // Main method to test the linked list
    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        // Insert elements
        list.insertAtEnd(10);
        list.insertAtEnd(20);
        list.insertAtEnd(30);
        System.out.print("Linked List: ");
        list.display(); // Output: 10 -> 20 -> 30 -> null

        // Insert at beginning
        list.insertAtBeginning(5);
        System.out.print("After inserting 5 at beginning: ");
        list.display(); // Output: 5 -> 10 -> 20 -> 30 -> null

        // Insert at position
        list.insertAtPosition(25, 3);
        System.out.print("After inserting 25 at position 3: ");
        list.display(); // Output: 5 -> 10 -> 20 -> 25 -> 30 -> null

        // Delete by value
        list.deleteByValue(20);
        System.out.print("After deleting 20: ");
        list.display(); // Output: 5 -> 10 -> 25 -> 30 -> null

        // Reverse linked list
        list.reverse();
        System.out.print("After reversing: ");
        list.display(); // Output: 30 -> 25 -> 10 -> 5 -> null

        // Search for an element
        System.out.println("Is 25 in the list? " + list.search(25)); // Output: true
        System.out.println("Is 100 in the list? " + list.search(100)); // Output: false

        // Find length
        System.out.println("Length of Linked List: " + list.length()); // Output: 4

        // Find middle element
        System.out.println("Middle Element: " + list.findMiddle()); // Output: 25

        // Detect loop (no loop in this case)
        System.out.println("Loop detected? " + list.detectLoop()); // Output: false
    }
}
