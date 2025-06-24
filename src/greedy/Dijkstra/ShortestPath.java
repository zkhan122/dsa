package greedy.Dijkstra;

public class ShortestPath {

    static final int TOTAL_VERTICES = 9;

    int minDistance(int dist[], Boolean shortestPathSet[]) {
        // initialize the minimum value
        int min = Integer.MAX_VALUE, min_index = -1;

        for (int v = 0; v < TOTAL_VERTICES; v++) {
            if (!shortestPathSet[v] && dist[v] <= min) {
                min = dist[v]; // if found then assign
                min_index = v;
            }
        }
        return min_index;
    }

    void printSolution(int dist[]) {
        System.out.println("Vertex: \t\t Distance from Soruce:");
        for (int i = 0; i < TOTAL_VERTICES; i++) {
            System.out.println(i + " \t\t " + dist[i]);
        }
    }

    void dijkstra(int graph[][], int root) {
        int dist[] = new int[TOTAL_VERTICES];

        Boolean shortesPathSet[] = new Boolean[TOTAL_VERTICES];

        for (int i = 0; i < TOTAL_VERTICES; i++) {
            dist[i] = Integer.MAX_VALUE;
            shortesPathSet[i] = false;
        }

        // distance of root node is always going to be 0
        dist[root] = 0;

        // now computing the shortest path for all the vertices (nodes)
        for (int count = 0; count < TOTAL_VERTICES - 1; count++) {
            int u = minDistance(dist, shortesPathSet);

            shortesPathSet[u] = true;

            // update the distance valuye of the adjacent vertices
            // for the picked vertex (node)
            for (int v = 0; v < TOTAL_VERTICES; v++) {
                /*
                Only update the distance for the vertex if :
                    - If not in shortestPathSet
                    - there is an edge from u to v and the total
                       weight of the path from the root ot v through u is
                        smaller than the current value of the distance of
                            the current vertex
                 */
                if (!shortesPathSet[v] && (graph[u][v] != 0)
                        && dist[u] != Integer.MAX_VALUE
                        && dist[u] + graph[u][v] < dist[v]) {
                    dist[v] = dist[u] + graph[u][v];
                }
            }
        }

        printSolution(dist);
    }

    public static void main(String[] args) {
        int graph[][]
                = new int[][] { { 0, 4, 0, 0, 0, 0, 0, 8, 0 },
                { 4, 0, 8, 0, 0, 0, 0, 11, 0 },
                { 0, 8, 0, 7, 0, 4, 0, 0, 2 },
                { 0, 0, 7, 0, 9, 14, 0, 0, 0 },
                { 0, 0, 0, 9, 0, 10, 0, 0, 0 },
                { 0, 0, 4, 14, 10, 0, 2, 0, 0 },
                { 0, 0, 0, 0, 0, 2, 0, 1, 6 },
                { 8, 11, 0, 0, 0, 0, 1, 0, 7 },
                { 0, 0, 2, 0, 0, 0, 6, 7, 0 } };

        ShortestPath path = new ShortestPath();

        // call dijkstra
        path.dijkstra(graph, 0);
    }
}
