
import java.util.HashMap;
import java.util.Map;

class Hashing_LRU_Cache {

    // class LRU{
    Node head = new Node(0, 0), tail = new Node(0, 0);
    Map<Integer, Node> map = new HashMap<>();
    int capacity;

    public Hashing_LRU_Cache(int capacity) {
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;
        // }
    }

    // get
    public int get(int key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            remove(node);
            insert(node);
            return node.value;

        } else {
            return -1;

        }
    }

    // put
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            remove(map.get(key));

        }
        if (map.size() == capacity) {
            remove(tail.prev);

        }
        insert(new Node(key, value));

    }

    public void remove(Node node) {
        map.remove(node.key);
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public void insert(Node node) {
        map.put(node.key, node);
        node.next = head.next;
        node.next.prev = node;
        head.next = node;
        node.prev = head;
    }
    public void printCache() {
        Node current = head.next;
        System.out.print("Cache state: ");
        while (current != tail) {
            System.out.print("-[" + current.key + "=" + current.value + "]-");
            current = current.next;
        }
        System.out.println();
    }

    class Node {
        Node prev, next;
        int key, value;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;

        }
    }

    public static void main(String[] args) {

        Hashing_LRU_Cache cache = new Hashing_LRU_Cache(4);
       cache.put(2, 6);
        cache.printCache(); // Cache state: [2=6]
        
        cache.put(4, 7);
        cache.printCache(); // Cache state: [4=7] [2=6]
        
        cache.put(8, 11);
        cache.printCache(); // Cache state: [8=11] [4=7] [2=6]
        
        cache.put(7, 10);
        cache.printCache(); // Cache state: [7=10] [8=11] [4=7] [2=6]
        
        System.out.println(cache.get(2)); // Returns 6
        cache.printCache(); // Cache state: [2=6] [7=10] [8=11] [4=7]
        
        System.out.println(cache.get(8)); // Returns 11
        cache.printCache(); // Cache state: [8=11] [2=6] [7=10] [4=7]
        
        cache.put(5, 6); // Evicts 4
        cache.printCache(); // Cache state: [5=6] [8=11] [2=6] [7=10]
        
        System.out.println(cache.get(7)); // Returns 10
        cache.printCache(); // Cache state: [7=10] [5=6] [8=11] [2=6]
        
        cache.put(5, 7); // Updates the value of key 5
        cache.printCache();
    }
}
