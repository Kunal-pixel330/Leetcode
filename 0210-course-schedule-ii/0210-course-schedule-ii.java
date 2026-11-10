class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }
        int[] indegree = new int[numCourses];
        for(int[] p :prerequisites){
            int course = p[0];
            int pre = p[1];
            adj.get(pre).add(course);
            indegree[course]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0;i <numCourses;i++){
            if(indegree[i] == 0){
                queue.offer(i);
            }
        }
        int[] result = new int[numCourses];
        int index = 0;
        while(!queue.isEmpty()){
            int current = queue.poll();
            result[index++] =   current;
            for(int next: adj.get(current)){
                indegree[next]--;
                if(indegree[next] == 0){
                    queue.offer(next);
                }
            }
        }
        if(index != numCourses){
            return new int[0];
        }
        return result;
    }
}