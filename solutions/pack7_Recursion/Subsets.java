package solutions.pack7_Recursion;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
    // Time complexity: O(2^n) where n is the number of elements in the set
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

    // Time complexity: O(n*2^n) where n is the number of elements in the set
    public static void printAllSubsets_DP(List<Integer> set) {
        List<List<Integer>> allSubsets = new ArrayList<>();
        allSubsets.add(new ArrayList<>());

        for (Integer integer : set) {
            int n = allSubsets.size();
            for (int j = 0; j < n; j++) {
                List<Integer> subset = new ArrayList<>(allSubsets.get(j));
                subset.add(integer);
                allSubsets.add(subset);
            }
        }

        for (List<Integer> subset : allSubsets) {
            System.out.print(subset + " ");
        }
        System.out.println();
    }
}
