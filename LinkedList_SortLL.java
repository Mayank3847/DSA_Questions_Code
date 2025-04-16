import java.util.*;

public class LinkedList_SortLL {
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

    public static Node sortLL(Node head) {
        if (head == null || head.next == null) {
            return head;

        }
        Node temp = head;
        List<Integer> arr = new ArrayList<>();
        while (temp != null) {
            arr.add(temp.data);
            temp = temp.next;
        }
        Collections.sort(arr);
        temp = head;
        for (int i = 0; i < arr.size(); i++) {
            temp.data = arr.get(i);
            temp = temp.next;
        }
        return head;
    }

    public static Node sortLLOptimized(Node head) {
        if (head == null || head.next == null) {
            return head;

        }
        Node middle = findMiddleNode(head);
        Node right = middle.next;
        middle.next = null;
        Node left = head;
        left = sortLLOptimized(left);
        right = sortLLOptimized(right);
        return mergeSortLL(right, left);
    }

    public static Node mergeSortLL(Node list1, Node list2) {
        Node dummyNode = new Node(-1);
        Node temp = dummyNode;
        while (list1 != null & list2 != null) {
            if (list1.data <= list2.data) {
                temp.next = list1;
                list1 = list1.next;

            } else {
                temp.next = list2;
                list2 = list2.next;
            }
            temp = temp.next;

        }
        if (list1 != null) {
            temp.next = list1;

        } else {
            temp.next = list2;
        }
        return dummyNode.next;
    }

    public static Node findMiddleNode(Node head) {
        if (head == null || head.next == null) {
            return head;

        }
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next == null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public static void main(String[] args) {
        int[] arr = { 4, 1, 3, 5, 2 };

        Node head = convertArr2LL(arr);

        System.out.print("Original Linked List: ");
        printLL(head);

        head = sortLLOptimized(head);

        System.out.print("Sorted Linked List: ");
        printLL(head);
        int[] arr1 = { 4, 1, 3, 5, 2 };

        Node head1 = convertArr2LL(arr1);

        head = sortLL(head1);

        System.out.print("Sorted Linked List: ");
        printLL(head);
    }

}
