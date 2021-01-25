package leetcode15;

public class Solution10 {

    public int regionsBySlashes(String[] grid) {
        int length = grid.length;
        byte[][] graph = new byte[length][length];
        boolean[][][] isVisited = new boolean[length][length][4];
        for (int i = 0; i <length ; i++) {
            for (int j = 0; j < length; j++) {
                char ch = grid[i].charAt(j);
                if(ch == ' '){
                    graph[i][j] = 1;
                }else if(ch == '/'){
                    graph[i][j] = 2;
                }else {
                    graph[i][j] = 3;
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                for (int k = 0; k < 4; k++) {
                    if(!isVisited[i][j][k]){
                        ans++;
                        dfs(graph, isVisited, i, j, k);
                    }
                }
            }
        }
        return ans;
    }

    private void dfs(byte[][] graph, boolean[][][] isVisited, int x, int y, int k) {
        int length = graph.length;
        if(x < 0 || x >= length || y < 0 || y >= length || isVisited[x][y][k]){
            return;
        }
        if(graph[x][y] == 1){
            for (int i = 0; i < 4; i++) {
                isVisited[x][y][i] = true;
            }
            dfs(graph, isVisited, x-1, y, 2);
            dfs(graph, isVisited, x, y+1, 3);
            dfs(graph, isVisited, x+1, y, 0);
            dfs(graph, isVisited, x, y-1, 1);
        }else if(graph[x][y] == 2){
            if(k == 0 || k == 3){
                isVisited[x][y][0] = true;
                isVisited[x][y][3] = true;
                dfs(graph, isVisited, x, y-1, 1);
                dfs(graph, isVisited, x-1, y, 2);

            }else {
                isVisited[x][y][1] = true;
                isVisited[x][y][2] = true;
                dfs(graph, isVisited, x+1, y, 0);
                dfs(graph, isVisited, x, y+1, 3);
            }
        }else {
            if(k == 0 || k == 1){
                isVisited[x][y][0] = true;
                isVisited[x][y][1] = true;
                dfs(graph, isVisited, x, y+1, 3);
                dfs(graph, isVisited, x-1, y, 2);
            }else {
                isVisited[x][y][2] = true;
                isVisited[x][y][3] = true;
                dfs(graph, isVisited, x, y-1, 1);
                dfs(graph, isVisited, x+1, y, 0);
            }
        }
    }

}
