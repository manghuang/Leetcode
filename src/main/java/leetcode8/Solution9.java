package leetcode8;

public class Solution9 {

    /*
        dps+回溯
        dps+回溯+return
     */

    private final int[] xPlus = {0, -1, 0, 1};
    private final int[] yPlus = {-1, 0, 1, 0};

    public boolean exist(char[][] board, String word) {
        boolean[][] isVisted = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (word.charAt(0) == board[i][j]) {
                    isVisted[i][j] = true;
                    boolean res = dps(board, i, j, word, 1, isVisted);
                    if (res) {
                        return true;
                    }
                    isVisted[i][j] = false;
                }
            }
        }
        return false;
    }

    private boolean dps(char[][] board, int x, int y, String word, int index, boolean[][] isVisted) {
        if (word.length() == index) {
            return true;
        }
        for (int i = 0; i < 4; i++) {
            int newX = x + xPlus[i];
            int newY = y + yPlus[i];
            if (newX >= 0 && newX < board.length && newY >= 0 && newY < board[0].length) {
                if (!isVisted[newX][newY] && word.charAt(index) == board[newX][newY]) {
                    isVisted[newX][newY] = true;
                    boolean res = dps(board, newX, newY, word, index + 1, isVisted);
                    if (res) {
                        return true;
                    }
                    isVisted[newX][newY] = false;
                }
            }
        }
        return false;
    }


}
