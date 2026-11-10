class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] dist = new int[m][n];
        Queue<int[]> q = new LinkedList<>();
        int[][] directions = {
            {0, 1},
            {0, -1},
            {1, 0},
            {-1, 0}
        };
        for (int i=0; i<m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    dist[i][j] = 0;
                    q.offer(new int[]{i, j});
                } else {
                    dist[i][j] = -1;
                }
            }
        }
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            for (int[] dir : directions) {
                int r = curr[0] + dir[0];
                int c = curr[1] + dir[1];
                if (r >= 0 && r < m &&
                    c >= 0 && c < n &&
                    dist[r][c] == -1) {
                    dist[r][c] = dist[curr[0]][curr[1]] + 1;
                    q.offer(new int[]{r, c});
                }
            }
        }
        return dist;
    }
}
