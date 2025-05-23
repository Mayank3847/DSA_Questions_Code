public class circular_queue_array {
    static class Queue {
        static int arr[];
        static int size;
        static int rear;
        static int front;

        Queue(int n) {
            arr = new int[n];
            size = n;
            rear = -1;
            front = -1;
        }

        public boolean isEmpty() {
            return rear == -1 & front == -1;
        }

        public static boolean isFull() {
            return (rear + 1) % size == front;
        }

        // add
        public void add(int data) {
            if (isFull()) {
                System.out.println("QUEUE IS FULL");
                return;
            } // add first element
            if (front == -1) {
                front = 0;
            }
            rear = (rear + 1) % size;
            arr[rear] = data;
        }

        // remove
        public int remove() {
            if (isEmpty()) {
                System.out.println("EMPTY QUEUE");
                return -1;
            }
            int result = arr[front];

            // last element delete
            if (rear == front) {
                rear = front = -1;
            } else {
                front = (front + 1) % size;
            }
            return result;
        }
        // peek

        public int peek() {
            if (isEmpty()) {
                System.out.print("Empty Queue");
                return -1;
            }
            return arr[front];
        }

    }

    public static void main(String[] args) {
        Queue qu = new Queue(5);
        qu.add(1);
        qu.add(2);
        qu.add(3);
         System.out.print(qu.remove()+" ");
        qu.add(4);
        System.out.print(qu.remove()+" ");
        qu.add(5);
        while (!qu.isEmpty()) {
            System.out.print(qu.peek() + " ");
            qu.remove();
        }

    }
}
