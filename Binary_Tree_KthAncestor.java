public class Binary_Tree_KthAncestor {
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

    public static int kthAncestor(Node root, int node, int k) {
        if(root==null){
            return -1;
        }
        if (root.data == node) {
            return 0;
        }
        int leftDist=kthAncestor(root.leftSubtree, node, k);
        int rightDist=kthAncestor(root.rightSubtree, node, k);
        if(leftDist==-1&&rightDist==-1){
            return-1;
            
        }
        int max=Math.max(leftDist, rightDist);
        if(max+1==k){
            System.out.println(root.data);
        }
        return max+1;
        
    }
    public static void main(String[] args) {
        int node=3;
        int k=1;
        Node root=new Node(1);
        root.leftSubtree=new Node(2);
        root.rightSubtree=new Node(3);
        root.leftSubtree.leftSubtree=new Node(4);
        root.leftSubtree.rightSubtree=new Node(5);
        root.rightSubtree.leftSubtree=new Node(6);
        root.rightSubtree.rightSubtree=new Node(7);
        kthAncestor(root, node, k);


    }
    

}
