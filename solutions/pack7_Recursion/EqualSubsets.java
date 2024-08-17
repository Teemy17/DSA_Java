package solutions.pack7_Recursion;

public class EqualSubsets {
    public static boolean canPartition(int[] arr, int target, int index) {
        if (target == 0) {
            return true;
        }
        if (index < 0 || target < 0) {
            return false;
        }

        return canPartition(arr, target - arr[index], index - 1)
                || canPartition(arr, target, index - 1);
    }

    // Time complexity: O(2^n)
    public static boolean canPartition_Recur(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        if (sum % 2 != 0) {
            return false;
        }
        int target = sum / 2;
        return canPartition(arr, target, arr.length - 1);
    }

    // Time complexity: O(n)
    public static boolean canPartition_Memoize(int[] arr) {
        int[] cache = new int[arr.length];
        int sum = 0;
        cache[0] = arr[0];

        for (int i = 1; i < arr.length; i++) {
            cache[i] = cache[i - 1] + arr[i];
        }

        sum = cache[arr.length - 1];

        if (sum % 2 != 0) {
            return false;
        }

        int target = sum / 2;
        return canPartition(arr, target, arr.length - 1);
    }

    // Time complexity: O(n*sum)
    public static boolean canPartition_DP(int[] arr) {
        int sum = 0;
        int n = arr.length;

        for (int i : arr) sum += i;

        if (sum % 2 != 0) return false;

        sum /= 2;

        boolean[][] dp = new boolean[n + 1][sum + 1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= sum; j++) {
                if (i == 0 || j == 0)
                    dp[i][j] = false;
                else if (arr[i - 1] > j)     // if the current element is greater than the sum
                    dp[i][j] = dp[i - 1][j];
                else if (arr[i - 1] == j)
                    dp[i][j] = true;
                else
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - arr[i - 1]];
            }
        }
        return dp[n][sum];
    }
}
