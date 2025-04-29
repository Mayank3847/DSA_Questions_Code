import java.util.*;

public class Stack_Remove_Kth_Digits {
    public static String removeKDigit(String num, int k) {

        Deque<Character> dq = new ArrayDeque<>();
        for (int i = 0; i < num.length(); i++) {
            char ch = num.charAt(i);
            while (k > 0 && !dq.isEmpty() && dq.peekLast() > ch) {
                dq.pollLast();
                k--;
 
            }
            dq.addLast(ch);
        }
        while (k > 0 && !dq.isEmpty()) {
            dq.pollLast();
            k--;
        }
        StringBuilder sb = new StringBuilder();
        List<Character> list = new ArrayList<>(dq);
        for (int i = 0; i < list.size(); i++) {
            char ch1 = list.get(i);
            sb.append(ch1);
        }
        while(sb.length()>0&&sb.charAt(0)=='0'){
            sb.deleteCharAt(0);
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }
    public static void main(String[] args) {
        System.out.println(removeKDigit("1432219", 3)); 
        System.out.println(removeKDigit("10200", 1));      
        System.out.println(removeKDigit("10", 2));  
    }

}
