public class Queue_Using_Linkedlist {
    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static class Queue {
         Node rear;
         Node front;

        public Queue() {
            this.front = null;
            this.rear = null;

        }

        public boolean isEmpty() {
            return front == null;
        }

        public void enqueue(int data) {
            Node newNode = new Node(data);
            if (rear == null) {
                front = rear = newNode;
            } else {
                rear.next = newNode;
                rear = newNode;
            }
            System.out.println("ENQUEUED DATA : " + data);
        }

        public int dequeue() {
            if (isEmpty()) {
                System.out.println("QUEUE IS EMPTY");
                return -1;

            }
            int value = front.data;
            front = front.next;
            if (front == null) {
                rear = null;
            }
            System.out.println("DEQUEUED: " + value);
            return value;
        }

        public void display() {
            if (isEmpty()) {
                System.out.println("QUEUE IS EMPTY ");
                return;
            }
            Node temp = front;
            System.out.println("Queue Element ");
            while (temp != null) {
                System.out.print(temp.data + " ");
                temp = temp.next;
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Queue queue = new Queue();
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.dequeue();
        queue.display();

    }
}
