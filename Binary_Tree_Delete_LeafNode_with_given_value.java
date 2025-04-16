public class Binary_Tree_Delete_LeafNode_with_given_value {
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

    public static Node deleteLeaf(Node root, int target) {
        if (root == null) {
            return null;
        }
        root.leftSubtree = deleteLeaf(root.leftSubtree, target);
        root.rightSubtree = deleteLeaf(root.rightSubtree, target);
        if (root.data == target && root.leftSubtree == null && root.rightSubtree == null) {
            return null;
        }
        return root;

    }

    public static void inOrder(Node root) {
        if (root == null) {
            System.out.print("NULL ");

            return;
        }
        inOrder(root.leftSubtree);
        System.out.print(root.data+" ");
        inOrder(root.rightSubtree);
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.leftSubtree = new Node(2);
        root.rightSubtree = new Node(3);
        root.leftSubtree.leftSubtree = new Node(2);
        root.rightSubtree.leftSubtree = new Node(2);
        root.rightSubtree.rightSubtree = new Node(4);
        deleteLeaf(root, 2);
        System.out.println("AFTER DELETION : ");
        inOrder(root);

    }
}
