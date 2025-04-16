public class LinkedList_remove_a_loop {
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

    public void removeCycle() {
        // detect cycle
        Node slow = head;
        Node fast = head;
        boolean cycle = false;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) {
                cycle = true;
                break;
            }
        }
        if (cycle == false) {
            return;

        }
        // find meeting point
        slow = head;
        Node prev = null;
        while (slow != fast) {
            prev = fast;
            slow = slow.next;
            fast = fast.next;
        }
        //remove the cycle 
        while(fast.next!=slow){
            fast=fast.next;
            

        }
        fast.next=null;

    }

    public static void main(String[] args) {
        LinkedList_remove_a_loop list = new LinkedList_remove_a_loop();

        list.addNode(1);
        list.addNode(2);
        list.addNode(3);

        // Creating a loop for testing
        list.head.next.next.next = list.head;
        System.out.println(list.isCycle());
        list.removeCycle();
        System.out.println(list.isCycle());
    }

}
