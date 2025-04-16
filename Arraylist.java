import java.util.*;

public class Arraylist {

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();

        // add operation
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        System.out.println(list);
        // get operation
        list.get(3);
        System.out.println(list);
        // delete operation
        System.out.println(list.remove(5));
        // contains element ----return true or false if elements
        System.out.println(list.contains(2));
        System.out.println(list.contains(11));

        // adde element at index and element shiftedto the next element place
        list.add(1, 8);
        System.out.println(list);

        // size of an array list
        System.out.println("THE SIZE OF ARRAY LIST:" + list.size());

        for (int i = 0; i < list.size(); i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        // reverse an array

        for (int i = list.size() - 1; i >= 0; i--) {
            System.out.print(i + " ");
        }
    }
}
