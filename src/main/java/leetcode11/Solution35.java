package leetcode11;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution35 {

    public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
        List<int[]> list = bfs(R, C, r0, c0);
        return list.toArray(new int[0][]);
    }

    private List<int[]> bfs(int R, int C, int x, int y) {
        List<int[]> res = new ArrayList<>();
        if(x < 0 || x >= R || y < 0 || y >= C){
            return res;
        }
        boolean[][] isVisted = new boolean[R][C];
        Queue<int[]> queue = new LinkedList<>();

        isVisted[x][y] = true;
        int[] node = {x, y};
        res.add(node);
        queue.offer(node);

        int[] X = new int[]{-1, 0, 1, 0};
        int[] Y = new int[]{0, 1, 0, -1};
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] remove = queue.remove();
                for (int j = 0; j <4 ; j++) {
                    int newX = remove[0] + X[j];
                    int newY = remove[1] + Y[j];
                    if(newX >= 0 && newX < R && newY >= 0 && newY < C && !isVisted[newX][newY]){
                        isVisted[newX][newY] = true;
                        int[] temp = new int[]{newX, newY};
                        res.add(temp);
                        queue.add(temp);
                    }
                }
            }
        }
        return res;
    }
}
