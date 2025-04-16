public class LinkedList_Segregate_Even_Odd_Manner {
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

    public static Node segregateEvenOdd(Node head) {
        Node oddHead = new Node(-1);
        Node oddTail = oddHead;
        Node evenHead = new Node(-1);
        Node evenTail = evenHead;
        Node curr = head;
        Node temp = head;
        while (curr != null) {
            temp = curr;
            curr = curr.next;
            temp.next = null;
            if (temp.data % 2 != 0) {
                oddTail.next = temp;
                oddTail = temp;
            } else {
                evenTail.next = temp;
                evenTail = temp;

            }

        }
        evenTail.next = oddHead.next;
        return evenHead.next;

    }

    public static Node segregateEvenOdd_BySize(Node head) {
        Node oddHead = new Node(-1);
        Node oddTail = oddHead;
        Node evenHead = new Node(-1);
        Node evenTail = evenHead;
        Node curr = head;

        int size = 1;
        while (curr != null) {

            if (size % 2 != 0) {
                oddTail.next = curr;
                oddTail = curr;
            } else {
                evenTail.next = curr;
                evenTail = curr;

            }
            curr = curr.next;
            size++;

        }
        evenTail.next = null;
        oddTail.next = null;
        evenTail.next = oddHead.next;

        return evenHead.next;

    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };

        Node head = convertArr2LL(arr); // Original list

        System.out.println("Original Linked List:");
        printLL(head);

        // Call the first function on a fresh copy
        Node segregatedHead = segregateEvenOdd(convertArr2LL(arr));
        System.out.println("Segregated Linked List:");
        printLL(segregatedHead);
        int[] arr1 = { 12, 13, 14, 15, 16, 17, 18, 19, 11 };
        // Call the second function on another fresh copy
        Node segregatedHeadBySize = segregateEvenOdd_BySize(convertArr2LL(arr1));
        System.out.println("Segregated Linked List By Size:");
        printLL(segregatedHeadBySize);
    }

}
