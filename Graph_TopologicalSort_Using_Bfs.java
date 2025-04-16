import java.util.*;
import java.util.LinkedList;
import java.util.Queue;

public class Graph_TopologicalSort_Using_Bfs {
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

    public static void calcIndegree(ArrayList<Edge> graph[], int indegree[]) {
        for (int i = 0; i < graph.length; i++) {
            int v = i;
            for (int j = 0; j < graph[v].size(); j++) {
                Edge e = graph[v].get(j);
                indegree[e.dest]++;

            }
        }
    }

    public static void topSor(ArrayList<Edge> graph[],int indegree[]) {
       // int indegree[] = new int[graph.length];
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }
        while (!q.isEmpty()) {

            int curr = q.remove();
            System.out.print(curr + " ");
            for (int i = 0; i < graph[curr].size(); i++) {
                Edge e = graph[curr].get(i);
                indegree[e.dest]--;
                if (indegree[e.dest] == 0) {
                    q.add(e.dest);
                }
            }
        }
        System.out.println();

    }

    public static void main(String[] args) {
        int v = 6;
        @SuppressWarnings("unchecked")

        ArrayList<Edge> graph[] = new ArrayList[v];
        createGraph(graph);
        int indegree[] = new int[v];
        calcIndegree(graph, indegree);
        topSor(graph, indegree);;
    }

}