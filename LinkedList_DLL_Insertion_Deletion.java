public class LinkedList_DLL_Insertion_Deletion {

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

    public static Node deleteFirst(Node head) {
        if (head == null || head.next == null) {
            return null;
        }
        Node newNode = head;
        head = head.next;
        head.prev = null;
        newNode.next = null;
        return head;
    }

    public static Node deleteLast(Node head) {
        if (head == null || head.next == null) {
            return null;
        }
        Node tail = head;
        while (tail.next != null) {
            tail = tail.next;

        }
        Node temp = tail.prev;
        temp.next = null;
        tail.prev = null;
        return head;

    }

    public static Node deletKthElement(Node head, int k) {
        if (head == null) {
            return null;
        }
        Node temp = head;
        int cnt = 0;
        while (temp != null) {
            cnt++;
            if (cnt == k) {
                break;
            }
            temp = temp.next;

        }
        Node back = temp.prev;
        Node front = temp.next;
        if (back == null && front == null) {
            return null;
        } else if (back == null) {
            return deleteFirst(head);
        } else if (front == null) {
            return deleteLast(head);
        }
        back.next = front;
        front.prev = back;
        temp.next = null;
        temp.prev = null;
        return head;
    }

    public static Node deleteGivenValElement(Node head, int val) {
        if (head == null) {
            return null;
        }
        Node temp = head;

        while (temp != null) {

            if (temp.data == val) {
                break;
            }
            temp = temp.next;

        }
        if (temp == null) {
            return head;
        }
        Node back = temp.prev;
        Node front = temp.next;
        if (back == null && front == null) {
            return null;
        } else if (back == null) {
            front.prev = null;
            return front;
        } else if (front == null) {
            back.next = null;
            return head;
        }
        back.next = front;
        front.prev = back;

        return head;
    }

    public static Node insertAtHead(Node head, int val) {
        Node temp = new Node(1);
        temp.next = head;
        temp.prev = null;

        head.prev = temp;

        return temp;
    }

    public static Node insertBeforeTail(Node head, int val) {
        if (head.next == null) {
            return insertAtHead(head, val);
        }
        Node tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }
        Node back = tail.prev;
        Node newNode = new Node(val);
        newNode.next = tail;
        newNode.prev = back;
        back.next = newNode;
        tail.prev = newNode;
        return head;

    }

    public static Node insertBeforeKthElement(Node head, int k, int val) {
        if (k == 1) {
            return insertAtHead(head, val);
        }
        Node temp = head;
        int cnt = 0;
        while (temp != null) {
            cnt++;
            if (cnt == k) {
                break;
            }
            temp = temp.next;

        }
        Node back = temp.prev;
        Node newNode = new Node(val);
        newNode.next = temp;
        newNode.prev = back;
        back.next = newNode;
        temp.prev = newNode;
        return head;
    }

    public static void insertBeforeGivenNode(Node head, Node target, int val) {
        if (target == null) {
                System.out.println("Target node is null. Cannot insert.");
                return;
            }
            Node back = target.prev;
        Node newNode = new Node(val);
        newNode.next = target;
        newNode.prev = back;
        if (back!= null) {
            back.next = newNode;
        } else {
            head = newNode;
        }
        target.prev = newNode;
    }

    public static void main(String[] args) {
        int arr[] = { 2, 5, 6, 8, 10, 12, 14, 16 };
        int k = 4;
        int val = 10;                                              
        Node head = convertToDLL(arr);
        printDLL(head);

        head = deleteFirst(head);
        System.out.println("DLL deletion from the head ");
        printDLL(head);

        head = deleteLast(head);
        System.out.println("DLL deletion from the tail ");
        printDLL(head);

        head = deletKthElement(head, k);
        System.out.println("DLL deletion from the kth node ");
        printDLL(head);

        head = deleteGivenValElement(head, val);
        System.out.println("DLL deletion by the given value ");
        printDLL(head);

        head = insertAtHead(head, val);
        System.out.println("DLL insertion at the head ");
        printDLL(head);

        head = insertBeforeTail(head, val);
        System.out.println("DLL insertion before the tail ");
        printDLL(head);

        head = insertBeforeKthElement(head, k, val);
        System.out.println("DLL insertion before Kth element ");
        printDLL(head);    



        Node target = head.next.next;
         insertBeforeGivenNode(head, target, val);
        System.out.println("DLL insertion before given node ");
        printDLL(head);
    }

}
