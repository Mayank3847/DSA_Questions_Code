public class queue_by_array {
    static class Queue {
        static int arr[];
        static int size;
        static int rear;

        Queue(int n) {
            arr = new int[n];
            size = n;
            rear = -1;
        }

        public boolean isEmpty() {
            return rear == -1;
        }

        // add
        public void add(int data) {
            if (rear == size - 1) {
                System.out.println("QUEUE IS FULL");
                return;
            }

            rear = rear + 1;
            arr[rear] = data;
        }

        // remove
        public int remove() {
            if (isEmpty()) {
                System.out.println("EMPTY QUEUE");
                return -1;

            }
            int front = arr[0];
            for (int i = 0; i < rear; i++) {
                arr[i] = arr[i + 1];

            }
            rear = rear - 1;
            return front;
        }

        // peek
        public int peek() {
            if (isEmpty()) {
                System.out.println("EMPTY QUEUE");
                return -1;
            }
            return arr[0];
        }
    }

    public static void main(String[] args) {
        Queue qu = new Queue(5);
        qu.add(1);
        qu.add(2);
        qu.add(3);
        qu.add(4);
        while (!qu.isEmpty()) {
            System.out.print(qu.peek()+" ");
            qu.remove();
        }

    }

}
