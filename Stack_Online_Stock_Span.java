import java.util.*;

public class Stack_Online_Stock_Span {
    ArrayList<Integer> arr;

    public Stack_Online_Stock_Span() {
        idx = -1;
        st = new Stack<>();

        arr = new ArrayList<>();
    }

    public int nextSpan(int val) {
        arr.add(val);
        int cnt = 1;
        for (int i = arr.size() - 2; i >= 0; i--) {
            if (arr.get(i) <= val) {
                cnt++;
            } else {
                break;
            }
        }
        return cnt;
    }

    static class Pair {
        int prices;
        int indexes;

        Pair(int prices, int indexes) {
            this.prices = prices;
            this.indexes = indexes;
        }

    }

    Stack<Pair> st;
    int idx;

    public int nextSpanOptimized(int val) {
        idx++;
        while (!st.isEmpty() && st.peek().prices <= val) {
            st.pop();
        }
        int ans;
        if (st.isEmpty()) {
            ans = idx + 1;
        } else {
            ans = idx - st.peek().indexes;
        }
        st.push(new Pair(val, idx));
        return ans;
    }

    public static void main(String[] args) {
        Stack_Online_Stock_Span sol = new Stack_Online_Stock_Span();
        int[] prices = { 100, 80, 60, 70, 60, 75, 85 };
        for (int i = 0; i < prices.length; i++) {
            int span = sol.nextSpan(prices[i]);
            System.out.println("Price: " + prices[i] + ", Span: " + span);
        }
        System.out.println("Optimized solution --------->>");
        for (int i = 0; i < prices.length; i++) {
            int span = sol.nextSpanOptimized(prices[i]);
            System.out.println("Price: " + prices[i] + ", Span: " + span);
        }

    }

}
