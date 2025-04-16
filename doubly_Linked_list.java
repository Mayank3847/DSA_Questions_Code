public class doubly_Linked_list {
    public class Node {
        int data;
        Node next;
        Node prev;

        public Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;

        }
    }

    public static Node head;
    public static Node tail;
    public int size;

    public void addFirst(int data) {
        Node newNode = new Node(data);
        size++;
        if (head == null) {
            head = tail = newNode;
            return;
        }
        newNode.next = head;
        head.prev = newNode;
        head = newNode;
    }

    public void addLast(int data) {
        Node newNode = new Node(data);
        size++;
        if (head == null) {
            head = tail = newNode;
            return;
        }
        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;
    }

    public void print_doubly_Linked_list() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + "<-->");
            temp = temp.next;

        }
        System.out.println("NULL");
    }

    public int removeFirst() {
        if (head == null) {
            System.out.println("DLL IS EMPTY");
            return Integer.MIN_VALUE;
        }
        if (size == 1) {
            int val = head.data;
            head = tail = null;
            size--;
            return val;

        }
        int val = head.data;
        head = head.next;
        head.prev = null;
        size--;
        return val;
    }

    public int removeLast() {
        if (head == null) {
            System.out.println("DLL IS EMPTY");
            return Integer.MIN_VALUE;
        }
        int val = tail.data;
        if (size == 1) {
            head = tail = null;
        } else {
            tail = tail.prev;
            tail.next = null;
        }
        size--;
        return val;

    }

    public void reverse_dll() {
        Node curr = head;
        Node prev = null;
        Node next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            curr.prev = next;
            prev = curr;
            curr = next;

        }
        head = prev;

    }

    public static void main(String[] args) {
        doubly_Linked_list dll = new doubly_Linked_list();
        dll.addFirst(4);
        dll.addFirst(3);
        dll.addFirst(2);
        dll.addFirst(1);
        dll.print_doubly_Linked_list();
        System.out.println(dll.size);
        dll.removeFirst();
        dll.print_doubly_Linked_list();
        System.out.println(dll.size);
        dll.addLast(5);
        dll.print_doubly_Linked_list();
        System.out.println(dll.size);
        dll.removeLast();
        dll.print_doubly_Linked_list();
        System.out.println(dll.size);
        dll.reverse_dll();
        dll.print_doubly_Linked_list();

    }
}
