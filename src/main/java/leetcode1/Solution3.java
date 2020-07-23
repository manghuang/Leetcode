package leetcode1;

import java.util.Arrays;
import java.util.LinkedList;

class Solution3 {
    public static void main(String[] args) {
        int[][] a = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
        a = new Solution3().updateMatrix(a);
        for (int[] ints : a) {
            System.out.println(Arrays.toString(ints));
        }
    }

    public int[][] updateMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return null;
        }

        int[][] result = new int[matrix.length][matrix[0].length];
        boolean[][] visit = new boolean[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            Arrays.fill(visit[i], false);
        }

        LinkedList<Node> queue = new LinkedList<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    result[i][j] = 0;
                    visit[i][j] = true;
                    queue.offer(new Node(i, j));
                }
            }
        }

        bfs(queue, result, visit);
        return result;
    }

    private void bfs(LinkedList<Node> queue, int[][] result, boolean[][] visit) {
        int[] X = {-1, 0, 0, 1};
        int[] Y = {0, 1, -1, 0};
        while (!queue.isEmpty()) {
            Node node = queue.remove();
            int x = node.getX();
            int y = node.getY();
            for (int i = 0; i < 4; i++) {
                int newX = x + X[i];
                int newY = y + Y[i];
                if (newX >= 0 && newX < result.length && newY >= 0 && newY < result[0].length && !visit[newX][newY]) {
                    Node newNode = new Node(newX, newY);
                    queue.offer(newNode);
                    visit[newX][newY] = true;
                    result[newX][newY] = result[x][y] + 1;
                }
            }
        }

    }

    static class Node {
        private final int x;
        private final int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }
    }
}