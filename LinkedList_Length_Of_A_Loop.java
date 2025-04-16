import java.util.*;

public class LinkedList_Length_Of_A_Loop {
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

    public static int lengthOfLoop(Node head) {
        HashMap<Node, Integer> map = new HashMap<>();
        Node temp = head;
        int timer = 0;
        while (temp != null) {
            if (map.containsKey(temp)) {
                int loopLength = timer - map.get(temp);
                return loopLength;
            }
            map.put(temp, map.getOrDefault(temp, 0) + 1);
            temp = temp.next;
            timer++;
        }
        return 0;
    }

    public static int lengthOfLoopOptimized(Node head){
        Node slow=head;
        Node fast=head;
        while(fast != null && fast.next != null){
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast){
                return findLength(slow, fast);
            }
        }
        return 0;
    }
    public static int findLength(Node slow,Node fast){
        int cnt=1;
        fast=fast.next;
        while(slow!=fast){
            cnt++;
            fast=fast.next;

        }
        return cnt;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5 };

        Node head = convertArr2LL(arr);
        Node temp = head;
        Node loopNode = null;
        int pos = 1;
        int count = 0;

        while (temp.next != null) {
            if (count == pos) {
                loopNode = temp;
            }
            temp = temp.next;
            count++;
        }
        temp.next = loopNode;

        int loopLength = lengthOfLoop(head);
        if (loopLength > 0) {
            System.out.println("Length of the loop: " + loopLength);
        } else {
            System.out.println("No loop detected in the linked list.");
        }
        int loopLength1 = lengthOfLoopOptimized(head);
        if (loopLength > 0) {
            System.out.println("Length of the loop: " + loopLength1 );
        } else {
            System.out.println("No loop detected in the linked list.");
        }

    }
}
