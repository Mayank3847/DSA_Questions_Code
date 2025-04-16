import java.util.*;

public class LinkedList_DLL_Reverse_A_DLL {

    public static class Node {
        int data;
        Node next;
        Node prev;

        public Node(int data, Node next, Node prev) {
            this.data = data;
            this.next = next;
            this.prev = prev;

        }

        public Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;

        }
    }

    public static void printDLL(Node head) {
        while (head != null) {
            System.out.print(head.data + " <==> ");
            head = head.next;
        }
        System.out.println("null");
    }

    public static Node convertToDLL(int arr[]) {
        Node head = new Node(arr[0]);
        Node prev = head;
        for (int i = 1; i < arr.length; i++) {
            Node temp = new Node(arr[i], null, prev);
            prev.next = temp;
            prev = temp;
        }
        return head;
    }

    public static Node reverse_DLL(Node head) {
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

    public static Node reverse_DLL_SpaceOptimized(Node head) {
        if (head == null || head.next == null) {
            return head; 
        }
        Node current = head;
        Node last = null;
        while (current != null) {
            last = current.prev;
            current.prev = current.next;
            current.next = last;
            current = current.prev;
        }
        return last.prev;
       
    }

    public static void main(String[] args) {
        int[] arr = { 12, 5, 6, 8, 4 };

        Node head = convertToDLL(arr);

        System.out.println("Doubly Linked List Initially:");
        printDLL(head);

        System.out.println("Doubly Linked List After Reversing :");

        head = reverse_DLL(head);
        printDLL(head);

        System.out.println("Doubly Linked List After Reversing :");
        head = reverse_DLL_SpaceOptimized(head);
        printDLL(head);
    }

}
