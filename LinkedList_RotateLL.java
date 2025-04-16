public class LinkedList_RotateLL {
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

    public static Node rotateLL(Node head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        for (int i = 0; i < k; i++) {
            Node temp = head;
            while (temp.next.next != null) {
                temp = temp.next;

            }
            Node end = temp.next;
            temp.next = null;
            end.next = head;
            head = end;
        }
        return head;
    }

    public static Node rotateLL_Optimized(Node head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }
        Node temp = head;
        int length = 1;
        while (temp.next != null) {
            ++length;
            temp = temp.next;
        }
        k = k % length;

        temp.next = head;
        int endNode = length - k;

        while (endNode != 0) {
            endNode--;
            temp = temp.next;
        }

        head = temp.next;
        temp.next = null;
        return head;
    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 4, 5 };
        int k = 2;

        Node head = convertArr2LL(arr);
        System.out.println("Original Linked List:");
        printLL(head);

        head = rotateLL(head, k);
        System.out.println("Linked List after Rotation:");
        printLL(head);

        Node head1 = convertArr2LL(arr);
        System.out.println("Original Linked List:");
        printLL(head1);

        head1 = rotateLL_Optimized(head1, k); // ✅ Corrected variable used
        System.out.println("Linked List after Optimized Rotation:");
        printLL(head1); // ✅ Corrected variable printed
    }

}
