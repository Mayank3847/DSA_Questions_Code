import java.util.*;

public class LinkedList_DLL_PairsWithGivenSum {
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

    public static ArrayList<ArrayList<Integer>> pairsWithGivenSum(Node head, int target) {
        Node temp1 = head;
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();

        while (temp1 != null) {
            Node temp2 = temp1.next;
            while (temp2 != null && (temp1.data + temp2.data <= target)) {
                if (temp1.data + temp2.data == target) {
                    ArrayList<Integer> pair = new ArrayList<>();
                    pair.add(temp1.data);
                    pair.add(temp2.data);
                    list.add(pair);
                }
                temp2 = temp2.next;
            }
            temp1 = temp1.next;
        }
        return list;
    }

    public static Node tailOfLL(Node head) {
        Node tail = head;
        while (tail.next != null) {
            tail = tail.next;  
        }
        return tail;

    }

    public static ArrayList<ArrayList<Integer>> pairsWithGivenSumOptimized(Node head, int val) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        Node left = head;
        Node right = tailOfLL(head);
        while (left.data < right.data) {
            if (left.data + right.data == val) {
                ArrayList<Integer> pair = new ArrayList<>();
                pair.add(left.data);
                pair.add(right.data);
                list.add(pair);
                left = left.next;
                right = right.prev;
            } else if (left.data + right.data < val) {
                left = left.next;

            } else {
                right = right.prev;

            }

        }
        return list;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 4, 5, 6, 8, 9 };
        int target = 10;
        Node head = convertToDLL(arr);

        ArrayList<ArrayList<Integer>> pairs = pairsWithGivenSum(head, target);
        System.out.println(pairs);

        ArrayList<ArrayList<Integer>> pairs1 = pairsWithGivenSum(head, target);
        System.out.println(pairs1);
    }

}
