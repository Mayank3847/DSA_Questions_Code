
/**
 * hashing
 */
//import java.util.HashSet;
import java.util.Iterator;
import java.util.*;
//import java.util.LinkedHashSet;
import java.util.TreeSet;

public class hashing {

    public static void main(String[] args) {

        // ----------------------HASH SET-----------------
        // creation
        HashSet<Integer> set = new HashSet<>();
        // insert element in set
        set.add(1);

        set.add(2);
        set.add(4);
        set.add(3);

        set.add(2);
        set.add(5);
        set.add(6);

        set.add(7);
        set.add(8);
        set.add(9);

        // search
        set.contains(4);
        System.out.println(("Sets contained!!!"));
        if (!set.contains(6)) {
            System.out.println("NOT CONTAINS.......");
        }
        // REMOVE
        set.remove(2);
        if (!set.contains(2)) {
            System.out.println("NOT CONTAINED-----WE DELETED !!");
        }
        // SIZE
        System.out.println(set.size());
        System.out.println(set);
        // iterator
        Iterator<Integer> it = set.iterator();
        while (it.hasNext()) {
            System.out.print(it.next() + " ");

            // ---------------------LINKED HASH SET-----------------------------
            LinkedHashSet<Integer> lhs = new LinkedHashSet<>();
            // insert element in set
            lhs.add(1);

            lhs.add(2);
            lhs.add(4);
            lhs.add(3);

            lhs.add(2);
            lhs.add(5);
            lhs.add(6);

            lhs.add(7);
            lhs.add(8);
            lhs.add(9);

            // search
            lhs.contains(4);
            System.out.println(("Sets contained!!!"));
            if (!lhs.contains(6)) {
                System.out.println("NOT CONTAINS.......");
            }
            // REMOVE
            lhs.remove(2);
            if (!lhs.contains(2)) {
                System.out.println("NOT CONTAINED-----WE DELETED !!");
            }
            // SIZE
            System.out.println(lhs.size());
            System.out.println(lhs);
            // iterator
            Iterator<Integer> lhs_it = lhs.iterator();
            while (lhs_it.hasNext()) {
                System.out.print(lhs_it.next() + " ");

                // -------------------***********TREE SET**********------------------
                TreeSet<Integer> ts = new TreeSet<>();
                // insert element in set
                ts.add(1);

                ts.add(2);
                ts.add(4);
                ts.add(3);
                ts.add(2);
                ts.add(5);
                ts.add(6);

                ts.add(7);
                ts.add(8);
                ts.add(9);

                // search
                ts.contains(4);
                System.out.println(("Sets contained!!!"));
                if (!ts.contains(6)) {
                    System.out.println("NOT CONTAINS.......");
                }
                // REMOVE
                ts.remove(2);
                if (!ts.contains(2)) {
                    System.out.println("NOT CONTAINED-----WE DELETED !!");
                }
                // SIZE
                System.out.println(ts.size());
                System.out.println(ts);
                // iterator
                Iterator<Integer> ts_it = ts.iterator();
                while (ts_it.hasNext()) {
                    System.out.print(ts_it.next() + " ");

                }

            }
        }
    }
}
