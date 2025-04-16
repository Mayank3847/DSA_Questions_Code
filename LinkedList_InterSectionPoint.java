import java.util.*;

public class LinkedList_InterSectionPoint {
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

    public static Node intersectionPoint(Node head1, Node head2) {
        while (head2 != null) {
            Node temp = head1;
            while (temp != null) {
                if (temp == head2) {
                    return head2;
                }
                temp = temp.next;
            }
            head2 = head2.next;
        }
        return null;
    }

    public static Node intersectionPoint_Hashing(Node head1, Node head2) {
        Set<Node> set = new HashSet<>();
        while (head1 != null) {
            set.add(head1);
            head1 = head1.next;

        }
        while (head2 != null) {
            if (set.contains(head2)) {
                return head2;
            }
            head2 = head2.next;
        }
        return null;
    }

    public static int getDiff(Node head1, Node head2) {
        int len1 = 0;
        int len2 = 0;
        while (head1 != null) {
            len1++;
            head1 = head1.next;

        }
        while (head2 != null) {
            len2++;
            head2 = head2.next;

        }
        return len1 - len2;
    }

    public static Node intersectionPoint_By_Diff(Node head1, Node head2) {
        int diff = getDiff(head1, head2);
        if (diff < 0) {
            while (diff++ != 0) {
                head2 = head2.next;
            }
        } else {
            while (diff-- != 0) {
                head1 = head1.next;

            }
        }
        while (head1 != null) {
            if (head1 == head2) {
                return head1;
            }
            head1 = head1.next;
            head2 = head2.next;

        }
        return null;

    }

    public static Node intersectionPointOptimized(Node head1, Node head2) {
        if (head1 == null || head2 == null) {
            return null;

        }
        Node d1 = head1;
        Node d2 = head2;
        while (d1 != d2) {
            if (d1 == null) {
                d1 = head2;
            } else {
                d1 = d1.next;
            }
            if(d2==null){
                d2=head1;
            }else{
                d2=d2.next;
            }

        }
        return d1;
    }

    public static void main(String[] args) {
        // Creating two linked lists
        int[] arr1 = { 1, 2, 3, 4, 5 };
        int[] arr2 = { 10, 20, 25, 28 };

        // Convert arrays to linked lists
        Node head1 = convertArr2LL(arr1);
        Node head2 = convertArr2LL(arr2);

        // Manually create an intersection
        Node intersectNode = new Node(30);
        head1.next.next.next.next = intersectNode; // List 1: 1 -> 2 -> 3 -> 4 -> 30 -> null
        head2.next.next.next.next = intersectNode; // List 2: 10 -> 20 -> 30 -> null

        // Printing both linked lists
        System.out.println("Linked List 1:");
        printLL(head1);
        System.out.println("Linked List 2:");
        printLL(head2);

        // Finding the intersection point
        Node intersection = intersectionPoint(head1, head2);

        if (intersection != null) {
            System.out.println("Intersection Point is at node with data: " + intersection.data);
        } else {
            System.out.println("No intersection point found.");
        }
        Node intersection1 = intersectionPoint_Hashing(head1, head2);

        if (intersection1 != null) {
            System.out.println("Intersection Point is at node with data (By Hashing) : " + intersection1.data);
        } else {
            System.out.println("No intersection point found.");
        }
        Node intersection2 = intersectionPoint_By_Diff(head1, head2);

        if (intersection2 != null) {
            System.out.println("Intersection Point is at node with data (By Getting difference of the length) : "
                    + intersection1.data);
        } else {
            System.out.println("No intersection point found.");
        }  Node intersection3 = intersectionPointOptimized(head1, head2);

        if (intersection3 != null) {
            System.out.println("Intersection Point is at node with data (Optimized) : "
                    + intersection1.data);
        } else {
            System.out.println("No intersection point found.");
        }

    }

}
