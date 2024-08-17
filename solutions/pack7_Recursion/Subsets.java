package solutions.pack7_Recursion;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
    public static void printAllSubsets_Recurse(List<Integer> set) {
        Subset_helper(set, 0, new ArrayList<>());
        System.out.println();
    }

    public static void Subset_helper(List<Integer> set, int index, List<Integer> currentSubset) {
        if (index == set.size()) {
            System.out.print(currentSubset + " ");
            return;
        }

        currentSubset.add(set.get(index));
        Subset_helper(set, index + 1, currentSubset);

        currentSubset.removeLast();
        Subset_helper(set, index + 1, currentSubset);
    }

    public static void printAllSubsets_DP(List<Integer> set) {

    }
}
