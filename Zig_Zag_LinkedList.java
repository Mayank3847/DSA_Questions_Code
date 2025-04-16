public class Zig_Zag_LinkedList {
    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node head;
    private Node tail;
    public static int size;

    public Zig_Zag_LinkedList() {
        this.head = null;
        this.tail = null;
    }

    // print linked linst
    public void printLnkedList() {
        if (head == null) {
            System.out.println("LINKED LIST IS EMPTY!");
            return;

        }
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + "-->");
            temp = temp.next;
        }
        System.out.println("NULL");
    }

    public void addLast(int data) {
        Node newNode = new Node(data);
        size++;
        if (head == null) {
            head = tail = newNode;
            return;

        }
        tail.next = newNode;
        tail = newNode;
    }

    // step -----1 ------find mid
    public void zigzag() {
        // if (head == null || head.next == null) {
        //     return; // No reordering needed for empty or single node list
        // }
        Node slow = head;
        Node fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

        }
        Node mid = slow;
        // reverse 2nd half
        Node curr = mid.next;
        mid.next = null;
        Node prev = null;
        Node next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr=next;

        }
        Node leftHead = head;
        Node rightHead = prev;
        Node nextLeft, nextRight;

        // alternate merge-zig-zag- fashion
        while (leftHead != null && rightHead != null) {
            nextLeft = leftHead.next;
            leftHead.next = rightHead;
            nextRight = rightHead.next;
            // if (nextLeft == null) {
            // break;
            // }
            rightHead.next = nextLeft;
            rightHead = nextRight;
            leftHead = nextLeft;

        }

    }

    public static void main(String[] args) {
        Zig_Zag_LinkedList ll = new Zig_Zag_LinkedList();
        ll.addLast(1);
        ll.addLast(2);
        ll.addLast(3);
        ll.addLast(4);
        ll.addLast(5);
        ll.addLast(6);
        System.out.println("Original List:");
        ll.printLnkedList();
        ll.zigzag();
        System.out.println("List after Zigzag Reordering:");
        ll.printLnkedList();

    }
}
