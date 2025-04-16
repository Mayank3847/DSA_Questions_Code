import java.util.*;

public class LinkedList_Detect_A_Loop_StartingPoint_Of_Loop {

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

    public static boolean detectLoop(Node head) {
        Node temp = head;
        HashMap<Node, Integer> map = new HashMap<>();
        while (temp != null) {
            if (map.containsKey(temp)) {
                return true;
            }
            map.put(temp, map.getOrDefault(map, 0) + 1);
            temp = temp.next;
        }
        return false;
    }

    public static boolean detectLoopOptimized(Node head) {
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    public static Node startingPoint(Node head) {
        Node temp = head;
        HashMap<Node, Integer> map = new HashMap<>();
        while (temp.next != null) {
            if (map.containsKey(temp)) {
                return temp;

            }
            map.put(temp, map.getOrDefault(map, 0) + 1);
            temp = temp.next;
        }
        return null;
    }

    public static Node startingPointOptimized(Node head) {
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                slow = head;
                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
        return slow;


            }
            

        }
        return null;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5 };
        Node head = convertArr2LL(arr);
        System.out.println("Original Linked List:");
        printLL(head);

        // Detect loop before creating one
        System.out.println("Does the linked list contain a loop? " + detectLoop(head));

        // Create a loop in the linked list
        System.out.println("Creating a loop...");
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = head.next; // Create a loop

        // Detect loop after creating one
        System.out.println("Does the linked list contain a loop? " + detectLoop(head));
        System.out.println("Does the linked list contain a loop? " + detectLoopOptimized(head));

        // Find the starting point of the loop
        Node loopStart = startingPoint(head);
        if (loopStart != null) {
            System.out.println("The starting point of the loop is: " + loopStart.data);
        } else {
            System.out.println("No loop detected.");
        }

        Node optimizedLoopStart = startingPointOptimized(head);
        if (optimizedLoopStart != null) {
            System.out.println("Starting point of the loop (optimized): " + optimizedLoopStart.data);
        } else {
            System.out.println("No loop detected (optimized).");
        }
    }
}
