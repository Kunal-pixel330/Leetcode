class Solution {
    public int countCompleteSubstrings(String word, int k) {
        int n = word.length(), ans = 0, i = 0;
        char[] w = word.toCharArray();
        while (i < n) {
            int j = i + 1;
            while (j < n && Math.abs(w[j] - w[j - 1]) <= 2) j++;
            for (int u = 1; u <= 26 && (long) u * k <= j - i; u++) {
                int len = u * k, good = 0;
                int[] cnt = new int[26];
                for (int r = i; r < j; r++) {
                    int c = w[r] - 'a';
                    if (cnt[c] == k) good--;
                    cnt[c]++;
                    if (cnt[c] == k) good++;
                    if (r - i >= len) {
                        int d = w[r - len] - 'a';
                        if (cnt[d] == k) good--;
                        cnt[d]--;
                        if (cnt[d] == k) good++;
                    }
                    if (r - i + 1 >= len && good == u) ans++;
                }
            }
            i = j;
        }
        return ans;
    }
}