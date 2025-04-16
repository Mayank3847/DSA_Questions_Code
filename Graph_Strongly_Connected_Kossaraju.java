import java.util.*;

public class Graph_Strongly_Connected_Kossaraju {
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
        graph[0].add(new Edge(0, 2));

        graph[2].add(new Edge(2, 1));
        graph[1].add(new Edge(1, 0));
        graph[0].add(new Edge(0, 3));

        graph[3].add(new Edge(3, 4));

    }

    public static void topSort(ArrayList<Edge> graph[], int curr, boolean isVisit[], Stack<Integer> s) {
        isVisit[curr] = true;
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (!isVisit[e.dest]) {
                topSort(graph, e.dest, isVisit, s);
            }
        }
        s.push(curr);
    }

    public static void dfs(ArrayList<Edge> graph[], int curr, boolean[] isVisit) {
        isVisit[curr] = true;
        System.out.print(curr + " ");
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (!isVisit[e.dest]) {
                dfs(graph, e.dest, isVisit);
            }
        }
    }

    public static void kossaRaju(ArrayList<Edge> graph[], int V) {
        // step1
        Stack<Integer> s = new Stack<>();
        boolean isVisit[] = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (!isVisit[i]) {
                topSort(graph, i, isVisit, s);
            }
        }

        // step 2
        @SuppressWarnings("unchecked")
 
        ArrayList<Edge> transpose[] = new ArrayList[V];
        for (int i = 0; i < V; i++) {
            isVisit[i] = false;
            transpose[i] = new ArrayList<Edge>();
        }
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < graph[i].size(); j++) {
                Edge e = graph[i].get(j);
                transpose[e.dest].add(new Edge(e.dest, e.src));// reverse

            }
        }

        // step3while
        while (!s.isEmpty()) {
            int curr = s.pop();
            if (!isVisit[curr]) {
                System.out.print("SCC -> ");
                dfs(transpose, curr, isVisit);
                System.out.println();
            }
        }
    }
    public static void main(String[] args) {
        int V=5;
        @SuppressWarnings("unchecked")

        ArrayList<Edge>graph[]=new ArrayList[V];
        createGraph(graph);
        kossaRaju(graph, V);
    }

}
