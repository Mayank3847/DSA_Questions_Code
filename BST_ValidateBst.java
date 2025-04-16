public class BST_ValidateBst {
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
    public static boolean Isvalid(Node root,Node min,Node max){
        if(root==null){
            return true ;
        }
        if(min!=null&&root.data<=min.data){
            return false;
        }
        else if(max!=null&&root.data>=max.data){
            return false;
        }
        return Isvalid(root.leftSubtree, min, root)&&Isvalid(root.rightSubtree, root, max);
    }
public static void main(String[] args) {
    int value[] = { 8,5,3,1,4,6,10,11,14 };
        Node root = null;
        for (int i = 0; i < value.length; i++) {
            root = insert(root, value[i]);
        }
        Inorder(root);
    System.out.println();
    if(Isvalid(root, null, null)){
        System.out.println("Valid");
    }
    else{
        System.out.println("Not Valid!");
    }
}
    
}
