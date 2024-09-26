package solutions.pack11_Graph;

public class Edge {
    int latency;
    Node node1, node2;

    public Edge(int latency, Node node1, Node node2) {
        this.latency = latency;
        this.node1 = node1;
        this.node2 = node2;
    }

    public int getLatency() {
        return latency;
    }
}
