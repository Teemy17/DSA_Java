package solutions.pack11_Graph;

class EdgeWithBandwidth {
    int latency;
    Node node1, node2;
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

    public Node getOtherNode(Node node) {
        return (node == node1) ? node2 : node1;
    }
}