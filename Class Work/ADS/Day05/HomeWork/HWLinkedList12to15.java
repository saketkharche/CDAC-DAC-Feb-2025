package Day05.HomeWork;

class Node12to15 {
    int data;
    Node12to15 next;

    public Node12to15(int data) {
        this.data = data;
        this.next = null;
    }
}

public class HWLinkedList12to15 {
    private Node12to15 head;

    // Find the middle node of the linked list
    public Node12to15 findMiddle() {
        if (head == null) return null;
        Node12to15 slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    // Detect if the linked list has a cycle
    public boolean hasCycle() {
        if (head == null) return false;
        Node12to15 slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) return true;
        }
        return false;
    }

    // Merge two sorted linked lists
    public static Node12to15 mergeSorted(Node12to15 l1, Node12to15 l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        if (l1.data < l2.data) {
            l1.next = mergeSorted(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeSorted(l1, l2.next);
            return l2;
        }
    }

    // Remove duplicates from a sorted linked list
    public void removeDuplicates() {
        Node12to15 temp = head;
        while (temp != null && temp.next != null) {
            if (temp.data == temp.next.data) {
                temp.next = temp.next.next;
            } else {
                temp = temp.next;
            }
        }
    }

    // Utility method to add elements for testing
    public void insertAtEnd(int data) {
        Node12to15 newNode = new Node12to15(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node12to15 temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
    }

    public void traverse() {
        Node12to15 temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        HWLinkedList12to15 list = new HWLinkedList12to15();
        list.insertAtEnd(1);
        list.insertAtEnd(2);
        list.insertAtEnd(3);
        list.insertAtEnd(4);
        list.insertAtEnd(5);

        System.out.println("Original List:");
        list.traverse();

        // Find the middle node
        Node12to15 middle = list.findMiddle();
        System.out.println("Middle node: " + (middle != null ? middle.data : "None"));

        // Check for cycle
        System.out.println("Has cycle? " + list.hasCycle());

        // Remove duplicates test
        HWLinkedList12to15 sortedList = new HWLinkedList12to15();
        sortedList.insertAtEnd(1);
        sortedList.insertAtEnd(1);
        sortedList.insertAtEnd(2);
        sortedList.insertAtEnd(3);
        sortedList.insertAtEnd(3);
        System.out.println("Sorted List with Duplicates:");
        sortedList.traverse();
        sortedList.removeDuplicates();
        System.out.println("After Removing Duplicates:");
        sortedList.traverse();

        // Merge sorted lists
        HWLinkedList12to15 list1 = new HWLinkedList12to15();
        list1.insertAtEnd(1);
        list1.insertAtEnd(3);
        list1.insertAtEnd(5);

        HWLinkedList12to15 list2 = new HWLinkedList12to15();
        list2.insertAtEnd(2);
        list2.insertAtEnd(4);
        list2.insertAtEnd(6);

        System.out.println("Merging two sorted lists:");
        Node12to15 mergedHead = mergeSorted(list1.head, list2.head);
        while (mergedHead != null) {
            System.out.print(mergedHead.data + " -> ");
            mergedHead = mergedHead.next;
        }
        System.out.println("null");
    }
}
