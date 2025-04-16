public class Binary_tree_kth_level {
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

    public static void kthLevel(Node root, int level, int k) {
        if (root == null) {
            return;
        }
        if (level == k) {
            System.out.print(root.data + " ");
            return;
        }
        kthLevel(root.leftSubtree, level + 1, k);
        kthLevel(root.rightSubtree, level + 1, k);
    }
    public static void main(String[] args) {
        Node root = new Node(1);
        int k =3;
            root.leftSubtree = new Node(2);
            root.rightSubtree = new Node(3);
            root.leftSubtree.leftSubtree=new Node(4);
            root.leftSubtree.rightSubtree=new Node(5);
            root.rightSubtree.leftSubtree=new Node(6);
            root.rightSubtree.rightSubtree=new Node(7);
            kthLevel(root, 1, k);



    }
}
