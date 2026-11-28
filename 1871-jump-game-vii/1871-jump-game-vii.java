class Solution {
    public boolean canReach(String s, int minJump, int maxJump) {
        int n=s.length();
        boolean[] dp = new boolean[n];
        dp[0]=true;
        int end=0;
        for(int i=0;i<n;i++){
            if(dp[i]){
                int start=Math.max(i+minJump,end+1);
                end = Math.min(i+maxJump,n-1);
                for(int j=start;j<=end;j++){
                    if(s.charAt(j) == '0'){
                        dp[j] = true;
                    }
                }
            }
        }
        return dp[n-1];
    }
}