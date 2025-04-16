public class BST_PrintInRange {
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
    public static Node insert(Node root, int val) {
        if (root == null) {
            root = new Node(val);
            return root;

        }
        if (root.data > val) {
            root.leftSubtree = insert(root.leftSubtree, val);
        } else {
            root.rightSubtree = insert(root.rightSubtree, val);
        }
        return root;
    }

    public static void Inorder(Node root) {

        if (root == null) {
            return;
        }
        Inorder(root.leftSubtree);
        System.out.print(root.data + " ");
        Inorder(root.rightSubtree);
    }
public static void printInRange(Node root,int k1,int k2){
    if(root==null){
        return ;
    }
    if(root.data<=k2&&root.data>=k1){
        printInRange(root.leftSubtree, k1, k2);
        System.out.print(root.data+" ");
        printInRange(root.rightSubtree, k1, k2);
    }
    else if(root.data>k2){
        printInRange(root.leftSubtree, k1, k2);
    }
    else{
        printInRange(root.rightSubtree, k1, k2);
    }
    }
    public static void main(String[] args) {
        int value[] = { 8,5,3,1,4,6,10,11,14 };
        Node root = null;
        for (int i = 0; i < value.length; i++) {
            root = insert(root, value[i]);
        }
        Inorder(root);
    System.out.println();
    printInRange(root, 5, 12);
    
}
}
