package solutions.pack12b_SSP;

public class Dijkstra {

    int[][] adjMatrix;
    int[] previous, distance;
    boolean[] visted;
    int source;

    public Dijkstra(int[][] adjMatrix, int source) {
        this.adjMatrix = adjMatrix;
        this.source = source;
        previous = new int[adjMatrix.length];
        distance = new int[adjMatrix.length];
        visted = new boolean[adjMatrix.length];
    }

    //Task 1 imeplement the findSSP method using Dijkstra's algorithm
    public void findSSP() {
        for (int i = 0; i < adjMatrix.length; i++) {
            distance[i] = Integer.MAX_VALUE;
            previous[i] = 0;
            visted[i] = false;
        }
        distance[source] = 0;
        for (int i = 0; i < adjMatrix.length; i++) {
            int u = minDistance();
            visted[u] = true;
            for (int v = 0; v < adjMatrix.length; v++) {
                if (!visted[v] && adjMatrix[u][v] != -1 && distance[u] + adjMatrix[u][v] < distance[v]) {
                    distance[v] = distance[u] + adjMatrix[u][v];
                    previous[v] = u;
                }
            }
        }
        System.out.println(java.util.Arrays.toString(distance));
        System.out.println(java.util.Arrays.toString(previous));
    }

    private int minDistance() {
        int min = Integer.MAX_VALUE;
        int minIndex = -1;
        for (int i = 0; i < adjMatrix.length; i++) {
            if (!visted[i] && distance[i] <= min) {
                min = distance[i];
                minIndex = i;
            }
        }
        return minIndex;
    }

    //Task 2 implement the printAllSSP method to print the shortest path
    //from the source to all other nodes
    public void printAllSSP(){
        for (int i = 0; i < adjMatrix.length; i++) {
            System.out.println("Shortest path from " + source + " to " + i + " is " + distance[i]);
            System.out.println(printPath(i));
        }
    }

    private String printPath(int i) {
        if (i == source) {
            return String.valueOf(i);
        }
        return printPath(previous[i]) + " -> " + i;
    }

}