public class Binary_Tree_Diameter_Of_Tree {
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

    public static int height(Node root) {
        if (root == null) {
            return 0;
        }
        int left_Height = height(root.leftSubtree);
        int right_Height = height(root.rightSubtree);
        return Math.max(left_Height, right_Height) + 1;
    }

    public static int diameter(Node root) {
        if (root == null) {
            return 0;
        }
        int leftDiameter = diameter(root.leftSubtree);
        int left_Height = height(root.leftSubtree);
        int rightDiameter = diameter(root.leftSubtree);
        int right_Height = height(root.rightSubtree);
        int selfDiameter = left_Height + right_Height + 1;
        return Math.max(selfDiameter, Math.max(leftDiameter, rightDiameter));
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.leftSubtree = new Node(2);
        root.rightSubtree = new Node(3);
        root.leftSubtree.leftSubtree = new Node(4);

        root.leftSubtree.rightSubtree = new Node(5);
        root.rightSubtree.leftSubtree = new Node(6);
        root.rightSubtree.rightSubtree = new Node(4);
        System.out.println("THE DIAMETER OF A BINARY TREE : " + diameter(root));

    }
}
