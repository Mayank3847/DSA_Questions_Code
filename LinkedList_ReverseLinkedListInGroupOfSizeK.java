public class LinkedList_ReverseLinkedListInGroupOfSizeK {
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

public static Node reverseLL(Node head){
    Node temp=head;
    Node prev=null;
    while(temp!=null){
        Node front=temp.next;
        temp.next=prev;
        prev=temp;
        temp=front;
    }
    return prev;
}

    public static Node getKthNode(Node temp, int k) {
        k -= 1;
        while (temp != null && k > 0) {
            k--;
            temp = temp.next;
        }
        return temp;
    }

    public static Node kReverse(Node head, int k) {
        Node temp=head;
        Node prevLast=null;
        Node newHead =  null;

        while(temp!=null){
            Node kthNode=getKthNode(temp, k);
            if(kthNode==null){
                if(prevLast!=null){
                    prevLast.next=temp;
                }
                break;
            }
            Node nextNode=kthNode.next;
            kthNode.next=null;
            Node reversedHead = reverseLL(temp);
            if(temp==head){
                head=kthNode;
            }else{
                prevLast.next=reversedHead ;
            }
            prevLast=temp;
            temp=nextNode;
        }
        return newHead != null ? newHead : head; 


    }
    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int k = 3;

        Node head = convertArr2LL(arr);
        System.out.println("Original Linked List:");
        printLL(head);

        head = kReverse(head, k);
        System.out.println("Linked List after k-Reverse:");
        printLL(head); 
    }
}
