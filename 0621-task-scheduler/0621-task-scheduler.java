class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq  = new int[26];
        for(char task : tasks){
            freq[task-'A']++;
        }
        int maxFreq = 0;
        for(int f : freq){
            maxFreq = Math.max(maxFreq,f);
        }
        int countmax = 0;
        for(int f :freq){
          if(f == maxFreq){
            countmax++;
          }  
        }
        int result = (maxFreq- 1) *(n + 1) + countmax;
        return Math.max(tasks.length, result);
    }
}