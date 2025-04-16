public class Binary_tree_MaximumPathSum {
    class Node {
        int data;
        Node leftSubtree;
        Node rightSubtree;

        public Node(int data) {
            this.data = data;
            this.leftSubtree = null;
            this.rightSubtree = null;
        }
    }

    public int maxPathSum(Node root) {
        int maxValue[] = new int[1];
        maxValue[0] = Integer.MIN_VALUE;
        maxPathDown(root, maxValue);
        return maxValue[0];

    }

    private int maxPathDown(Node node, int maxValue[]) {
        if (node == null) {
            return 0;
        }
        int left = Math.max(0, maxPathDown(node.leftSubtree, maxValue));
        int right = Math.max(0, maxPathDown(node.rightSubtree, maxValue));
        maxValue[0] = Math.max(maxValue[0], left + right + node.data);
        return Math.max(left, right) + node.data;

    }

    public static void main(String[] args) {
        Binary_tree_MaximumPathSum tree = new Binary_tree_MaximumPathSum();
        Node root = tree.new Node(10);
        root.leftSubtree = tree.new Node(2);
        root.rightSubtree = tree.new Node(10);
        root.leftSubtree.leftSubtree = tree.new Node(20);
        root.leftSubtree.rightSubtree = tree.new Node(1);
        root.rightSubtree.rightSubtree = tree.new Node(-25);
        root.rightSubtree.rightSubtree.leftSubtree = tree.new Node(3);
        root.rightSubtree.rightSubtree.rightSubtree = tree.new Node(4);

        // Print the maximum path sum
        System.out.println("Maximum Path Sum: " + tree.maxPathSum(root));

    }

}
