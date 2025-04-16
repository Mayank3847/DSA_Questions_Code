import java.util.Stack;

public class LinkedList_ReveseLL {

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

    public static Node reverseLL(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node temp = head;
        Stack<Integer> st = new Stack<>();
        while (temp != null) {
            st.push(temp.data);
            temp = temp.next;

        }
        temp = head;
        while (temp != null) {
            temp.data = st.pop();
            temp = temp.next;

        }
        return head;
    }

    public static Node reverseLL_Optimized1(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node temp = head;
        Node back = null;
        while(temp!=null){
     Node front = temp.next;
    temp.next=back;
    back=temp;
    temp=front;
 }
 return back;
    }

    public static Node ReverseLL_recurssive(Node head){
        if (head == null || head.next == null) {
            return head;
        }
        Node newHead=ReverseLL_recurssive(head.next);
        Node front=head.next;
        front.next=head;
        head.next=null;
        return newHead;
    }

    public static void main(String[] args) {
        int[] arr = { 12, 5, 6, 8, 4 };

        Node head = convertArr2LL(arr);

        System.out.println("Linked List Initially:");
        printDLL(head);

        System.out.println("Linked List After Reversing :");

        head = reverseLL(head);
        printDLL(head);
        
        System.out.println("Linked List After Reversing (Optimized) :");
        head = reverseLL_Optimized1(head);
        printDLL(head);

        System.out.println("Linked List After Reversing (Recurssive):");
        head = ReverseLL_recurssive(head);
        printDLL(head);
    }
}