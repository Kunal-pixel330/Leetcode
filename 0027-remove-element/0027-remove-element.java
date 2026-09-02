class Solution {
    public int removeElement(int[] nums, int val) {
        int i=0;
        int k=0;
        for(i=0; i< nums.length;i++){
            if(nums[i] != val){
                nums[k] = nums[i];
                k++;
            } 
        }
        return k;
    }
}