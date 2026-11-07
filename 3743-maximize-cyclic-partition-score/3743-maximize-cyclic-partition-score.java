class Solution {
    private long helper(int[] nums, int k, int startState) {
        int n = nums.length;
        long NEG = Long.MIN_VALUE / 4;
        long[][] dp = new long[2 * k + 1][3];
        for (long[] row : dp) {
            Arrays.fill(row, NEG);
        }
        dp[0][startState] = 0;
        for (int i = 0; i < n; i++) {
            long x = nums[i];
            for (int j = 2 * k - 1; j >= 0; j--) {
                for (int state = 0; state < 3; state++) {
                    if (state < 2) {
                        dp[j + 1][state + 1] = Math.max(
                            dp[j + 1][state + 1],
                            dp[j][state] + x
                        );
                    }
                    if (state > 0) {
                        dp[j + 1][state - 1] = Math.max(
                            dp[j + 1][state - 1],
                            dp[j][state] - x
                        );
                    }
                }
            }
        }
        long ans = NEG;
        for (int i = 0; i <= 2 * k; i += 2) {
            ans = Math.max(ans, dp[i][startState]);
        }
        return ans;
    }
    public long maximumScore(int[] nums, int k) {
        return Math.max(
            helper(nums, k, 0),
            Math.max(
                helper(nums, k, 1),
                helper(nums, k, 2)
            )
        );
    }
}