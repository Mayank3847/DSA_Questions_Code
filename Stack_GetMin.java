import java.util.Stack;


    class Stack_GetMin {

        public class Pair {
            int x, y;

            Pair(int x, int y) {
                this.x = x;
                this.y = y;
            }
        }

        Stack<Pair> st;

        public Stack_GetMin() {
            st = new Stack<>();

        }

        public void push(int val) {
            int min;
            if (st.isEmpty()) {
                min = val;

            } else {
                min = Math.min(st.peek().y, val);
            }
            st.push(new Pair(val, min));

        }

        public void pop() {
            st.pop();
        }

        public int top() {
            return st.peek().x;

        }

        public int getMin() {
            return st.peek().y;

        }

    

    public static void main(String[] args) {
        Stack_GetMin s = new Stack_GetMin();
        s.push(5);
        s.push(3);
        s.push(7);
        s.push(2);
        s.push(6);
        System.out.println(s.getMin()); // prints 2
       

    }
}
