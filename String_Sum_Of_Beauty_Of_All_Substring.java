import java.util.*;

public class String_Sum_Of_Beauty_Of_All_Substring {
    public static int beautySum(String s) {
        int n = s.length();
        int totalBeauty = 0;
        for (int i = 0; i < n; i++) {
            HashMap<Character, Integer> map = new HashMap<>();

            for (int j = i; j < n; j++) {
                char ch = s.charAt(j);
                map.put(ch, map.getOrDefault(ch, 0) + 1);
                Object[]value=map.values().toArray();
                int maxFreq=Integer.MIN_VALUE;
                int minFreq=Integer.MAX_VALUE;
                for(int k =0;k<value.length;k++){
                    int freq=(int)value[k];
                    maxFreq=Math.max(maxFreq, freq);
                    if(freq>0){
                        minFreq=Math.min(freq,minFreq);
                    }
                }
                totalBeauty+=(maxFreq-minFreq);
            }
        }
        return totalBeauty;
    }
    public static void main(String[] args) {
        String s = "aabcbaa";
        int result = beautySum(s);
        System.out.println("Sum of beauty of all substrings: " + result);
    
    }
}
