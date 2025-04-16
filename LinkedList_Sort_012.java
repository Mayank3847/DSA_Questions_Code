public class LinkedList_Sort_012 {
    public static class Node {
        int data;
        Node next;

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;

        }

        public Node(int data) {
            this.data = data;
            this.next = null;

        }
    }

    public static void printLL(Node head) {
        while (head != null) {
            System.out.print(head.data + " ==> ");
            head = head.next;
        }
        System.out.println("null");
    }

    public static Node convertArr2LL(int arr[]) {
        Node head = new Node(arr[0]);
        Node mover = head;
        for (int i = 1; i < arr.length; i++) {
            Node temp = new Node(arr[i]);
            mover.next = temp;
            mover = temp;
        }
        return head;
    }

    public static Node sort012(Node head) {
        if (head == null || head.next == null) {
            return head;

        }
        Node zeroHead = new Node(-1);
        Node oneHead = new Node(-1);
        Node twoHead = new Node(-1);
        Node zero = zeroHead;
        Node one = oneHead;
        Node two = twoHead;
        Node temp = head;
        while (temp != null) {
            if (temp.data == 0) {
                zero.next = temp;
                zero = zero.next;
            } else if (temp.data == 1) {
                one.next = temp;
                one = one.next;
            } else {
                two.next = temp;
                two = two.next;
            }
            temp = temp.next;
        }
        if (oneHead.next != null) {
            zero.next = oneHead.next;
        } else {
            zero.next = twoHead.next;
        }
        if (twoHead.next != null) {
            one.next = twoHead.next;
        } else {
            one.next = null;
        }
        two.next = null;
        return zeroHead.next;
    }

    public static void main(String[] args) {

        int[] arr = { 0, 1, 2, 1, 0, 2, 2, 1, 0 };
        System.out.println("Original Linked List:");
        Node head = convertArr2LL(arr);
        printLL(head);

        head = sort012(head);
        System.out.println("\nSorted Linked List:");
        printLL(head);
    }
}