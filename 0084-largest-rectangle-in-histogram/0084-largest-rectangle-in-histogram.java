class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> st = new Stack<>();
        int maxArea = 0;
        for(int i = 0;i<=heights.length;i++){
            int currentHeight;
            if(i== heights.length){
                currentHeight = 0;
            } else{
                currentHeight = heights[i];
            }
            while(!st.isEmpty() && heights[st.peek()] > currentHeight){
                int height = heights[st.pop()];
                int width;
                if(st.isEmpty()){
                    width = i;
                } else{
                    width = i - st.peek() - 1;
                }
                int area = height*width;
                maxArea = Math.max(maxArea,area);
            }
            st.push(i);
        }
        return maxArea;
    }
}