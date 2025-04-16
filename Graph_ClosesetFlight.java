import java.util.*;
import java.util.Queue;
import java.util.LinkedList;

public class Graph_ClosesetFlight {
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

    public static void createGraph(int flight[][], ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < flight.length; i++) {
            int src = flight[i][0];
            int dest = flight[i][1];
            int wt = flight[i][2];
            Edge e = new Edge(src, dest, wt);
            graph[src].add(e);

        }
    }

    static class Info {
        int v, cost, stop;

        public Info(int v, int cost, int stop) {
            this.v = v;
            this.cost = cost;
            this.stop = stop;
        }
    }

    public static int cheapestFlight(int n, int flight[][], int src, int dest, int k) {
        @SuppressWarnings("unchecked")

        ArrayList<Edge> graph[] = new ArrayList[n];
        createGraph(flight, graph);
        int dist[] = new int[n];
        for (int i = 0; i < n; i++) {

            if (i != src) {
                dist[i] = Integer.MAX_VALUE;
            }
        }
        Queue<Info> q = new LinkedList<>();
        q.add(new Info(src, 0, 0));
        while (!q.isEmpty()) {
            Info curr = q.remove();
            if (curr.stop > k) {
                break;
            }
            for (int i = 0; i < graph[curr.v].size(); i++) {
                Edge e = graph[curr.v].get(i);
               // int u = e.src;
                int v = e.dest;
                int wt = e.weight;
                // if (dist[u] != Integer.MAX_VALUE && dist[u] + wt < dist[v] && curr.stop <= k) {
                //     dist[v]=dist[u]+wt;
                //     q.add(new Info(v, dist[v], curr.stop + 1));

                // }
                if(curr.cost+wt<dist[v]&&curr.stop <= k){
                    dist[v]=curr.cost+wt;
                    q.add(new Info(v, dist[v], curr.stop + 1));
                }
            }
        }
        if (dist[dest] == Integer.MAX_VALUE) {
            return -1;

        } else {
            return dist[dest];

        }

    }

    public static void main(String[] args) {
        int n = 4;
        int flight[][] = { { 0, 1, 100 }, { 1, 2, 100 }, { 2, 0, 100 }, { 1, 3, 600 }, { 2, 3, 200 } };
        int src = 0, dest = 3, k = 1;
       int result = cheapestFlight(n, flight, src, dest, k);
        if (result == -1) {
            System.out.println("No valid flight found within " + k + " stops.");
        } else {
            System.out.println("The cheapest flight cost from " + src + " to " + dest + " with at most " + k + " stops is: " + result);
        }
    }
    }


