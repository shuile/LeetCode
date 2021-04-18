package cn.shui.order.sudoku_solver;

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        char[][] board1 = {
                {'.', '1', '9', '7', '4', '8', '6', '3', '2'},
                {'7', '.', '3', '6', '5', '2', '4', '1', '9'},
                {'4', '2', '.', '1', '3', '9', '8', '7', '5'},
                {'3', '5', '7', '.', '8', '6', '2', '4', '1'},
                {'2', '6', '4', '3', '.', '7', '5', '9', '8'},
                {'1', '9', '8', '5', '2', '.', '3', '6', '7'},
                {'9', '7', '5', '8', '6', '3', '.', '2', '4'},
                {'8', '3', '2', '4', '9', '1', '7', '.', '6'},
                {'6', '4', '1', '2', '7', '5', '9', '8', '.'}
        };

        solveSudoku(board1);

        for (char[] a : board1) {
            System.out.println(Arrays.toString(a));
        }
    }

    private static void solveSudoku(char[][] board) {
        if (board == null || board.length == 0) {
            return;
        }
        helper(board);
    }

    private static boolean helper(char[][] board) {
        int index = board.length;
        for (int i = 0; i < index; i++) {
            for (int j = 0; j < index; j++) {
                if (board[i][j] == '.') {
                    for (char ch = '1'; ch <= '9'; ch++) {
                        if (isValidSudoku(board, i, j, ch)) {
                            board[i][j] = ch;
                            if (helper(board)) {
                                return true;
                            } else {
                                board[i][j] = '.';
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean isValidSudoku(char[][] board, int i, int j, char c) {
        int index = board.length;
        for (int row = 0; row < index; row++) {
            if (board[row][j] == c) {
                return false;
            }
        }
        for (int column = 0; column < index; column++) {
            if (board[i][column] == c) {
                return false;
            }
        }
        for (int row = i / 3 * 3; row < i / 3 * 3 + 3; row++) {
            for (int column = j / 3 * 3; column < j / 3 * 3 + 3; column++) {
                if (board[row][column] == c) {
                    return false;
                }
            }
        }
        return true;
    }
}
