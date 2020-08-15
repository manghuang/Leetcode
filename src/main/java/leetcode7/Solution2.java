package leetcode7;

public class Solution2 {
    public void solve(char[][] board) {
        if (board == null || board.length == 0 || board[0] == null ||
                board[0].length == 0) {
            return;
        }
        int xLength = board.length;
        int yLength = board[0].length;
        for (int i = 0; i < yLength; i++) {
            dps(board, 0, i);
            dps(board, xLength - 1, i);
        }
        for (int i = 1; i < xLength - 1; i++) {
            dps(board, i, 0);
            dps(board, i, yLength - 1);
        }
        for (int i = 0; i < xLength; i++) {
            for (int j = 0; j < yLength; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == '1') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    private void dps(char[][] board, int x, int y) {
        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length) {
            return;
        }
        if (board[x][y] == 'O') {
            board[x][y] = '1';
            dps(board, x - 1, y);
            dps(board, x, y - 1);
            dps(board, x, y + 1);
            dps(board, x + 1, y);
        }
    }
}
