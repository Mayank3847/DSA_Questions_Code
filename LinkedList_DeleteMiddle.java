public class LinkedList_DeleteMiddle {
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

    public static Node deleteMiddle(Node head) {
        if (head == null || head.next == null) {
            return null;  
        }
        Node temp = head;
        int cnt = 0;
        while (temp != null) {
            cnt++;
            temp = temp.next;

        }
        int res = cnt / 2;
        temp=head;
        while (temp != null) {
            res--;
            if (res == 0) {
               // Node middle = temp.next;
              //  middle.next = null;
                temp.next = temp.next.next;
                break;
            }
            temp = temp.next;

        }
        return head;
    }



    public static Node deleteMiddleOptimized(Node head){
        if(head==null||head.next==null){
            return null;

        }
        Node fast=head;
        Node slow=head;
        fast=fast.next.next;
        while(fast != null && fast.next != null){
            slow=slow.next;
            fast=fast.next.next;
            
        }
        if(slow.next!=null){
            slow.next=slow.next.next;
        }
        return head;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        Node head = convertArr2LL(arr);

        System.out.println("Original Linked List:");
        printLL(head);

        head = deleteMiddle(head);

        System.out.println("Linked List after deleting the middle node:");
        printLL(head);


        int[] arr1 = {1, 2, 3, 4, 5};
        Node head1 = convertArr2LL(arr1);


        head1=deleteMiddleOptimized(head1);
        System.out.println("Linked List after deleting the middle node:");
        printLL(head1);



    }
}
