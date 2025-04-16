public class BST_MaximumSumBst {
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

    class NodeInfo {
        boolean isBST;
        int sum;
        int min;
        int max;

        public NodeInfo(boolean isBST, int sum, int min, int max) {
            this.isBST = isBST;
            this.sum = sum;
            this.min = min;
            this.max = max;
        }
    }

    private int maxSum = 0;

    public int maxSumBST(Node root) {
        Postorder(root);
        return maxSum;
    }

    private NodeInfo Postorder(Node node) {
        if (node == null) {
            return new NodeInfo(true, 0, Integer.MAX_VALUE, Integer.MIN_VALUE);
        }
        NodeInfo left = Postorder(node.leftSubtree);
        NodeInfo right = Postorder(node.rightSubtree);
        if (left.isBST && right.isBST && node.data > left.max && node.data < right.min) {
            int sum = node.data + left.sum + right.sum;
            maxSum = Math.max(maxSum, sum);
            return new NodeInfo(true, sum, Math.min(node.data, left.min), Math.max(node.data, right.max));

        } else {
            return new NodeInfo(false, 0, 0, 0);
        }

    }

    public static void main(String[] args) {
        BST_MaximumSumBst bst = new BST_MaximumSumBst();
        Node root = new Node(1);
        root.leftSubtree = new Node(4);
        root.rightSubtree = new Node(3);
        root.leftSubtree.leftSubtree = new Node(2);
        root.leftSubtree.rightSubtree = new Node(4);
        root.rightSubtree.leftSubtree = new Node(2);
        root.rightSubtree.rightSubtree = new Node(5);
        root.rightSubtree.rightSubtree.leftSubtree = new Node(4);
        root.rightSubtree.rightSubtree.rightSubtree = new Node(6);

        System.out.println("Maximum Sum BST in Binary Tree : " + bst.maxSumBST(root));

    }
}
