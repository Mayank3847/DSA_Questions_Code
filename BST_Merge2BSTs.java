import java.util.*;

public class BST_Merge2BSTs {
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

    public static void getInOrder(Node root, ArrayList<Integer> inorder) {
        if (root == null) {
            return;
        }
        getInOrder(root.leftSubtree, inorder);
        inorder.add(root.data);
        getInOrder(root.rightSubtree, inorder);

    }

    public static Node createBST(ArrayList<Integer> inorder, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = (start + end) / 2;
        Node root = new Node(inorder.get(mid));
        root.leftSubtree = createBST(inorder, start, mid - 1);
        root.rightSubtree = createBST(inorder, mid + 1, end);
        return root;

    }

    public static void Preorder(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");
        Preorder(root.leftSubtree);
        Preorder(root.rightSubtree);
    }

    // merge bst
    public static Node mergeBST(Node root1, Node root2) {
        //
        ArrayList<Integer> arr1 = new ArrayList<>();
        getInOrder(root1, arr1);
        ArrayList<Integer> arr2 = new ArrayList<>();
        getInOrder(root2, arr2);
        ArrayList<Integer> finalarr = new ArrayList<>();
        int i = 0;
        int j = 0;
        while (i < arr1.size() && j < arr2.size()) {
            if (arr1.get(i) < arr2.get(j)) {
                finalarr.add(arr1.get(i));
                i++;

            } else {
                finalarr.add(arr2.get(j));
                j++;
            }
        }
        while (i < arr1.size()) {
            finalarr.add(arr1.get(i));
            i++;
        }
        while (j < arr2.size()) {
            finalarr.add(arr2.get(j));
            j++;
        }
        return createBST(finalarr, 0, finalarr.size()-1);
    }

    public static void main(String[] args) {
        Node root1 = new Node(2);
        root1.rightSubtree = new Node(4);
        root1.leftSubtree = new Node(1);
        Node root2 = new Node(9);
        root2.rightSubtree = new Node(12);
        root2.leftSubtree = new Node(3);
        Node root = mergeBST(root1, root2);
        Preorder(root);
    }

}
