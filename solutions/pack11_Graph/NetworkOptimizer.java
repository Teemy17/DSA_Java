package solutions.pack11_Graph;

import java.util.*;

public class NetworkOptimizer {
    public int optimizeNetwork(int N, int M, int[][] input) {

        int totalLatency = 0;

        Node[] nodes = new Node[N];
        for (int i = 0; i < N; i++) {
            nodes[i] = new Node(i + 1);
        }

        for (int i = 0; i < input.length; i++) {
            int node1Id = input[i][0];
            int node2Id = input[i][1];
            int latency = input[i][2];
            Edge edge = new Edge(latency, nodes[node1Id - 1], nodes[node2Id - 1]);
            nodes[node1Id - 1].addEdge(edge);
            nodes[node2Id - 1].addEdge(edge);
        }

        /*
         * TASK 2: Implement PRIM's algorithm to find the minimum spanning tree
         * by using latency as the weight
         *
         * The algorithm should return the total latency of the minimum spanning tree
         */

        Node starNode = nodes[0];
        PriorityQueue<Edge> pq = new PriorityQueue<>(new EdgeComparator());

        // implement the algorithm here

        return totalLatency;

    }


    public int optimizeNetwork(int N, int M, int T, int[][] input) {

        int totalLatency = 0;

        Node[] nodes = new Node[N];
        for (int i = 0; i < N; i++) {
            nodes[i] = new Node(i + 1);
        }

        for (int i = 0; i < input.length; i++) {
            int node1Id = input[i][0];
            int node2Id = input[i][1];
            int latency = input[i][2];
            int bandwidth = input[i][3];
            if (bandwidth >= T) {
                EdgeWithBandwidth edgeWithBandwidth = new EdgeWithBandwidth(latency, bandwidth, nodes[node1Id - 1], nodes[node2Id - 1]);
                nodes[node1Id - 1].addEdgeWithBandwidth(edgeWithBandwidth);
                nodes[node2Id - 1].addEdgeWithBandwidth(edgeWithBandwidth);
            }
        }

//        /*
//         * TASK 3: Implement PRIM's algorithm to find the minimum spanning tree
//         * by using latency as the weight and
//         * the edge that have bandwidth less than T should not be included in the
//         * minimum spanning tree
//         *
//         * The algorithm should return the total latency of the minimum spanning tree
//         */

        // implement algorithm here
        Node starNode = nodes[0];
        PriorityQueue<EdgeWithBandwidth> pq = new PriorityQueue<>(new EdgeWithBandwidthComparator());
        Set<Node> visited = new HashSet<>();

        visited.add(starNode);
        pq.addAll(starNode.getEdgesWithBandwidth());

        while (!pq.isEmpty()) {
            EdgeWithBandwidth currentEdgeWithBandwidth = pq.poll();
            Node nextNode = !visited.contains(currentEdgeWithBandwidth.node1) ? currentEdgeWithBandwidth.node1 : currentEdgeWithBandwidth.node2;

            if (visited.contains(nextNode)) {
                continue;
            }

            visited.add(nextNode);
            totalLatency += currentEdgeWithBandwidth.getLatency();

            for (EdgeWithBandwidth edgeWithBandwidth : nextNode.getEdgesWithBandwidth()) {
                if (!visited.contains(edgeWithBandwidth.node1) || !visited.contains(edgeWithBandwidth.node2)) {
                    pq.offer(edgeWithBandwidth);
                }
            }
        }

        if (visited.size() != N) {
            return -1;
        }
        return totalLatency;
    }

}