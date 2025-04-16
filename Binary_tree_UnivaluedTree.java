
public class Binary_tree_UnivaluedTree {
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

    public static boolean isUnivalTree(Node root) {
        if (root == null) {
            return true;
        }
        if (root.leftSubtree != null && root.data != root.leftSubtree.data) {
            return false;

        }
        if (root.rightSubtree != null && root.data != root.rightSubtree.data) {
            return false;

        }
        return isUnivalTree(root.leftSubtree) && isUnivalTree(root.rightSubtree);

    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.leftSubtree = new Node(1);
        root.rightSubtree = new Node(1);
        root.leftSubtree.leftSubtree = new Node(1);
        root.leftSubtree.rightSubtree = new Node(1);
        root.rightSubtree.leftSubtree = new Node(1);
        root.rightSubtree.rightSubtree = new Node(2);
        if (isUnivalTree(root)) {
            System.out.println("YES");
        }
       else{

       System.out.println("No");
       }
    }

}
