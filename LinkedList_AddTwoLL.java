public class LinkedList_AddTwoLL {
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

    public static Node addTwoLL(Node head1, Node head2) {
        Node dummyHead = new Node(-1);
        Node temp = dummyHead;
        int carry = 0;
        while (head1 != null || head2 != null || carry == 1) {
            int sum = 0;
            if (head1 != null) { 
                sum += head1.data;
                head1 = head1.next;
            }
            if (head2 != null) {
                sum += head2.data;
                head2 = head2.next;
            }
            sum += carry;
            carry = sum / 10;
            Node newNode = new Node(sum % 10);
            temp.next = newNode;
            temp = temp.next;
        }
        return dummyHead.next;
    }

    public static void main(String[] args) {
        int[] arr1 = { 9, 9, 9, 9, 9, 9, 9, 9 }; // Represents 342
        int[] arr2 = { 9, 9, 9, 9, 9  }; // Represents 465

        Node head1 = convertArr2LL(arr1);
        Node head2 = convertArr2LL(arr2);

        System.out.println("First Linked List:");
        printLL(head1);

        System.out.println("Second Linked List:");
        printLL(head2);

        Node result = addTwoLL(head1, head2);

        System.out.println("Sum of Linked Lists:");
        printLL(result);
    }

}
