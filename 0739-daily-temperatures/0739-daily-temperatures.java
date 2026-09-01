class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> st = new Stack<>();
        int[] answer = new int[temperatures.length];
        for(int i = 0;i<temperatures.length;i++){
            if(st.isEmpty()){
                st.push(i);
            } else{
                while(!st.isEmpty() && temperatures[i] > temperatures[st.peek()]){
                    int prev = st.pop();
                    answer[prev] = i - prev;
                }
            }
            st.push(i);
        }
        return answer;
    }
}