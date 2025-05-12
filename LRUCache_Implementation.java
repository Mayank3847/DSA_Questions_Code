import java.util.*;

public class LRUCache_Implementation {
    static Node head = new Node(0, 0);
    static Node tail = new Node(0, 0);
    static int capacity;  
    static HashMap<Integer, Node> map = new HashMap<>();

    public LRUCache_Implementation(int cap) {
        capacity=cap;
        head.next = tail;
        tail.prev = head;

    }
 
    public static class Node {
        int key, val;
        Node next, prev;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;

        }
    }
    public static void put(int key,int val){
        if(map.containsKey(key)){
              remove(map.get(key));
        }
        if(map.size()==capacity){
            remove(tail.prev);

        }
        insert (new Node(key, val));
    }
    public static void insert(Node node){
        map.put(node.key,node);
        Node headNext=head.next;
        head.next=node;
        node.next=headNext;
        headNext.prev=node;
        node.prev=head;
    }
    public static void remove(Node node){
        map.remove(node.key);
        node.prev.next=node.next;
        node.next.prev=node.prev;
    }
    public static int get (int key){
        if(map.containsKey(key)){
            Node node=map.get(key);
            remove(node);
            insert(node);
            return node.val;
        }else{
            return -1;
        }

    }
    public static void main(String[] args) {
        new LRUCache_Implementation(2);

        put(1, 1); // cache: {1=1}
        put(2, 2); // cache: {2=2, 1=1}

        System.out.println(get(1)); // returns 1, cache: {1=1, 2=2}

        put(3, 3); // evicts key 2, cache: {3=3, 1=1}

        System.out.println(get(2)); // returns -1 (not found)

        put(4, 4); // evicts key 1, cache: {4=4, 3=3}

        System.out.println(get(1)); // returns -1 (not found)
        System.out.println(get(3)); // returns 3
        System.out.println(get(4)); // returns 4
    }

}
