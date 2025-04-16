
import java.util.*;

 class Node {
    int data;
    Node leftSubtree;
    Node rightSubtree;

    public Node(int data) { 
        this.data = data;
        this.leftSubtree = null;
        this.rightSubtree = null;
    }
}

public class Binary_Tree_AllDuplicates {
    Map<String,Integer>map;
    List<Node>result;
    public List<Node> findDuplicates(Node root){
        map=new HashMap<>();
        result=new ArrayList<>();
        traverse(root);
        return result;


    }
    public  String traverse(Node node){
        if(node==null){
            return "NULL";

        }
        String subpath=node.data+","+traverse(node.leftSubtree)+","+traverse(node.rightSubtree);
        System.out.println("SUBPATH : "+subpath);
        map.put(subpath, map.getOrDefault(subpath, 0)+1);
        if(map.get(subpath)==2){
            result.add(node);

        }
        return subpath;
    }
     public void printDuplicateSubtrees(List<Node> duplicates) {
        for (Node node : duplicates) {
            System.out.println("Duplicate subtree root: " + node.data);
        }
    }
    public static void main(String[] args) {
        Node root=new Node(1);
        root.leftSubtree = new Node(2);
        root.rightSubtree = new Node(3);
        root.leftSubtree.leftSubtree = new Node(4);
        root.rightSubtree.leftSubtree = new Node(2);
        root.rightSubtree.rightSubtree = new Node(4);
        root.rightSubtree.leftSubtree.leftSubtree = new Node(4);
        Binary_Tree_AllDuplicates solution=new Binary_Tree_AllDuplicates();
        List<Node >duplicates=solution.findDuplicates(root);
        solution.printDuplicateSubtrees(duplicates);



    }
    
}
