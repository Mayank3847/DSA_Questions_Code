public class BST_Find_The_Closest_Element {
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
     static int mindiff(Node root,int k ){
        return helper(root,k);
    }
     static int helper(Node root,int k ){
        if(root==null){
            return Integer.MAX_VALUE;
        }
        if(root.data==k){
            return 0;
        }
        if(root.data>k){
            return Math.min(root.data-k,helper(root.leftSubtree, k));
        }
        return Math.min(k-root.data,helper(root.rightSubtree, k));


    }
    public static void main(String[] args) {
        Node root = new Node(10);
        root.leftSubtree = new Node(5);
        root.rightSubtree = new Node(15);
        root.leftSubtree.leftSubtree = new Node(2);
        root.leftSubtree.rightSubtree = new Node(7);
        root.rightSubtree.rightSubtree = new Node(18);
        int k=12;
        System.out.println("CLOSEST ELEMENT DIFFERENCE : "+mindiff(root, k));
    }
    
}
