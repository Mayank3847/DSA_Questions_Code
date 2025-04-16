public class LinkedList_RemovNthNodeFromEnd {
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

    public static Node removeNthNode(Node head, int n) {
        if (head == null) {
            return null;
        }
        Node temp = head;
        int cnt = 0;
        while (temp != null) {
            cnt++;
            temp = temp.next;
        }
        if (cnt == n) {
            Node newHead = head.next;
            head = null;
            return newHead;
        }
        int res = cnt - n;
        temp = head;
        while (temp != null) {
            res--;
            if (res == 0) {
                break;
            }
            temp = temp.next;
        }

        temp.next = temp.next.next;

        return head;
    }

    public static Node removeNthNodeOptimized(Node head, int n) {
        if (head == null) {
            return null;

        }
        Node fast = head;
        for (int i = 0; i < n; i++) {
            fast = fast.next;

        }
        if (fast == null) {
            return head.next;
        }
        Node slow = head;
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;

        }

        slow.next = slow.next.next;

        return head;
    }

   public static int getKthFromLast(Node head, int k) {
        if (head == null) {
            return -1;

        }
        Node fast = head;
        Node slow = head;
        for (int i = 0; i < k; i++) {

        if (fast == null) {
            return -1;
        }
            fast = fast.next;
        }
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;

        }

      

        return slow.data;
    

        // Your code here
    }

    public static void main(String[] args) {
        // Example input array
        int[] arr = { 10, 20, 30, 40, 50 };

        // Convert array to linked list
        LinkedList_RemovNthNodeFromEnd.Node head = LinkedList_RemovNthNodeFromEnd.convertArr2LL(arr);

        System.out.println("Original Linked List:");
        LinkedList_RemovNthNodeFromEnd.printLL(head);

        // Specify the Nth node to remove from the end
        int n = 2;
        head = LinkedList_RemovNthNodeFromEnd.removeNthNode(head, n);

        System.out.println("\nLinked List after removing " + n + "th node from the end:");
        LinkedList_RemovNthNodeFromEnd.printLL(head);

        int[] arr1 = { 10, 20, 30, 40, 50 };

        // Convert array to linked list
        LinkedList_RemovNthNodeFromEnd.Node head1 = LinkedList_RemovNthNodeFromEnd.convertArr2LL(arr1);

        int n1 = 2;
        head = LinkedList_RemovNthNodeFromEnd.removeNthNodeOptimized(head1, n1);

        System.out.println("\nLinked List after removing " + n + "th node from the end:");
        LinkedList_RemovNthNodeFromEnd.printLL(head);


        int[] arr2 = { 10, 20, 30, 40, 50 };

        // Convert array to linked list
        LinkedList_RemovNthNodeFromEnd.Node head2 = LinkedList_RemovNthNodeFromEnd.convertArr2LL(arr2);

        int k = 2; // For example, get the 3rd node from the end
    int kthFromLast = LinkedList_RemovNthNodeFromEnd.getKthFromLast(head2, k);
    if (kthFromLast != -1) {
        System.out.println("\nThe " + k + "th node from the end is: " + kthFromLast);
    } else {
        System.out.println("\nInvalid input or the list does not contain " + k + " nodes.");
    }
    }
}