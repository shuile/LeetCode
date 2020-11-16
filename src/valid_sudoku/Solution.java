package valid_sudoku;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        char[][] board = {
                {'.', '.', '4', '.', '.', '.', '6', '3', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'5', '.', '.', '.', '.', '.', '.', '9', '.'},
                {'.', '.', '.', '5', '6', '.', '.', '.', '.'},
                {'4', '.', '3', '.', '.', '.', '.', '.', '1'},
                {'.', '.', '.', '7', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '5', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '.'}
        };

        char[][] board1 = {
                {'5', '1', '9', '7', '4', '8', '6', '3', '2'},
                {'7', '8', '3', '6', '5', '2', '4', '1', '9'},
                {'4', '2', '6', '1', '3', '9', '8', '7', '5'},
                {'3', '5', '7', '9', '8', '6', '2', '4', '1'},
                {'2', '6', '4', '3', '1', '7', '5', '9', '8'},
                {'1', '9', '8', '5', '2', '4', '3', '6', '7'},
                {'9', '7', '5', '8', '6', '3', '1', '2', '4'},
                {'8', '3', '2', '4', '9', '1', '7', '5', '6'},
                {'6', '4', '1', '2', '7', '5', '9', '8', '3'}
        };

        System.out.println(isValidSudoku(board));

        System.out.println(isValidSudoku(board1));

        System.out.println(isValidSudoku2(board));
    }

    private static boolean isValidSudoku(char[][] board) {
        int index = board.length;
        List<Character> chList = new ArrayList<>();
        // Each row must contain the digits 1-9 without repetition.
        for (int i = 0; i < index; i++) {
            chList.clear();
            for (int j = 0; j < index; j++) {
                if (board[i][j] == '.') {
                    continue;
                }
                if (!chList.contains(board[i][j])) {
                    chList.add(board[i][j]);
                } else {
                    return false;
                }
            }
        }
        // Each column must contain the digits 1-9 without repetition.
        for (int i = 0; i < index; i++) {
            chList.clear();
            for (int j = 0; j < index; j++) {
                if (board[j][i] == '.') {
                    continue;
                }
                if (!chList.contains(board[j][i])) {
                    chList.add(board[j][i]);
                } else {
                    return false;
                }
            }
        }
        // Each of the 9 3x3 sub-boxes of the grid must contain the digits 1-9 without repetition.
        for (int i = 0; i < index; i += 3) {
            for (int j = 0; j < index; j += 3) {
                chList.clear();
                for (int k = i; k < i + 3; k++) {
                    for (int l = j; l < j + 3; l++) {
                        if (board[k][l] == '.') {
                            continue;
                        }
                        if (!chList.contains(board[k][l])) {
                            chList.add(board[k][l]);
                        } else {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    private static boolean isValidSudoku2(char[][] board) {
        int row = board.length;
        int column = board[0].length;
        List<Character> list = new ArrayList<>();
        // judge every row
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                char ch = board[i][j];
                if (ch != '.') {
                    if (list.contains(ch)) {
                        return false;
                    } else {
                        list.add(ch);
                    }
                }
            }
            list.clear();
        }
        list.clear();
        for (int i = 0; i < column; i++) {
            for (int j = 0; j < row; j++) {
                char ch = board[i][j];
                if (ch != '.') {
                    if (list.contains(ch)) {
                        return false;
                    } else {
                        list.add(ch);
                    }
                }
            }
            list.clear();
        }
        list.clear();
        for (int i = 0; i < 9; i++) {
            int r = i / 3 * 3;
            int c = i % 3 * 3;
            for (int j = r; j < r + 3; j++) {
                for (int k = c; k < c + 3; k++) {
                    char ch = board[j][k];
                    if (ch != '.') {
                        if (list.contains(ch)) {
                            return false;
                        } else {
                            list.add(ch);
                        }
                    }
                }
            }
            list.clear();
        }
        return true;
    }
}
