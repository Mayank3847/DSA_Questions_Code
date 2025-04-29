//ex   5,4,3,5,4,2,1,2,1,6,3  ---sort--->>1,1,2,2,3,3,4,4,5,5,5----break in two past such that which consist of consecutive sequences sucha as 1,2,3,4,5 and 1,2,3,4,5     out of which we have to find the maximum length  of those pairs 

import java.util.*;

public class LeastBeautifulBox {
    public static int getMaximumLengthConsecutive(int arr[]) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);

        }
        int ans = 0;
        List<Integer> list = new ArrayList<>(map.keySet());

        for (int i = 0; i < list.size(); i++) {
            int currBeauty = Integer.MAX_VALUE;
            int val = list.get(i);
            int j = i;
            while (j < list.size() && list.get(j) == val) {
                currBeauty = Math.min(currBeauty, map.get(list.get(j)));
                val++;
                j++;

            }
            ans=Math.max(ans,currBeauty);
        }
        return ans;
    }
    public static void main(String[] args) {
        int []id = {5,1,3,2,3,4,4,1,2};
        System.out.println(getMaximumLengthConsecutive(id));
    }

}
