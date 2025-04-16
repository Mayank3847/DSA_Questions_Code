public class CircularLinkedList {
    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node last;

    public CircularLinkedList() {
        last = null;
    }

    // Insert a new node at the beginning
    public void insertAtBeginning(int data) {
        Node newNode = new Node(data);
        if (last == null) {
            last = newNode;
            last.next = last;
        } else {
            newNode.next = last.next;
            last.next = newNode;
        }
    }

    // Insert a new node at a specific position
    public void insertAtPosition(int data, int position) {
        Node newNode = new Node(data);

        if (last == null) {
            if (position != 1) {
                System.out.println("Position out of bounds. Inserting at position 1.");
            }
            last = newNode;
            last.next = last;
        } else if (position == 1) {
            // Inserting at the beginning
            newNode.next = last.next;
            last.next = newNode;
        } else {
            Node current = last.next;
            Node previous = last;
            int currentPosition = 1;

            while (currentPosition < position - 1 && current != last) {
                previous = current;
                current = current.next;
                currentPosition++;
            }

            if (currentPosition == position - 1) {
                newNode.next = current;
                previous.next = newNode;

                // If newNode is inserted just before the last node
                if (current == last) {
                    last = newNode;
                }
            } else {
                System.out.println("Position out of bounds. Inserting at the end.");
                newNode.next = last.next;
                last.next = newNode;
                last = newNode;
            }
        }
    }

    // Insert a new node at the end
    public void insertAtEnd(int data) {
        Node newNode = new Node(data);
        if (last == null) {
            last = newNode;
            last.next = last;
        } else {
            newNode.next = last.next;
            last.next = newNode;
            last = newNode;
        }
    }

    // Delete a node with the specified value
    public void delete(int data) {
        if (last == null) {
            System.out.println("List is empty.");
            return;
        }

        Node current = last.next;
        Node previous = last;
        do {
            if (current.data == data) {
                if (current == last && current.next == last) {
                    last = null;
                } else {
                    if (current == last) {
                        last = previous;
                    }
                    previous.next = current.next;
                }
                return;
            }
            previous = current;
            current = current.next;
        } while (current != last.next);

        System.out.println("Element not found.");
    }

    // Print the Circular Linked List
    public void printList() {
        if (last == null) {
            System.out.println("List is empty.");
            return;
        }

        Node current = last.next;
        do {
            System.out.print(current.data + " ");
            current = current.next;
        } while (current != last.next);
        System.out.println();
    }

    public static void main(String[] args) {
        CircularLinkedList cll = new CircularLinkedList();
        cll.insertAtEnd(10);
        cll.insertAtEnd(20);
        cll.insertAtEnd(30);
        cll.printList(); // Output: 10 20 30

        cll.insertAtBeginning(5);
        cll.printList(); // Output: 5 10 20 30

        cll.delete(20);
        cll.printList(); // Output: 5 10 30

        cll.delete(5);
        cll.printList(); // Output: 10 30
        cll.insertAtPosition(40, 3);
        cll.printList();
    }
}
