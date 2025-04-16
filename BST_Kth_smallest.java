public class BST_Kth_smallest {
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
    int i=0;
    int ans=0;
    public  int kthSmallest(Node root,int k){
        int ans=solve(root,k);
        return ans;
    } 
    public int solve(Node root,int k){
        if(root==null){
            return -1;
        }
        int left=solve(root.leftSubtree, k);
        if(left!=-1){
            return left;
        }
        i++;
        if(i==k){
            return root.data;

        }
return solve(root.rightSubtree, k);
    }
    public static void main(String[] args) {
        BST_Kth_smallest bst = new BST_Kth_smallest();
        Node root = new Node(5);
        root.leftSubtree = new Node(3);
        root.rightSubtree = new Node(7);
        root.leftSubtree.leftSubtree = new Node(2);
        root.leftSubtree.rightSubtree = new Node(4);
        root.rightSubtree.leftSubtree = new Node(6);
        root.rightSubtree.rightSubtree = new Node(8);

        int k = 3;
        int result = bst.kthSmallest(root, k);
        System.out.println("The " + k + "-th smallest element in the BST is: " + result);
    }
    
}
