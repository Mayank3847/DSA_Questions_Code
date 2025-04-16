public class Binary_tree_Transform_To_SumTree {
    static class Node {
        int data;
        Node leftSubtree;
        Node rightSubtree;

        public Node(int data) {
            this.data = data;
            this.leftSubtree = null;
            this.rightSubtree = null;
        }
    }

    public static int transform(Node root) {
        if (root == null) {
            return 0;

        }
        int leftChild = transform(root.leftSubtree);
        int rightChild = transform(root.rightSubtree);
        int data = root.data;
        int newLeft = root.leftSubtree == null ? 0 : root.leftSubtree.data;
        // //if(newLeft==0){
        // return 0;}
        // else{
        // return root.leftSubtree.data;
        // }
        int newRight = root.rightSubtree == null ? 0 : root.rightSubtree.data;
        root.data = newLeft + leftChild + newRight + rightChild;
        return data;

    }

    public static void preOrder(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");
        preOrder(root.leftSubtree);
        preOrder(root.rightSubtree);

    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.leftSubtree = new Node(2);
        root.rightSubtree = new Node(3);
        root.leftSubtree.leftSubtree = new Node(4);
        root.leftSubtree.rightSubtree = new Node(5);
        root.rightSubtree.leftSubtree = new Node(6);
        root.rightSubtree.rightSubtree = new Node(7);

        transform(root);
        preOrder(root);

    }

}
