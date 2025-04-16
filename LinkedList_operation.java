import java.util.LinkedList;

public class LinkedList_operation {
    public static void main(String[] args) {
        LinkedList<Integer> ll = new LinkedList<>();
        ll.addFirst(1);
        ll.addFirst(2);
        ll.addFirst(3);
        ll.addFirst(4);
        ll.addLast(0);
        System.out.println(ll);
        System.out.println(ll.removeLast());
        System.out.println(ll.removeFirst());
        System.out.println(ll);

    }

}
