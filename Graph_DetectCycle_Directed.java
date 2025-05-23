import java.util.*;
public class Graph_DetectCycle_Directed {

        static class Edge {
            int src;
            int dest;
            //int weight;
    
            public Edge(int s, int d) {
                this.src = s;
                this.dest = d;
                //this.weight = wt;
            }
    
        }
        public static void createGraph(ArrayList<Edge> graph[]) {
            for (int i = 0; i < graph.length; i++) {
                graph[i] = new ArrayList<>();
    
            }
    
    
            // // -------0
            // graph[0].add(new Edge(0, 2));
           
    
    
    
            // // --------1
            // graph[1].add(new Edge(1, 0));
    
    
            // // -------2
            // //graph[2].add(new Edge(2, 0));
            // graph[2].add(new Edge(2, 3));
    
    
            // // -------3
            // graph[3].add(new Edge(3, 0));
            graph[0].add(new Edge(0, 1));
            graph[0].add(new Edge(0, 2));

            graph[1].add(new Edge(1, 3));
            graph[2].add(new Edge(2, 1));

    
    
          
           
    
        }
    public static boolean isCycle(ArrayList<Edge>graph[]){
        boolean []isVisit=new boolean[graph.length];
        boolean []stack=new boolean[graph.length ];
        for(int i =0;i<graph.length;i++){
            if(!isVisit[i]){
                if(isCycleUtil(graph,i,isVisit,stack)){
                    return true;
                }
            }
        }
        return false;
    }
    public static boolean isCycleUtil(ArrayList<Edge>graph[],int curr,boolean isVisit[],boolean stack[]){
        isVisit[curr]=true;
        stack[curr]=true;
        for(int i =0;i<graph[curr].size();i++){
            Edge e=graph[curr].get(i);
            if(stack[e.dest]){
                return true;

            }
            if(!isVisit[e.dest]&&isCycleUtil(graph, e.dest, isVisit, stack)){
                return true;
            }
        }
        stack[curr]=false;
        return false;
    }
    public static void main(String[] args) {
        int v=4;
        @SuppressWarnings("unchecked")

        ArrayList<Edge>graph[]=new ArrayList[v];
        createGraph(graph);
        System.out.println(isCycle(graph));

        
    }
    
}
