public class BST_Build_Tree {
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
    public static Node insert(Node root,int val){
        if(root==null){
            root= new Node(val);
            return root;

        }
        if(root.data>val){
            root.leftSubtree=insert(root.leftSubtree, val);
        }else{
            root.rightSubtree=insert(root.rightSubtree, val);
        }
        return root;
    }
    public static void Inorder(Node root){

        if(root==null){
            return;
        }
        Inorder(root.leftSubtree);
        System.out.print(root.data+" ");
        Inorder(root.rightSubtree);
    }
    public static void main(String[] args) {
        int value[]={5,1,3,4,2,7};
        Node root=null;
        for(int i =0;i<value.length;i++){
            root=insert(root, value[i]);
        }
        Inorder(root);
        System.out.println();
    }

    
}
