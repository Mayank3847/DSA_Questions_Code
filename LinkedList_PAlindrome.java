import java.util.*;

public class LinkedList_PAlindrome {
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

    public static boolean isPalindrome(Node head) {
        Stack<Integer> st = new Stack<>();
        Node temp = head;
        while (temp != null) {
            st.push(temp.data);
            temp = temp.next;

        }
        temp = head;
        while (temp != null) {
            if (temp.data != st.peek()) {
                return false;
            }
            st.pop();
            temp = temp.next;
        }
        return true;
    }

    public static Node ReverseLL_recurssive(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node newHead = ReverseLL_recurssive(head.next);
        Node front = head.next;
        front.next = head;
        head.next = null;
        return newHead;
    }

    public static boolean isPalindromeOptimized(Node head) {
        if (head == null || head.next == null) {
            return true;
        }
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        Node newHead = ReverseLL_recurssive(slow.next);
        
        // slow.next=null;
        Node first = head;
        Node second = newHead;
        
        while (second != null) {

            if (first.data != second.data) {
                ReverseLL_recurssive(newHead);
               return false;
                
            }
            first = first.next;
            second = second.next;

        }
        ReverseLL_recurssive(newHead);
        return true;
    }

    public static void main(String[] args) {
        // Test case
        int[] arr = { 1, 2, 3, 2, 1 }; // Palindrome array
        Node head = convertArr2LL(arr);

        System.out.println("Original Linked List:");
        printLL(head);

        boolean result = isPalindrome(head);
        if (result) {
            System.out.println("The linked list is a palindrome.");
        } else {
            System.out.println("The linked list is NOT a palindrome.");
        }

        // Another test case
        int[] arr2 = { 1, 2, 3, 4, 5 }; // Not a palindrome array
        Node head2 = convertArr2LL(arr2);

        System.out.println("Original Linked List:");
        printLL(head2);

        boolean result2 = isPalindrome(head2);
        if (result2) {
            System.out.println("The linked list is a palindrome.");
        } else {
            System.out.println("The linked list is NOT a palindrome.");
        }
        int[] arr1 = { 1, 2, 3, 2, 1 }; // Palindrome array
        Node head1 = convertArr2LL(arr1);

        System.out.println("Original Linked List(Optimized):");
        printLL(head1);

        boolean result1 = isPalindrome(head);
        if (result1) {
            System.out.println("The linked list is a palindrome(Optimized).");
        } else {
            System.out.println("The linked list is NOT a palindrome(Optimized).");
        }

        // Another test case
        int[] arr3 = { 1, 2, 3, 4, 5 }; // Not a palindrome array
        Node head3 = convertArr2LL(arr3);

        System.out.println("Original Linked List(Optimized):");
        printLL(head3);

        boolean result3 = isPalindrome(head3);
        if (result3) {
            System.out.println("The linked list is a palindrome(Optimized).");
        } else {
            System.out.println("The linked list is NOT a palindrome(Optimized).");
        }
    }

}
