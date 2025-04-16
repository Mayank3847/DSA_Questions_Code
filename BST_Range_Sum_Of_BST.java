public class BST_Range_Sum_Of_BST {
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
    public static int rangeInBST(Node root,int low,int high){
        if(root==null){
            return 0;
        }
        if(root.data>=low&&root.data<=high){
            return root.data+rangeInBST(root.leftSubtree, low, high)+rangeInBST(root.rightSubtree, low, high);
        }
        if(root.data<low){
            return rangeInBST(root.rightSubtree, low, high);
        }
        return rangeInBST(root.leftSubtree, low, high);
    }
    public static void main(String[] args) {
        Node root= new Node(10);
        root.leftSubtree=new Node(5);
        root.rightSubtree=new Node(15);
        root.leftSubtree.leftSubtree=new Node(3);
        root.leftSubtree.rightSubtree=new Node(7);

        root.rightSubtree.rightSubtree=new Node(18);
           int low = 7, high = 15;
           System.out.println("Range sum: " + rangeInBST(root, low, high));

    }
    
}
