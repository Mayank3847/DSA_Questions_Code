import java.util.*;

public class stack_stock_span_problem {
    public static void stockspan(int stocks[], int span[]) {
        Stack<Integer> st = new Stack<>();
        span[0] = 1;
        st.push(0);
        for (int i = 1; i < stocks.length; i++) {
            int currPrice = stocks[i];
            while (!st.isEmpty() && currPrice > stocks[st.peek()]) {
                st.pop();

            }
            if (st.isEmpty()) {
                span[i] = i + 1;

            } else {
                int previousHigh = st.peek();
                span[i] = i - previousHigh;
            }
            st.push(i);

        }
    }

    public static void main(String[] args) {
        int stocks[] = { 100, 80, 60, 70, 60, 85, 100 };
        int span[] = new int[stocks.length];
        stockspan(stocks, span);
        for (int i = 0; i < span.length; i++) {
            System.out.print(span[i] + " ");
        }
    }

}
