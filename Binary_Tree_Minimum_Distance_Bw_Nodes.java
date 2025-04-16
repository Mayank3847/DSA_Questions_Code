
public class Binary_Tree_Minimum_Distance_Bw_Nodes {
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
    public static Node lca(Node root,int n1,int n2){
        if(root==null){
            return null;
        }
        if(root.data==n1||root.data==n2){
            return root;
        }
        Node leftAns=lca(root.leftSubtree, n1, n2);
        Node rightAns=lca(root.rightSubtree, n1, n2);
        if(leftAns!=null&&rightAns!=null){
            return root;
        }
        else if(leftAns!=null&&rightAns==null){
            return leftAns;
        }else if(leftAns==null&&rightAns!=null){
            return rightAns;
        }else{
            return null;
        }

    }
    public static int lcaDistance(Node root,int n){
if(root==null){
    return -1;
}
if(root.data==n){
    return 0;

}
int leftDist=lcaDistance(root.leftSubtree, n);
int rightDist=lcaDistance(root.rightSubtree, n);
if(leftDist==-1&&rightDist==-1){
    return -1;
}else if(leftDist==-1){
    return rightDist+1;
}else{
    return leftDist+1;

}

    }
    public static int minDistance(Node root,int n1,int n2){
        // Node lca1=lca(root, n1, n2);
        int dist1=lcaDistance(root, n1);
        int dist2=lcaDistance(root, n2);
        return dist1+dist2;

    }
    public static void main(String[] args) {
        
    
    Node root = new Node(1);
    int n1 =4,n2=6;
        root.leftSubtree = new Node(2);
        root.rightSubtree = new Node(3);
        root.leftSubtree.leftSubtree=new Node(4);
        root.leftSubtree.rightSubtree=new Node(5);
        root.rightSubtree.leftSubtree=new Node(6);
        root.rightSubtree.rightSubtree=new Node(7); 
        System.out.println("THE MINIMUM DISTANCE BETWEEN NODES : "+minDistance(root, n1, n2));

    }
}
