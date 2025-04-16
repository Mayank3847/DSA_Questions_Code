// import java.util.*;

public class LinkedList_detect_aloop {
    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;

        }

    }

    private Node head;

    private Node tail;

    public void addNode(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
    }

    public boolean isCycle() {
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

    public static void main(String[] args) {
        LinkedList_detect_aloop list = new LinkedList_detect_aloop();
        
        list.addNode(1);
        list.addNode(2);
        list.addNode(3);

        // Creating a loop for testing
        list.head.next.next.next = list.head;
        System.out.println(list.isCycle()); // Output: true

    }

}
