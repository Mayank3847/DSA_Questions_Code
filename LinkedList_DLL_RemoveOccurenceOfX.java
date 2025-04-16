public class LinkedList_DLL_RemoveOccurenceOfX {
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
    public static Node deleteAllOccurOfX(Node head, int x) {
        Node temp=head;
        while(temp!=null){
            if(temp.data==x){
                if(temp==head){
                    head=head.next;
                    
                }
                 Node prevNode=temp.prev;
                 Node nextNode=temp.next;
                 if(prevNode!=null){
                     prevNode.next=nextNode;
                 }
                 if(nextNode!=null){
                     nextNode.prev=prevNode;
                     
                 }
                 temp=nextNode;
            }else{
                temp=temp.next;
            }
        }
        return head;
        
    }
    public static void main(String[] args) {
        int[] arr = {2,2, 1, 2, 3, 2, 4, 2, 5};
        Node head = convertToDLL(arr);
        System.out.println("Original DLL:");
        printDLL(head);

        int x = 2;
        head = deleteAllOccurOfX(head, x);
        System.out.println("DLL after removing all occurrences of " + x + ":");
        printDLL(head);
    }
    
}
