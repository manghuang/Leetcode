package leetcode9;

import java.util.*;

public class Solution0 {

    public static void main(String[] args) {
        char[][] chars = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };

        new Solution0().solveSudoku(chars);
        for (char[] chs : chars
        ) {
            System.out.println(Arrays.toString(chs));
        }

    }

    /*
        dps+回溯
     */
    public void solveSudoku(char[][] board) {
        if (board == null || board.length == 0 || board[0] == null || board[0].length == 0) {
            return;
        }
        if (board.length != 9 || board[0].length != 9) {
            return;
        }
        List<int[]> theLocNeedToWrite = new ArrayList<>();
        Map<Integer, Set<Character>> theNumHadExit = new HashMap<>();
        for (int i = 0; i < 27; i++) {
            Set<Character> set = new HashSet<>(9);
            theNumHadExit.put(i, set);
        }
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char ch = board[i][j];
                if (ch == '.') {
                    int[] temp = new int[2];
                    temp[0] = i;
                    temp[1] = j;
                    theLocNeedToWrite.add(temp);
                } else {
                    theNumHadExit.get(i).add(ch);
                    theNumHadExit.get(9 + j).add(ch);
                    int num = (i / 3) * 3 + j / 3;
                    theNumHadExit.get(18 + num).add(ch);
                }
            }
        }
        boolean res = dps(board, theLocNeedToWrite, 0, theNumHadExit);
        System.out.println(res);
    }

    private boolean dps(char[][] board, List<int[]> theLocNeedToWrite, int index, Map<Integer, Set<Character>> theNumHadExit) {
        if (index == theLocNeedToWrite.size()) {
            return true;
        }
        int[] temp = theLocNeedToWrite.get(index);
        int x = temp[0];
        int y = temp[1];
        int num = (x / 3) * 3 + y / 3;
        for (int i = 1; i <= 9; i++) {
            char ch = (char) ('0' + i);

            if (!theNumHadExit.get(x).contains(ch) && !theNumHadExit.get(9 + y).contains(ch) &&
                    !theNumHadExit.get(18 + num).contains(ch)) {
                theNumHadExit.get(x).add(ch);
                theNumHadExit.get(9 + y).add(ch);
                theNumHadExit.get(18 + num).add(ch);
                board[x][y] = ch;
                if (dps(board, theLocNeedToWrite, index + 1, theNumHadExit)) {
                    return true;
                }
                theNumHadExit.get(x).remove(ch);
                theNumHadExit.get(9 + y).remove(ch);
                theNumHadExit.get(18 + num).remove(ch);
                board[x][y] = '.';
            }

        }
        return false;
    }

}
