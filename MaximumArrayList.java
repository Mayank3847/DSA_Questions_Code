import java.util.LinkedList;
public class MaximumArrayList {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();

        // add operation
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        System.out.println(list);

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < list.size(); i++) {
            if (max < list.get(i)) {
                max = list.get(i);
            }
        }
        System.out.println("MAXIMUM ELEMENT: " + max);
    }
}