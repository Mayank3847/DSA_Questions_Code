import java.util.*;
public class PQ_Jcf {

    public static void main(String[] args) {
       // PriorityQueue<Integer>pq=new PriorityQueue<>();

        PriorityQueue<Integer>pq=new PriorityQueue<>(Comparator.reverseOrder());
        pq.add(7);
        pq.add(10);
        pq.add(1);
        pq.add(6);
        pq.add(3);
        pq.add(12);
        while (!pq.isEmpty()) {
            System.out.println(pq.peek());
            pq.remove();
            
        }

    }
}
