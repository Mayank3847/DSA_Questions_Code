import java.util.*;

public class Graph_ArticulationPoint_Tarjan {
    static class Edge {
        int src;
        int dest;
        // int weight;

        public Edge(int s, int d) {
            this.src = s;
            this.dest = d;
            // this.weight = wt;
        }

    }

    public static void createGraph(ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();

        }
        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));
        graph[0].add(new Edge(0, 3));

        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 2));

        graph[2].add(new Edge(2, 1));
        graph[2].add(new Edge(2, 0));

        graph[3].add(new Edge(3, 0));
        graph[3].add(new Edge(3, 4));

        graph[4].add(new Edge(4, 3));

    }

    public static void dfs(ArrayList<Edge> graph[], int curr, int par, int dt[], int low[], int time, boolean isVisit[],
            boolean ap[]) {
        isVisit[curr] = true;
        dt[curr] = low[curr] = ++time;
        int children = 0;
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            int neigh = e.dest;

            if (par == neigh) {
                continue;
            } else if (isVisit[neigh]) {
                low[curr] = Math.min(low[curr], dt[neigh]);

            } else {
                dfs(graph, neigh, curr, dt, low, time, isVisit, ap);
                low[curr] = Math.min(low[curr], low[neigh]);
                if (par != -1 && dt[curr] <= low[neigh]) {
                    ap[curr] = true;
                }
                children++;
            }
        }
        if (par == -1 && children > 1) {
            ap[curr] = true;
        }
    }

    public static void getAP(ArrayList<Edge> graph[], int V) {
        int dt[] = new int[V];
        int low[] = new int[V];
        int time = 0;
        boolean isVisit[] = new boolean[V];
        boolean ap[] = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (!isVisit[i]) {
                dfs(graph, i, -1, dt, low, time, isVisit, ap);
            }
        }
        for (int i = 0; i < V; i++) {
            if (ap[i]) {
                System.out.println("AP : " + i);

            }
        }

    }
    public static void main(String[] args) {
        int V = 5;  // Number of vertices
        @SuppressWarnings("unchecked")

        ArrayList<Edge> graph[] = new ArrayList[V];
        
        // Create the graph
        createGraph(graph);
        
        // Find and print articulation points
        System.out.println("Articulation points in the graph are:");
        getAP(graph, V);
    }
    

}
