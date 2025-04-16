import java.util.*;

public class Graph_TopologicalSort_Using_Dfs {

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

        

        graph[2].add(new Edge(2, 3));
        graph[5].add(new Edge(5, 0));
        graph[4].add(new Edge(4, 0));
        graph[4].add(new Edge(4, 1));
        graph[5].add(new Edge(5, 2));
        graph[3].add(new Edge(3, 1));


    }

    public static void topSort(ArrayList<Edge>[] graph) {
        boolean isVisit[] = new boolean[graph.length];
        Stack<Integer> s = new Stack<>();
        for (int i = 0; i < graph.length; i++) {
            if (!isVisit[i]) {
                topSortutil(graph, i, isVisit, s);
            }
        }while(!s.isEmpty()){
        System.out.print(s.pop() + " ");
        }
    }

    public static void topSortutil(ArrayList<Edge> graph[], int curr, boolean isVisit[], Stack<Integer> s) {
        isVisit[curr] = true;
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (!isVisit[e.dest]) {
                topSortutil(graph, e.dest, isVisit, s);
            }
        }
        s.push(curr);

    }

    public static void main(String[] args) {
        int v = 6;
        @SuppressWarnings("unchecked")

        ArrayList<Edge> graph[] = new ArrayList[v];
        createGraph(graph);
        topSort(graph);
    }
}
