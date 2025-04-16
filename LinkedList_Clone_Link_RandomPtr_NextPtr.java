import java.util.*;

public class LinkedList_Clone_Link_RandomPtr_NextPtr {
    static class Node {

        int data;

        Node next;

        Node random;

        Node() {
            this.data = 0;
            this.next = null;
            this.random = null;
        }

        Node(int x) {
            this.data = x;
            this.next = null;
            this.random = null;
        }

        Node(int x, Node nextNode, Node randomNode) {
            this.data = x;
            this.next = nextNode;
            this.random = randomNode;
        }
    }

    public static void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            int randomData = (temp.random != null) ? temp.random.data : -1;
            System.out.println("Node: " + temp.data + ", Random: " + randomData);
            temp = temp.next;
        }
        System.out.println();
    }

    public static Node cloneRandomPtr(Node head) {
        Map<Node, Node> map = new HashMap<>();
        Node temp = head;
        while (temp != null) {
            Node newNode = new Node(temp.data);
            map.put(temp, newNode);
            temp = temp.next;

        }
        temp = head;
        while (temp != null) {
            Node copyNode = map.get(temp);
            copyNode.next = map.get(temp.next);
            copyNode.random = map.get(temp.random);
            temp = temp.next;

        }
        return map.get(head);

    }





    //optimized

    public static void createCopyNode(Node head) {
        Node temp = head;
        while (temp != null) {
            Node copyNode = new Node(temp.data);
            copyNode.next=temp.next;
            temp.next = copyNode;
            temp = temp.next.next;

        }

    }

    public static void connectRandomPtr(Node head) {
        Node temp = head;
        while (temp != null) {
            Node copyNode = temp.next;
            if (temp.random != null) {

                copyNode.random = temp.random.next;
            } else {
                copyNode.random = null;
            }
            temp = temp.next.next;
        }

    }

    public static Node connectNextPtr(Node head) {
        Node dummyNode = new Node(-1);
        Node res = dummyNode;
        Node temp = head;
        while (temp != null) {
            res.next = temp.next;
            res = res.next;
            temp.next = temp.next.next;
            temp = temp.next;
        }
        return dummyNode.next;
    }

    public static Node cloneRandomPtrOptimized(Node head) {
        createCopyNode(head);
        connectRandomPtr(head);
        return connectNextPtr(head);

    }

    public static void main(String[] args) {
        Node head = new Node(1); 
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);

        // Setting up random pointers
        head.random = head.next.next; // 1 -> 3
        head.next.random = head; // 2 -> 1
        head.next.next.random = head.next.next.next; // 3 -> 4
        head.next.next.next.random = head.next; // 4 -> 2

        System.out.println("Original Linked List:");
        printList(head);

        // Cloning the linked list
        Node clonedHead = cloneRandomPtr(head);

        System.out.println("Cloned Linked List:");
        printList(clonedHead);
        Node clonedHead1 = cloneRandomPtrOptimized(head);

        System.out.println("Cloned Linked List(Optimized):");
        printList(clonedHead1);
    }

}
