public class Binary_tree_LowestCommonAncestor {
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
        public static void main(String[] args) {
            Node root = new Node(1);
            int n1 =4,n2=5;
                root.leftSubtree = new Node(2);
                root.rightSubtree = new Node(3);
                root.leftSubtree.leftSubtree=new Node(4);
                root.leftSubtree.rightSubtree=new Node(5);
                root.rightSubtree.leftSubtree=new Node(6);
                root.rightSubtree.rightSubtree=new Node(7);
                System.out.println("LCA = " +lca(root, n1, n2).data);

    }
}

