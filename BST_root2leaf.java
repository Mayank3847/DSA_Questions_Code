import java.util.*;
public class BST_root2leaf {
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
    public static void printPath(ArrayList<Integer>path){
        for(int i =0;i<path.size();i++){
            System.out.print(path.get(i)+" ");
        }
        System.out.println("NULL");

    }
    public static void root2leaf(Node root,ArrayList<Integer>path){
        if(root==null){
            return ;
        }
        path.add(root.data);
        if(root.leftSubtree==null&&root.rightSubtree==null){
            printPath(path);
        }
        root2leaf(root.leftSubtree,path);
        root2leaf(root.rightSubtree,path);
            path.remove(path.size()-1);

        
    }
    public static void main(String[] args) {
        int value[] = { 8,5,3,1,4,6,10,11,14 };
        Node root = null;
        for (int i = 0; i < value.length; i++) {
            root = insert(root, value[i]);
        }
        Inorder(root);
    System.out.println();
    root2leaf(root, new ArrayList<>());
    }
    
}
