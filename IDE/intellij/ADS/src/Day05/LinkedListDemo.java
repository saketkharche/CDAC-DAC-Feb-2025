package Day05;

public class LinkedListDemo {
    Node start;//refrence
        //Create Node
    static class Node {
        int data;//store the value of node
        Node next;//reference stores the address of next node
        public Node(int data) {
            this.data = data;//data
            this.next = null;//next Link

        }
    }
    public static void main(String[] args) {

        LinkedListDemo l1 = new LinkedListDemo();
        l1.start = new Node(5);
        Node second = new Node(10);
        Node third = new Node(20);
        Node four = new Node(30);

        l1.start.next = second;
        second.next = third;
        System.out.println(l1.start.data);

    }
}
