public class Binary_Tree_SubtreeOfAnotherTree {
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

    public static boolean isIdentical(Node node, Node subRoot) {
        if (node == null && subRoot == null) {
            return true;
        } else if (node == null || subRoot == null || node.data != subRoot.data) {
            return false;

        }

        if (!isIdentical(node.leftSubtree, subRoot.leftSubtree)) {
            return false;
        }
        if (!isIdentical(node.rightSubtree, subRoot.rightSubtree)) {
            return false;
        }
        return true;
    }

    public static boolean isSubtree(Node root, Node subRoot) {
        if (root == null) {
            return false;
        }
        if (root.data == subRoot.data) {
            if (isIdentical(root, subRoot)) {
                return true;
            }
        }
        return isSubtree(root.leftSubtree, subRoot) || isSubtree(root.rightSubtree, subRoot);
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.leftSubtree = new Node(2);
        root.rightSubtree = new Node(3);
        root.leftSubtree.leftSubtree = new Node(4);

        root.leftSubtree.rightSubtree = new Node(5);
        root.rightSubtree.leftSubtree = new Node(6);
        root.rightSubtree.rightSubtree = new Node(7);

        Node subRoot = new Node(2);
        subRoot.leftSubtree = new Node(4);
        subRoot.rightSubtree = new Node(5);
        System.out.println(isSubtree(root, subRoot));
    }

}
