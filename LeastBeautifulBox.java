//ex   5,4,3,5,4,2,1,2,1,6,3  ---sort--->>1,1,2,2,3,3,4,4,5,5,5----break in two past such that which consist of consecutive sequences sucha as 1,2,3,4,5 and 1,2,3,4,5     out of which we have to find the maximum length  of those pairs 

import java.util.*;

public class LeastBeautifulBox {
    public static int getMaximumLengthConsecutive(int id[],int n) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            map.put(id[i], map.getOrDefault(id[i], 0) + 1);

        }
        
       
    }
    public static void main(String[] args) {
        int []id = {5,1,3,2,3,4,4,1,2};
        int n=id.length;
        System.out.println(getMaximumLengthConsecutive(id,n));
    }

}
