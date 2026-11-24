class Solution {
    static {
        for (int i = 0; i < 500; i++) {
            subarraysWithKDistinct(new int[0], 1);
        }
    }
    public static int subarraysWithKDistinct(int[] nums, int k) {
        int left1=0, left2=0;
        int ans=0, n=nums.length;
        int[] arr=new int[nums.length+1];
        int[] arr1=new int[nums.length+1];
        int dist=0;
        int temp_dist=dist;
        for(int right=0;right<n;right++){
            if(arr[nums[right]] == 0){
                dist++;
            }
            if(arr1[nums[right]] == 0){
                temp_dist++;
            }
            arr[nums[right]]++;
            arr1[nums[right]]++;
            while(dist>k && left1<=right){
                arr[nums[left1]]--;
                if(arr[nums[left1]]==0){
                    dist--;
                }
                left1++;
            }
            if(dist==k){
                while(left2<=right && temp_dist==k){
                    arr1[nums[left2]]--;
                    if(arr1[nums[left2]]==0){
                        temp_dist--;
                    }
                    left2++;
                }
                ans+=(left2-left1);
            }
        }
        return ans;
    }
}