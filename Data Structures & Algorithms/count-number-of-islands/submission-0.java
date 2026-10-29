class Solution {
    public int numIslands(char[][] grid) {

        int numOfIslands = 0;

        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[0].length; j++) {
                if(grid[i][j] == '1') {
                    numOfIslands++;
                    dfs(i,j,grid);
                }
            }
        }
        return numOfIslands;
    }

    void dfs(int i, int j, char[][] grid) {
        if(i >= grid.length || j >= grid[0].length) {
            return;
        }

        if(grid[i][j] == '1') {
            grid[i][j] = 0;
            if(j < grid[0].length){
                dfs(i, j+1, grid);
            }
            if(j > 0) {
                dfs(i, j-1, grid);
            }
            if(i > 0) {
                 dfs(i-1, j, grid);
            }
            if(i < grid.length) {
                 dfs(i+1, j, grid);
            }   
        }
    }
}
