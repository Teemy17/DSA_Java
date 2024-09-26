package solutions.pack11_Graph;

import java.util.Comparator;

public class EdgeWithBandwidthComparator implements Comparator<EdgeWithBandwidth> {
    @Override
    public int compare(EdgeWithBandwidth o1, EdgeWithBandwidth o2) {
        return Integer.compare(o1.getLatency(), o2.getLatency());
    }
}
