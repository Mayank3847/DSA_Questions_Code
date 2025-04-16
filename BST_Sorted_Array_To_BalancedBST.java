public class BST_Sorted_Array_To_BalancedBST {
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

    public static void Preorder(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");
        Preorder(root.leftSubtree);
        Preorder(root.rightSubtree);

    }

    public static Node createBST(int arr[], int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = (start + end) / 2;
        Node root = new Node(arr[mid]);
        root.leftSubtree = createBST(arr, start, mid - 1);
        root.rightSubtree = createBST(arr, mid + 1, end);
        return root;
    }

    public static void main(String[] args) {
        int arr[] = { 3, 5, 6, 8, 10, 11, 12 };
        Node root = createBST(arr, 0, arr.length - 1);
        Preorder(root);
    }

}
