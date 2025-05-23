import java.util.ArrayList;

public class Graph_HasPAth {
    static class Edge {
        int src;
        int dest;
        int weight;

        public Edge(int s, int d, int wt) {
            this.src = s;
            this.dest = d;
            this.weight = wt;
        }

    }
    public static void createGraph(ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();

        }


        // -------0
        graph[0].add(new Edge(0, 1, 1));
        graph[0].add(new Edge(0, 2, 1));


        // --------1
        graph[1].add(new Edge(1, 3, 1));
        graph[1].add(new Edge(1, 0, 1));


        // -------2
        graph[2].add(new Edge(2, 0, 1));
        graph[2].add(new Edge(2, 4, 1));


        // -------3
        graph[3].add(new Edge(3, 1, 1));
        graph[3].add(new Edge(3, 4, 1));
        graph[3].add(new Edge(3, 5, 1));


        // -------4
        graph[4].add(new Edge(4, 2, 1));
        graph[4].add(new Edge(4, 3, 1));
        graph[4].add(new Edge(4, 5, 1));


        // ---------5
        graph[5].add(new Edge(5, 3, 1));
        graph[5].add(new Edge(5, 4, 1));
        graph[5].add(new Edge(5, 6, 1));


        // -------6
        graph[6].add(new Edge(6, 5, 1));
    }
public static boolean hasPAth(ArrayList<Edge>[]graph,int src,int dest,boolean isVisited[]){
    if(src==dest){
        return true ;

    }
    isVisited[src]=true;
    for(int i =0;i<graph[src].size();i++){
        Edge e=graph[src].get(i);
        if(!isVisited[e.dest]&&hasPAth(graph, e.dest, dest, isVisited)){
            return true ;

        }
     
        
    } 
    return false;   
}
public static void main(String[] args) {
    int v=7;
    @SuppressWarnings("unchecked")

   
    ArrayList<Edge>graph[]=new ArrayList[v];
    createGraph(graph);
    boolean result=hasPAth(graph, 0, 6, new boolean[v]);
    System.out.println(result);
}


}   
