import java.util.*;

public class LinkedList_Flattening_LL {
    static class Node {
        int data;
        Node next;
        Node child;

        // Constructors to initialize the
        // data, next, and child pointers
        Node() {
            data = 0;
            next = null;
            child = null;
        }

        Node(int x) {
            data = x;
            next = null;
            child = null;
        }

        Node(int x, Node nextNode, Node childNode) {
            data = x;
            next = nextNode;
            child = childNode;
        }
    }

    public static void printList(Node head) {
        while (head != null) {
            System.out.print(head.data + " -> ");
            head = head.child;
        }
        System.out.println("NULL");
    }

    public static Node convertArrToLL(ArrayList<Integer> list) {
        Node dummyNode = new Node(-1);
        Node temp = dummyNode;
        for (int i = 0; i < list.size(); i++) {
            temp.child = new Node(list.get(i));
            temp = temp.child;
        }
        return dummyNode.child;
    }

    public static Node flatteningLL(Node head) {
        ArrayList<Integer> list = new ArrayList<>();
        while (head != null) {
            Node temp = head;
            while (temp != null) {
                list.add(temp.data);
                temp = temp.child;
            }
            head = head.next;
        }

        Collections.sort(list);

        return convertArrToLL(list);
    }

    public static Node merge2LL(Node l1, Node l2) {
        Node dummyHead = new Node(-1);
        Node res = dummyHead;

        while (l1 != null && l2 != null) {
            if (l1.data < l2.data) {
                res.child = l1;
                res = l1;
                l1 = l1.child;
            } else {
                res.child = l2;
                res = l2;
                l2 = l2.child;

            }
            res.next = null;
            if (l1 != null) { 
                res.child = l1;

            } else {
                res.child = l2;
            }
        }
        if (dummyHead.child != null) {
            dummyHead.child.next = null;
        }
        return dummyHead.next;
    }

    public static Node flatteningLL_Optimized(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node mergeHead = flatteningLL_Optimized(head.next);
        head = merge2LL(head, mergeHead);
        return head;
    }

    public static void main(String[] args) {
        Node head = new Node(5);
        head.child = new Node(7);
        head.child.child = new Node(8);
        head.child.child.child = new Node(30);

        head.next = new Node(10);
        head.next.child = new Node(20);

        head.next.next = new Node(19);
        head.next.next.child = new Node(22);
        head.next.next.child.child = new Node(50);

        head.next.next.next = new Node(28);
        head.next.next.next.child = new Node(35);
        head.next.next.next.child.child = new Node(40);
        head.next.next.next.child.child.child = new Node(45);

        System.out.println("Original List:");
        printList(head);

        Node flattened = flatteningLL(head);

        System.out.println("Flattened List:");
        printList(flattened);


        Node flattened1 = flatteningLL(head);

        System.out.println("Flattened List (Optimized):");
        printList(flattened1);
    }
}
