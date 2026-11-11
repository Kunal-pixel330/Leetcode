class Solution {
    private char[] digits;
    private Long[][][][][] memo;
    private static final int OFFSET = 150;
    public long countBalanced(long low, long high) {
        return countUpTo(high) - countUpTo(low - 1);
    }
    private long countUpTo(long x) {
        if (x < 11) {
            return 0;
        }
        digits = String.valueOf(x).toCharArray();
        int n = digits.length;
        memo = new Long[n][301][2][2][3];
        return dfs(0,0,false,true,0, true);
    }
    private long dfs(int pos, int diff,boolean started, boolean oddNext,int count, boolean tight) {
        if (pos == digits.length) {
            return count>=2 && diff==0 ? 1 : 0;
        }
        int index = diff + OFFSET;
        if (!tight && memo[pos][index][started ?1 : 0][oddNext ? 1 : 0][count] != null) {
            return memo[pos][index][started? 1 :0][oddNext ? 1 : 0][count];
        }
        int limit = tight ? digits[pos] - '0' : 9;
        long result = 0;
        for (int d =0; d<= limit; d++) {
            boolean nextTight = tight && (d == limit);
            if (!started && d == 0) {
                result += dfs(pos + 1, diff,false, true, 0,nextTight);
            } else {
                int newDiff = diff + (oddNext ? d : -d);
                result += dfs(pos + 1,newDiff, true,!oddNext,Math.min(2, count + 1),nextTight);
            }
        }
        if (!tight) {
            memo[pos][index][started ?1 :0][oddNext ? 1 : 0][count] = result;
        }
        return result;
    }
}