import java.util.*;
import java.util.Queue;
import java.util.LinkedList;
public class Graph_DetectCycle_Undirected_Bfs {
    static class Pair{
        int first;
        int second;
        Pair(int first,int second){
            this.first=first;
            this.second=second;
        }
    }
    public static boolean checkForCycle(int src,int V,ArrayList<ArrayList<Integer>> edge,boolean []isVisit){
        isVisit[src]=true;
        Queue<Pair>q=new LinkedList<>();
        q.add(new Pair(src, -1));
        while (!q.isEmpty()) {
            
            int node =q.peek().first;
            int parent=q.peek().second;
            q.remove();
            for(int i =0;i<edge.get(node).size();i++){
                
                int adjNode=edge.get(node).get(i);
                if(!isVisit[adjNode]){
                    isVisit[adjNode]=true;
                    q.add(new Pair( adjNode,node));
                    
                    
                }
                else if(parent!=adjNode){
                    return true;
                }
            }
        }
        return false;
    }
    public boolean isCycle(int V,ArrayList<ArrayList<Integer>>adj){
        boolean isVisit[]=new boolean[V];
        for(int i =0;i<V;i++){
            if(!isVisit[i]){
                if(checkForCycle(i, V, adj, isVisit)){

                    return true;
                }
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int V = 5;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Add edges to the graph
        adj.get(0).add(1);
        adj.get(1).add(0);
        adj.get(1).add(2);
        adj.get(2).add(1);
        adj.get(2).add(3);
        adj.get(3).add(2);
        adj.get(3).add(4);
        adj.get(4).add(3);
        adj.get(4).add(1);
        adj.get(1).add(4);

        Graph_DetectCycle_Undirected_Bfs graph = new Graph_DetectCycle_Undirected_Bfs();
        if (graph.isCycle(V, adj)) {
            System.out.println("Cycle detected");
        } else {
            System.out.println("No cycle detected");
        }
    }
    
}
