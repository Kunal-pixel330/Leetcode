class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int minSize = Integer.MAX_VALUE;
        int sum = 0;
        int left = 0;
        for(int right=0;right<n;right++){
            sum += nums[right];
            while(sum>=target){
                minSize = Math.min(minSize,right-left+1);
                sum -= nums[left];
                left++;
            }
        }
        return minSize == Integer.MAX_VALUE ? 0:minSize;
    }
}