public class LinkedList_Middle {
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

    public static void printDLL(Node head) {
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

    public static Node middleNode(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        int count = 0;
        Node temp = head;
        while (temp != null) {
            count++;
            temp = temp.next;

        }
        int mid = (count / 2) + 1;
        temp = head;

        while (temp != null) {
            mid = mid - 1;
            if (mid == 0) {
                break;
            }
            temp = temp.next;
        }
        return temp;
    }

    public static Node middleNodeOptimized(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null && slow != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;

    }

    public static void main(String[] args) {

        int arr[] = { 2, 5, 6, 8, 10, 12, 14 };

        Node head = convertArr2LL(arr);

        System.out.print("Linked List: ");
        printDLL(head);

        Node middleNode = middleNode(head);

        System.out.println("The middle node value is: " + middleNode.data);
        Node middleNode1 = middleNodeOptimized(head);
        System.out.println("The middle node value is: " + middleNode1.data);

    }

}
