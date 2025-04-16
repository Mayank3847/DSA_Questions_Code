public class Binary_Tree_height_and_NodeCount_And_Nodes_Sum_childrenProperty {
    static class Node {
        int data;
        Node left_subtree, right_subtree;

        public Node(int data) {
            this.data = data;
            this.left_subtree = null;
            this.right_subtree = null;
        }
    }

    public static int height(Node root) {
        if (root == null) {
            return 0;
        }
        int left_Height = height(root.left_subtree);
        int right_Height = height(root.right_subtree);
        return Math.max(left_Height, right_Height) + 1;
    }

    public static int count(Node root) {
        if (root == null) {
            return 0;
        }
        int left_count = count(root.left_subtree);
        int right_count = count(root.right_subtree);
        return left_count + right_count + 1;

    }

    public static int sumOfNodes(Node root) {
        if (root == null) {
            return 0;
        }
        int leftSum = sumOfNodes(root.left_subtree);
        int rightSum = sumOfNodes(root.right_subtree);
        int treeSum = leftSum + rightSum + root.data;
        return treeSum;
    }

    public static void nodeKthLevel(Node root, int k) {
        if (root == null) {
            return;
        }
        if (k == 0) {
            System.out.print(root.data + " ");
            return;
        }
        nodeKthLevel(root.left_subtree, k - 1);
        nodeKthLevel(root.right_subtree, k - 1);
    }
//children property 
    public static boolean isSum(Node root) {
        if (root == null) {
            return true;
        }
        if (root.left_subtree == null && root.right_subtree == null) {
            return true;
        }
        int sum = 0;
        if (root.left_subtree != null) {
            sum += root.left_subtree.data;
        }
        if (root.right_subtree != null) {
            sum += root.right_subtree.data;
        }
        if (root.data == sum && isSum(root.left_subtree) && isSum(root.right_subtree)) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        /*
         * 
         * 
         * 1
         * / \
         * 2 3
         * / \ / \
         * 4 5 6 7
         */
        Node root = new Node(20);
        root.left_subtree = new Node(8);
        root.right_subtree = new Node(12);
        root.left_subtree.left_subtree = new Node(3);
        root.left_subtree.right_subtree = new Node(5);
        root.right_subtree.left_subtree = new Node(6);
        root.right_subtree.right_subtree = new Node(6);
        System.out.println("THE HEIGHT OF THE TREE : " + height(root));
        System.out.println("THE TOTAL NUMBER OF NODE : " + count(root));
        System.out.println("THE SUM OF ALL NODES : " + sumOfNodes(root));
        int k = 2; // Level to print

        System.out.println("Nodes at level " + k + ":");
        nodeKthLevel(root, k);
        if (isSum(root)) {
            System.out.println("YES ");
        } else {
            System.out.println("NO!");
        }
    }

}
