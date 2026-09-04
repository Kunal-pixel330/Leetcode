class Solution {
    public void check(char[][] grid,int i,int j){
        int n=grid.length;
        int m=grid[0].length;
        if(i<0||i>=n||j<0||j>=m){
            return;
        }
        if(grid[i][j]!='1'){
            return;
        }
        grid[i][j]=0;
        check(grid,i,j+1);
        check(grid,i,j-1);
        check(grid,i-1,j);
        check(grid,i+1,j);
    }
    public int numIslands(char[][] grid) {
        int count=0; 
        int n=grid.length;
        int m=grid[0].length;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]=='1'){
                    count++;
                    check(grid,i,j);
                }
                    }
                }
                return count;
    }
}