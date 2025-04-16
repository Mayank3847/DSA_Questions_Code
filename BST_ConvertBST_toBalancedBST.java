import java.util.*;
public class BST_ConvertBST_toBalancedBST {
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
    
        public static void Preorder(Node root) {
            if (root == null) {
                return;
            }
            System.out.print(root.data + " ");
            Preorder(root.leftSubtree);
            Preorder(root.rightSubtree);
    
        }
        public static void getInOrder(Node root,ArrayList<Integer>inorder){
            if(root==null){
                return;
            }
            getInOrder(root.leftSubtree, inorder);
            inorder.add(root.data);
            getInOrder(root.rightSubtree, inorder);

        }
     public static Node createBST(ArrayList<Integer>inorder,int start,int end){
        if(start>end){
            return  null;

        }
        int mid=(start+end)/2;
        Node root=new Node(inorder.get(mid));
        root.leftSubtree=createBST(inorder, start, mid-1);
        root.rightSubtree=createBST(inorder, mid+1, end);
        return root;
     }
     public static Node balancedBST(Node root){
        ArrayList<Integer>inorder=new ArrayList<>();
        getInOrder(root, inorder);
        root=createBST(inorder, 0, inorder.size()-1);
        return  root;
     }
     public static void main(String[] args) {
        Node root=new Node(8);
        root.leftSubtree=new Node(6);
        root.rightSubtree=new Node(10);
        root.leftSubtree.leftSubtree=new Node(5);
        root.leftSubtree.leftSubtree.leftSubtree=new Node(3);
        root.rightSubtree.rightSubtree=new Node(11);
        root.rightSubtree.rightSubtree.rightSubtree=new Node(12);
        balancedBST(root);
        Preorder(root);



       
     }
    
    
}
