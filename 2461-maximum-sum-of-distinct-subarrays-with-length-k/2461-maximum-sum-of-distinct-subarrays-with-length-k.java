class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        int[] freq = new int[100001];
        long sum = 0;
        long maxSum = 0;
        int distinct = 0;
        for (int right=0;right<nums.length;right++) {
            int value=nums[right];
            if (freq[value]++==0) {
                distinct++;
            }
            sum+=value;
            if (right>=k) {
                int removed=nums[right-k];
                sum-=removed;
                if (--freq[removed]==0) {
                    distinct--;
                }
            }
            if (right>=k-1&&distinct==k) {
                maxSum = Math.max(maxSum, sum);
            }
        }
        return maxSum;
    }
}