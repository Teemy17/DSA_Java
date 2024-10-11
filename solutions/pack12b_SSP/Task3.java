package solutions.pack12b_SSP;

import java.util.*;

public class Task3 {

    // Define a helper method to track state equality
    private boolean isGoalState(int[] currentState, int[] goalState) {
        return Arrays.equals(currentState, goalState);
    }

    public int stateSpace(int[] beginState, int[] goalState) {
        // If the beginState is already sorted, return 0 operations needed
        if (isGoalState(beginState, goalState)) {
            return 0;
        }

        InterfaceSwapAdjacentPairs swapPairs = (State s) -> {
            int[] arr = s.getArray().clone();
            for (int i = 0; i < arr.length - 1; i += 2) {
                int temp = arr[i];
                arr[i] = arr[i + 1];
                arr[i + 1] = temp;
            }
            return arr;
        };

        InterfaceSwapCorrespondingHalves swapHalves = (State s) -> {
            int[] arr = s.getArray().clone();
            int n = arr.length / 2;
            for (int i = 0; i < n; i++) {
                int temp = arr[i];
                arr[i] = arr[i + n];
                arr[i + n] = temp;
            }
            return arr;
        };

        // Breadth-First Search (BFS) setup
        Queue<State> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        queue.add(new State(beginState)); // Start with the initial state
        visited.add(Arrays.toString(beginState)); // Mark it as visited

        int operations = 0; // To count the number of operations (level in BFS)

        while (!queue.isEmpty()) {
            int size = queue.size();

            // Process all states at the current BFS level
            for (int i = 0; i < size; i++) {
                State currentState = queue.poll();

                // Try swapping adjacent pairs
                int[] swappedPairs = swapPairs.swapAdjacentPairs(currentState);
                if (isGoalState(swappedPairs, goalState)) {
                    return operations + 1; // Goal reached
                }

                // If this state has not been visited, add it to the queue
                if (visited.add(Arrays.toString(swappedPairs))) {
                    queue.add(new State(swappedPairs));
                }

                // Try swapping corresponding halves
                int[] swappedHalves = swapHalves.swapCorrespondingHalves(currentState);
                if (isGoalState(swappedHalves, goalState)) {
                    return operations + 1; // Goal reached
                }

                // If this state has not been visited, add it to the queue
                if (visited.add(Arrays.toString(swappedHalves))) {
                    queue.add(new State(swappedHalves));
                }
            }

            // Increment the operation count after processing all states at the current level
            operations++;
        }

        // If no solution is found, return -1
        return -1;
    }
}
