class Node {
    int data;
    Node next;

    public Node(int data) {

        this.data = data;
        this.next = null;
    }
}

public class LinkedList_Implementation {
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

    public static int lengthOfLL(Node head) {
        int cnt = 0;
        Node temp = head;
        while (temp != null) {
            temp = temp.next;
            cnt++;
        }
        return cnt;

    }

    public static boolean isPresent(Node head, int val) {
        Node temp = head;
        while (temp !=null) {
            if (temp.data == val) {
                return true;

            }
            temp=temp.next;
        }
        return false;
    }

    

    public static void main(String[] args) {
        int arr[] = { 2, 5, 6, 8 };
        Node y = new Node(arr[3]);
        System.out.println(y.data);
        Node head = convertArr2LL(arr);
        System.out.println(head.data);
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
        System.out.println("Size of LL : " + lengthOfLL(head));
        boolean result=isPresent(head, 8);
        System.out.println(result);
    }
}