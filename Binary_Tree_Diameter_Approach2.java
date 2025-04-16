public class Binary_Tree_Diameter_Approach2 {
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
static class Info{
    int diameter1;
    int height;
    public Info(int diameter1,int height){
        this.diameter1=diameter1;
        this.height=height;
        

    }
}
public static Info diameter(Node root){
    if(root==null){
        return new Info(0, 0);
       }
       Info leftInfo=diameter(root.leftSubtree);
       Info rigthInfo=diameter(root.rightSubtree);
       int diameter1=Math.max(Math.max(leftInfo.diameter1, rigthInfo.diameter1),leftInfo.height+rigthInfo.height+1);
int height=Math.max(leftInfo.height,rigthInfo.height)+1;
return new Info(diameter1,height);
}
public static void main(String[] args) {
    Node root = new Node(1);
    root.leftSubtree = new Node(2);
    root.rightSubtree = new Node(3);
    root.leftSubtree.leftSubtree = new Node(4);

    root.leftSubtree.rightSubtree = new Node(5);
    root.rightSubtree.leftSubtree = new Node(6);
    root.rightSubtree.rightSubtree = new Node(4);
    Info result = diameter(root);
    System.out.println("THE DIAMETER OF A BINARY TREE : " + result.diameter1);

}

}
