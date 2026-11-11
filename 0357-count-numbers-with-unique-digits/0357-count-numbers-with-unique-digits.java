class Solution {
    private int[][][] memo;
    public int countNumbersWithUniqueDigits(int n) {
        memo = new int[n + 1][1 << 10][2];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j < (1 << 10); j++) {
                Arrays.fill(memo[i][j], -1);
            }
        }
        return dfs(0, 0, false, n);
    }
    private int dfs(int pos, int mask,boolean started, int n) {
        if (pos == n) {
            return 1;
        }
        int start = started ? 1 : 0;
        if (memo[pos][mask][start] != -1) {
            return memo[pos][mask][start];
        }
        int result = 0;
        for (int d =0; d<= 9; d++) {
            if (!started&&d == 0) {
                result+= dfs(pos+ 1, mask, false, n);
            }
            else if ((mask& (1<< d)) == 0) {
                int newMask =mask | (1 << d);
                result += dfs(pos+1, newMask, true, n);
            }
        }
        return memo[pos][mask][start] = result;
    }
}