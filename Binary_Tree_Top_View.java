import java.util.Queue;
import java.util.HashMap;
import java.util.LinkedList;

public class Binary_Tree_Top_View {
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
    Node node;
    int horizontalDist;
     public Info(Node node,int horizontalDist){
        this.node=node;
        this.horizontalDist=horizontalDist;
     }
    }
     public static void topView(Node root){

         //level order
         Queue<Info> qu= new LinkedList<>();
         HashMap<Integer,Node> map=new HashMap<>();
         int min=0;
         int max=0;
         qu.add((new Info(root, 0)));
         qu.add(null);
         while(!qu.isEmpty()){

            Info curr=qu.remove();
            if(curr==null){
                if(qu.isEmpty()){
                    break;
                }else{
                    qu.add(null);
                }
            }
                else{
                    if(!map.containsKey(curr.horizontalDist)){
                        map.put(curr.horizontalDist,curr.node);
                    }
                    if(curr.node.leftSubtree!=null){
                        qu.add(new Info(curr.node.leftSubtree,curr.horizontalDist-1));
                        min=Math.min(min,curr.horizontalDist-1);

                    } 
                    if(curr.node.rightSubtree!=null){
                        qu.add(new Info(curr.node.rightSubtree,curr.horizontalDist+1));
                        max=Math.max(max,curr.horizontalDist+1);

                    }

                }
            }
                for(int i=min;i<=max;i++){
                    System.out.print (map.get(i).data+" ");
                }
                System.out.println();
            
         }
         public static void main(String[] args) {
            Node root = new Node(1);
            root.leftSubtree = new Node(2);
            root.rightSubtree = new Node(3);
            root.leftSubtree.rightSubtree=new Node(4);
            root.leftSubtree.rightSubtree.rightSubtree=new Node(5);
            root.leftSubtree.rightSubtree.rightSubtree.rightSubtree=new Node(6);
            topView(root);

            


            
         }
        }
     
