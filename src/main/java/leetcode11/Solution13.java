package leetcode11;

public class Solution13 {

    public int islandPerimeter(int[][] grid) {
        if(grid == null || grid.length ==0 || grid[0] == null || grid[0].length == 0){
            return 0;
        }
        int xLength = grid.length;
        int yLength = grid[0].length;
        boolean[][] hasVisited = new boolean[xLength][yLength];
        for(int i=0; i<xLength; i++){
            for(int j=0; j<yLength; j++){
                if(grid[i][j] == 1){
                    return dfs(grid, hasVisited, i, j, -1);
                }
            }
        }
        return 0;
    }

    private int dfs(int[][] grid, boolean[][] hasVisited, int x, int y, int index) {

        if(x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y]  == 0){
            return 1;
        }
        if(grid[x][y] == 1 && hasVisited[x][y]){
            return 0;
        }
        hasVisited[x][y] = true;
        int temp = 0;
        if(index != 0){
            temp += dfs(grid, hasVisited, x-1, y, 1);
        }
        if(index != 1){
            temp += dfs(grid, hasVisited, x+1, y, 0);
        }
        if(index != 2){
            temp += dfs(grid, hasVisited, x, y-1, 3);
        }
        if(index != 3){
            temp += dfs(grid, hasVisited, x, y+1, 2);
        }
        return temp;
    }
}
