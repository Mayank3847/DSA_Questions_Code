public class BST_Brothers_from_different_roots {
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

    public int traverse(Node root, int k) {
        if (root == null) {
            return 0;
        }
        if (root.data == k) {
            return 1;
        } else if (root.data > k) {
            return traverse(root.leftSubtree, k);
        } else {
            return traverse(root.rightSubtree, k);
        }
    }

    public int countPair(Node root1, Node root2, int k) {
        if (root1 == null) {
            return 0;
        }
        int pairs = traverse(root2, k - root1.data);
        pairs += countPair(root1.leftSubtree, root2, k);
        pairs += countPair(root1.rightSubtree, root2, k);
        // int ans=traverse(root2, k-root1.data)+countPair(root1.leftSubtree, root2,
        // k)+countPair(root1.rightSubtree, root2, k);
        // return ans;
        return pairs;
    }

    // public Node insert(Node root, int key) {
    //     if (root == null) {
    //         return new Node(key);
    //     }
    //     if (key < root.data) {
    //         root.leftSubtree = insert(root.leftSubtree, key);
    //     } else if (key > root.data) {
    //         root.rightSubtree = insert(root.rightSubtree, key);
    //     }
    //     return root;
    // }

    public static void main(String[] args) {
        BST_Brothers_from_different_roots bst = new BST_Brothers_from_different_roots();

        // Node root1 = null;
        // root1 = bst.insert(root1, 5);
        // root1 = bst.insert(root1, 3);
        // root1 = bst.insert(root1, 7);
        // root1 = bst.insert(root1, 2);
        // root1 = bst.insert(root1, 4);
        // root1 = bst.insert(root1, 6);
        // root1 = bst.insert(root1, 8);

        // Node root2 = null;
        // root2 = bst.insert(root2, 10);
        // root2 = bst.insert(root2, 6);
        // root2 = bst.insert(root2, 15);
        // root2 = bst.insert(root2, 3);
        // root2 = bst.insert(root2, 8);
        // root2 = bst.insert(root2, 11);
        // root2 = bst.insert(root2, 18);
        Node root1=new Node(5);
        root1.leftSubtree=new Node(3);
        root1.rightSubtree=new Node(7);
        root1.leftSubtree.leftSubtree=new Node(2);
        root1.leftSubtree.rightSubtree=new Node(4);
        root1.rightSubtree.leftSubtree=new Node(6);
        root1.rightSubtree.rightSubtree=new Node(8);

        Node root2=new Node(10);
        root2.leftSubtree=new Node(6);
        root2.rightSubtree=new Node(15);
        root2.leftSubtree.leftSubtree=new Node(3);
        root2.leftSubtree.rightSubtree=new Node(8);
        root2.rightSubtree.leftSubtree=new Node(11);
        root2.rightSubtree.rightSubtree=new Node(18);



        int k = 16; 
        int result = bst.countPair(root1, root2, k);
        System.out.println("The number of pairs with sum " + k + " is: " + result);
    }

}
