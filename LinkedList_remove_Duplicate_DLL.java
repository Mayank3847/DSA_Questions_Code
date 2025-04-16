public class LinkedList_remove_Duplicate_DLL {
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

   public static Node removeDuplicates(Node head){
        Node temp=head;
        while(temp!=null&&temp.next!=null){
            Node nextNode =temp.next;
            while(nextNode!=null&&temp.data==nextNode.data){
                nextNode =nextNode.next;
            }
            temp.next=nextNode;
            
            if(nextNode!=null){
                nextNode.prev=temp;
                
            }
            temp=temp.next;
        }
        return head;
        // Code Here.
        
    }
public static void main(String[] args) {
    int[] arr = {1, 1, 2, 3, 3, 4, 5, 5}; // Example input with duplicates
        Node head = convertToDLL(arr);
        
        System.out.println("Original Doubly Linked List:");
        printDLL(head);

        head = removeDuplicates(head);

        System.out.println("Doubly Linked List after removing duplicates:");
        printDLL(head);
    
}
} 