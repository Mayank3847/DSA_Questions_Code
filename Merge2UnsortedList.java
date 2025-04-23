import java.util.*;
public class Merge2UnsortedList {
    public static class Node{
        int data;
        Node next;
        public Node(int data,Node next){
            this.data=data;
            this.next=null;
        }
        public Node(int data){
            this.data=data;
        }
    }
    public static void printList(Node head) {
        while (head != null) {
            System.out.print(head.data + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }
    public static Node insert(Node head, int data) {
        if (head == null) return new Node(data);
        Node temp = head;
        while (temp.next != null) temp = temp.next;
        temp.next = new Node(data);
        return head;
    }

    public static Node mergeUnsortedLL(Node head1,Node head2){
        Node current1=head1;
        Node current2=head2;
        List<Integer>list=new ArrayList<>();

        while(current1!=null){
            list.add(current1.data);
            current1=current1.next;


        }
        
        while(current2!=null){
            list.add(current2.data);
            current2=current2.next;


        }
        Collections.sort(list);
      Node currNode=new Node(-1);
      Node dummy= currNode;
      for(int i =0;i<list.size();i++){
        int val=list.get(i);
        currNode.next=new Node(val);
        currNode=currNode.next;
      }
      return dummy.next;
    }




    //  Optimal: Sort each list, then merge them
    //Get Middle
    public static Node getMiddle(Node head){
        if (head == null || head.next == null) return head;
    
        Node slow = head;
        Node fast = head;
        Node prev = null; 
    
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
    
        if (prev != null) prev.next = null;
    
        return slow; 
    }
    

    public static Node merge2Sorted(Node head){
        if (head == null || head.next == null) return head;
    
        Node mid = getMiddle(head);
        Node left = merge2Sorted(head); // head to mid-1
        Node right = merge2Sorted(mid); // mid to end
    
        return mergeSortedList(left, right);
    }
    

    public static Node mergeSortedList(Node l1,Node l2){
        Node dummy=new Node(-1);
        Node current=dummy;
        while(l1!=null&&l2!=null){
            if(l1.data<l2.data){
                current.next=l1;
                l1=l1.next;
            }else{
                current.next=l2;
                l2=l2.next;
            }
            current=current.next;
        }
        current.next = (l1 != null) ? l1 : l2;
        return dummy.next;
    }

    public static Node mergeUnsortedOptimal(Node head1, Node head2) {
        head1 = merge2Sorted (head1);
        head2 = merge2Sorted(head2);
        return mergeSortedList(head1,head2);
    }


    public static void main(String[] args) {
        Node head1 = null;
        Node head2 = null;

        // Create first unsorted list
        head1 = insert(head1, 7);
        head1 = insert(head1, 2);
        head1 = insert(head1, 9);

        // Create second unsorted list
        head2 = insert(head2, 5);
        head2 = insert(head2, 1);
        head2 = insert(head2, 4);

        System.out.println("List 1:");
        printList(head1);
        System.out.println("List 2:");
        printList(head2);

        Node bruteResult = mergeUnsortedLL(head1, head2);
        System.out.println("\nMerged List (Brute Force):");
        printList(bruteResult);

        head1 = null;
        head2 = null;
        head1 = insert(head1, 7);
        head1 = insert(head1, 2);
        head1 = insert(head1, 9);
        head2 = insert(head2, 5);
        head2 = insert(head2, 1);
        head2 = insert(head2, 4);

        // Test Optimal
        Node optimalResult = mergeUnsortedOptimal(head1, head2);
        System.out.println("\nMerged List (Optimal):");
        printList(optimalResult);

    }
}
    

