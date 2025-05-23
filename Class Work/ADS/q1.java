import java.util.Scanner;

class SinglyLinkedListNode {
    int data;
    SinglyLinkedListNode next;

    SinglyLinkedListNode(int data) {
        this.data = data;
        this.next = null;
    }
}

public class LinkedListReversal {

    public static SinglyLinkedListNode reverse(SinglyLinkedListNode head) {
        SinglyLinkedListNode prev = null;
        SinglyLinkedListNode current = head;
        SinglyLinkedListNode next = null;

        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        return prev;
    }

    public static void printList(SinglyLinkedListNode head) {
        SinglyLinkedListNode current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        SinglyLinkedListNode head = null;
        SinglyLinkedListNode tail = null;

        for (int i = 0; i < n; i++) {
            int data = scanner.nextInt();
            SinglyLinkedListNode newNode = new SinglyLinkedListNode(data);

            if (head == null) {
                head = newNode;
                tail = head;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
        }

        head = reverse(head);
        printList(head);

        scanner.close();
    }
}