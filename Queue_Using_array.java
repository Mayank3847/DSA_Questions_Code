class Queue{
    int front ,rear,capacity;
    int[]queue;
    public Queue(int size){
        capacity=size;
        front =rear=0;
        queue=new int [capacity];
        
    }
    public boolean isFull(){
       return front==capacity;
    }
    public boolean isEmpty(){
        return front==rear;
    }
    public int getFront() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        } else {
            return queue[front];
        }
    }
    public int getRear() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        } else {
            return queue[rear - 1];
        }
    }
    public void enqueue(int data){
        if(isFull()){
            System.out.println("QUEUE IS FULL");
            
        }else{
            queue[rear]=data;
            rear++;
        }
    }
    public int dequeue(){
        if(isEmpty()){
            System.out.println("QUEUE IS EMPTY");
            return -1;
            
        }else{
            int item=queue[front];
            for(int i =0;i<rear-1;i++){
                queue[i]=queue[i+1];
            }
            rear--;
            return item;
        }
    }
    public void display(){
        if(front==rear){
            System.out.println("QUEUE IS EMPTY");
            
        }else{
            for(int i =front;i<rear;i++){
                System.out.print(queue[i]+" ");
            }
            System.out.println();
        }
    }
    public int getMin() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        } else {
            int min = queue[front]; // Start with the first element as the minimum
            for (int i = front + 1; i < rear; i++) {
                if (queue[i] < min) {
                    min = queue[i];
                }
            }
            return min;
        }
    }
}
public class Queue_Using_array {
public static void main(String[] args) {
    Queue queue = new Queue(5);
    queue.enqueue(20);
    queue.enqueue(30);
    queue.enqueue(40);
    queue.enqueue(50);
    System.out.println("QUEUE AFTER ENQUEUE OPERATION:");
    queue.display();
    queue.dequeue();
    System.out.println("Queue after dequeue operation");
    queue.display();
    System.out.println("Front element after dequeue: " + queue.getFront());
        System.out.println("Rear element after dequeue: " + queue.getRear());
        System.out.println("Minimum element in the queue: " + queue.getMin());

}
    
}