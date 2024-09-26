package solutions.pack11_Graph;

public class EdgeWithBandwidth {
    int latency;
    Node node1, node2; // Assuming nodes are represented by objects
    int bandwidth;

    public EdgeWithBandwidth(int latency, int bandwidth, Node node1, Node node2) {
        this.latency = latency;
        this.bandwidth = bandwidth;
        this.node1 = node1;
        this.node2 = node2;
    }

    public int getLatency() {
        return latency;
    }
}
