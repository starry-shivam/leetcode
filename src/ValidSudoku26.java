import utils.ExecDuration;

import java.util.HashSet;

public class ValidSudoku26 {

    public static void main(String[] args) {
        ValidSudoku26 obj = new ValidSudoku26();
        char[][] board = {
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
        System.out.println(obj.isValidSudoku2(board));
        System.out.println("ValidSudoku 1:");
        ExecDuration.measure(() -> obj.isValidSudoku1(board));
        System.out.println("ValidSudoku 2:");
        ExecDuration.measure(() -> obj.isValidSudoku2(board));
    }

    // Simple solution but not efficient, run much slower than the
    // second solution. However, it uses less memory.
    public boolean isValidSudoku1(char[][] board) {
        HashSet<String> seen = new HashSet<>();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char num = board[i][j];
                if (num != '.') {
                    if (!seen.add(num + " in row " + i) ||
                            !seen.add(num + " in column " + j) ||
                            !seen.add(num + " in sub-box " + i / 3 + "-" + j / 3)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    // better but bit complex solution.
    // Runs almost 500 times faster than the first solution.
    public boolean isValidSudoku2(char[][] board) {
        for (int i = 0; i < 9; i++) {
            HashSet<Character> row = new HashSet<>();
            HashSet<Character> col = new HashSet<>();
            HashSet<Character> box = new HashSet<>();
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.' && !row.add(board[i][j])) return false;
                if (board[j][i] != '.' && !col.add(board[j][i])) return false;
                int boxRow = 3 * (i / 3) + j / 3;
                int boxCol = 3 * (i % 3) + j % 3;
                if (board[boxRow][boxCol] != '.' && !box.add(board[boxRow][boxCol])) return false;
            }
        }
        return true;
    }
}
