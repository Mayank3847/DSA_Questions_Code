import java.util.Stack;

public class queue_using_2_stacks {
    static class queue {
        static Stack<Integer> st1 = new Stack<>();
        static Stack<Integer> st2 = new Stack<>();

        public boolean isEmpty() {
            return st1.isEmpty();

        }

        // add
        public void add(int data) {
            while (!isEmpty()) {
                st2.push(st1.pop());
            }
            st1.push(data);
            while (!st2.isEmpty()) {
                st1.push(st2.pop());
            }
        }

        public int remove() {
            if (isEmpty()) {
                System.out.println("QUEUE EMPTY");
                return -1;
            }
            return st1.pop();

        }

        // peek
        public int peek() {
            if (isEmpty()) {
                System.out.println("QUEUE EMPTY");
                return -1;
            }
            return st1.peek();

        }

    }

    public static void main(String[] args) {
        queue qu = new queue();
        qu.add(1);
        qu.add(2);
        qu.add(3);
        qu.add(4);
        qu.add(5);
        while (!qu.isEmpty()) {
            System.out.print(qu.peek() + " p");
            qu.remove();
        }

    }

}
