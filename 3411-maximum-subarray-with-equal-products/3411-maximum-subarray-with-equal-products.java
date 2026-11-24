class Solution {
    public int maxLength(int[] nums) {
        int n = nums.length;
        int ans = 0;
        for (int i=0;i<n;i++) {
            long product = 1;
            long lcm = 1;
            int gcd = 0;
            for (int j = i; j < n; j++) {
                int num = nums[j];
                product *= num;
                gcd = findGCD(gcd, num);
                lcm = (lcm * num) / findGCD(lcm, num);
                if (product == (long) gcd * lcm) {
                    ans = Math.max(ans, j - i + 1);
                }
            }
        }
        return ans;
    }
    private int findGCD(long a, long b) {
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return(int)a;
    }
}