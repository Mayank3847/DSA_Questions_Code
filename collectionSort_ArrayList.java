import java.util.*;

public class collectionSort_ArrayList {
    public static void main(String[] args) {

        ArrayList<Integer> list = new ArrayList<>();

        // add operation
        list.add(7);
        list.add(2);
        list.add(1);
        list.add(4);
        list.add(3);
        list.add(6);
        System.out.println(list);

        Collections.sort(list);
        System.out.println(list);
        Collections.sort(list, Collections.reverseOrder()); 
        System.out.println(list);
    }

}
