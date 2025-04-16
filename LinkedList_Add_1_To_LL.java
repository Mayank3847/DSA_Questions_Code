public class LinkedList_Add_1_To_LL {
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

    public static Node reverseLL_Optimized1(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node temp = head;
        Node back = null;
        while (temp != null) {
            Node front = temp.next;
            temp.next = back;
            back = temp;
            temp = front;
        }
        return back;
    }

    public static Node add1Toll(Node head) {
        head = reverseLL_Optimized1(head);
        Node temp = head;
        int carry = 1;
        while (temp != null) {
            temp.data = temp.data + carry;
            if (temp.data < 10) {
                carry = 0;
                break;
            } else {
                temp.data = 0;
                carry = 1;
            }
            temp = temp.next;

        }
        if (carry == 1) {
            Node newNode = new Node(1);
            head = reverseLL_Optimized1(head);
            newNode.next = head;
            return newNode;
        }
        head = reverseLL_Optimized1(head);
        return head;
    }

    public static int helper(Node temp) {
        if (temp == null) {
            return 1;

        }
        int carry = helper(temp.next);
        temp.data += carry;
        if (temp.data < 10) {
            return 0;

        }
        temp.data = 0;
        return 1;
    }

    public static Node add1ToLLOptimized(Node head) {
        int carry = helper(head);
        if (carry == 1) {
            Node newNode = new Node(1);
            newNode.next = head;
            return newNode;

        }
        return head;

    }

    public static void main(String[] args) {
        int[] arr = { 9, 9, 9 }; // Example input list
        Node head = convertArr2LL(arr);

        System.out.println("Original Linked List: ");
        printLL(head);

        head = add1Toll(head); // Add 1 to the linked list
        System.out.println("Linked List after adding 1: ");
        printLL(head);
        int[] arr1 = { 9, 9, 9 }; // Example input list
        Node head1= convertArr2LL(arr1);
        head = add1ToLLOptimized(head1); // Add 1 to the linked list
        System.out.println("Linked List after adding 1(Optimized): ");
        printLL(head);

    }

}
