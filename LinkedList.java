 //import java.util.*;

public class LinkedList {

    // initializing linked list details such as node head tail etc
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
    public static int size;

    public LinkedList() {
        this.head = null;
        this.tail = null;
    }

    // print linked linst
    public void printLnkedList() {
        if (head == null) {
            System.out.println("LINKED LIST IS EMPTY!");
            return;

        }
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + "-->");
            temp = temp.next;
        }
        System.out.println("NULL");
    }

    // add elements in the beggining of the list

    public void addFirst(int data) {
        Node newNode = new Node(data);
        size++;
        if (head == null) {
            head = tail = newNode;
            return;

        }
        newNode.next = head;

        head = newNode;
    }

    // add elements in the last

    public void addLast(int data) {
        Node newNode = new Node(data);
        size++;
        if (head == null) {
            head = tail = newNode;
            return;

        }
        tail.next = newNode;
        tail = newNode;
    }

    // add elements in the middle index
    public void addMiddle(int index, int data) {
        if (index == 0) {
            addFirst(data);
            return;
        }
        Node newNode = new Node(data);
        size++;
        Node temp = head;
        int i = 0;
        while (i < index - 1) {
            temp = temp.next;
            i++;
            // temp=temp.next;
        }

        newNode.next = temp.next;
        temp.next = newNode;
    }

    // remove the first elemeent from the list
    public int removeFirst() {
        if (size == 0) {
            System.out.println("LINKED LIST IS EMPTY");
            return Integer.MAX_VALUE;// which return infinity value or such as null value
        } else if (size == 1) {
            int val = head.data;
            head = tail = null;
            size = 0;
            return val;
        }
        int val = head.data;
        head = head.next;
        size--;
        return val;
    }

    // remove last element
    public int removeLast() {
        if (size == 0) {
            System.out.println("LINKED LIST IS EMPTY!");

            return Integer.MIN_VALUE;
        } else if (size == 1) {
            int val = head.data;
            head = tail = null;
            size = 0;
            return val;
        }
        // previous:i=size-2;
        Node prev = head;
        for (int i = 0; i < size - 2; i++) {
            prev = prev.next;
        }
        int val = prev.next.data;// we can call as tail also
        prev.next = null;
        tail = prev;
        size--;
        return val;

    }

    // iterative search key elements in the list
    public int iterativeSearech(int key) {
        Node temp = head;
        int i = 0;
        while (temp != null) {
            if (temp.data == key) {
                return i;

            }
            temp = temp.next;
            i++;

        }
        return -1;
    }

    // RECURSIVE SEARCH-----SEARCH ELEMENT USING RECURSION
    public int helper(Node head, int key) {
        if (head == null) {
            return -1;

        }
        if (head.data == key) {
            return 0;
        }
        int index = helper(head.next, key);
        if (index == -1) {
            return -1;

        }
        return index + 1;

    }

    public int recurssiveSearch(int key) {
        return helper(head, key);
    }

    public void reverse() {
        Node Prev = null;
        Node curr = tail = head;
        Node next;
        while (curr != null) {
            next = curr.next;
            curr.next = Prev;
            Prev = curr;
            curr = next;

        }
        head = Prev;       
    }

    // FIND AND REMOVE NTH NODE OF THE ELEMENT
    public void deleteNthNode(int n) {
        // calculate size
        int size = 0;
        Node temp = head;
        while (temp != null) {
            temp = temp.next;
            size++;

        }
        if (n == size) {
            head = head.next;
            return;

        }
        // size n-1 to reache the previous of nth node which is to be deleted
        int i = 1;
        int iToFind = size - n;
        Node prev = head;
        while (i < iToFind) {
            prev = prev.next;
            i++;
        }
        prev.next = prev.next.next;
        return;

    }

    // CHECK IF A LINKED LIST IS A PALINDROME OR NOT!!!!
    // ***************SLOW FAST APPROACHJUST LIKE A 2 POINTER APPROACH***********

    private Node findMiNode(Node head) {
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next; // +1 step
            fast = fast.next.next;

        }
        return slow;
    }

    public boolean checkPalindrome() {
        if (head == null || head.next == null) {
            return true;

        }

        // step 1-----array list ----
        Node mid = findMiNode(head);

        // step 2 - reverse the number

        Node curr = mid;
        Node prev = null;
        while (curr != null) {
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;

        }
        Node right = prev;
        Node left = head;

        // check the left and right half that is equal or not
        while (right != null) {
            if (left.data != right.data) {
                return false;
            }
            left = left.next;
            right = right.next;
        }
        return true;

    }

    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        // // ll.printLnkedList();
        // ll.addFirst(1);
        // // ll.printLnkedList();
        // ll.addFirst(2);
        // // ll.printLnkedList();
        // // ll.printLnkedList();

        // ll.addLast(3);
        // // ll.printLnkedList();
        // ll.addLast(3);

        // ll.addLast(2);
        // // ll.printLnkedList();

        // ll.addLast(1);
        // // ll.addMiddle(2, 9);
        ll.addFirst(1);
        ll.addFirst(2);
        ll.addFirst(3);
        ll.addFirst(3);
        ll.addFirst(2);
        ll.addFirst(1);



;
        ll.printLnkedList();

        // System.out.println("SIZE OF THE LINKED LIST :" + size);
        // ll.removeFirst();
        // ll.printLnkedList();
        // System.out.println("THE UPDATED SIZE OF THE LINKED LIST :" + size);
        // ll.removeLast();
        // ll.printLnkedList();
        // System.out.println("THE UPDATED SIZE OF THE LINKED LIST :" + size);

        // System.out.println("YOUR KEY ELEMENT AT INDEX :" + ll.iterativeSearech(3));
        // System.out.println(ll.iterativeSearech(10));

        // System.out.println("YOUR KEY ELEMENT AT INDEX :" + ll.recurssiveSearch(3));
        // System.out.println(ll.recurssiveSearch(10));

        // ll.reverse();
        // ll.printLnkedList();

        // ll.deleteNthNode(3);

        // ll.printLnkedList();
        System.out.println(ll.checkPalindrome());

    }
}
