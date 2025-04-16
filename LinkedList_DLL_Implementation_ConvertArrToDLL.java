
public class LinkedList_DLL_Implementation_ConvertArrToDLL {
    
public  static class Node{
    int data;
    Node next;
    Node prev;
    public Node(int data,Node next,Node prev){
        this.data=data;
        this.next=next;
        this.prev=prev;

        
    }
    public Node(int data){
        this.data=data;
        this.next=null;
        this.prev=null;

    }
}
    public static void printDLL (Node head){
        while(head!=null){
            System.out.print(head.data+" <==> ");
            head=head.next;
        }
        System.out.println("null");
    }
    public static Node convertToDLL(int arr[]){
        Node head=new Node(arr[0]);
        Node prev=head;
        for(int i =1;i<arr.length;i++){
            Node temp=new Node(arr[i],null,prev);
            prev.next=temp;
            prev=temp;
        }
        return head;
    } 
    public static void main(String[] args) {
        int arr[] = { 2, 5, 6, 8 };
        Node head=convertToDLL(arr);
        printDLL(head);
        
    }
    
}
