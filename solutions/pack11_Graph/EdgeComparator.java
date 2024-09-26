package solutions.pack11_Graph;
import java.util.Comparator;

public class EdgeComparator implements Comparator<Edge> {
    @Override
    public int compare(Edge o1, Edge o2) {
        return Integer.compare(o1.getLatency(), o2.getLatency());
    }

}

