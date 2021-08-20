package cn.shui.learning_plan.datastruct.fifth;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author shui.
 * @date 2021/8/20.
 * @time 09:26.
 * 有效的数独
 */
public class L36 {

    public static void main(String[] args) {
        L36 test = new L36();
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
        System.out.println(test.isValidSudoku1(board));
    }

    // 未完成的解法
    // 题目理解错了。。。方法在解数独
    public boolean isValidSudoku1(char[][] board) {
        // 行有效
        boolean isValid = isRowValid(board);
        if (!isValid) {
            return false;
        }
        // 列有效
        isValid = isColumnValid(board);
        if (!isValid) {
            return false;
        }
        return isGridValid(board);
    }

    private boolean isRowValid(char[][] board) {
        List<Character> list = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            list.clear();
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    if (list.contains(board[i][j])) {
                        return false;
                    }
                    list.add(board[i][j]);
                    continue;
                }
                for (int k = 0; k < 9; k++) {
                    char ch = (char) ('1' + k);
                    if (list.contains(ch)) {
                        continue;
                    }
                    board[i][j] = ch;
                    list.add(board[i][j]);
                    if (isValidSudoku1(board)) {
                        break;
                    }
                    list.remove(list.size() - 1);
                }
            }
        }
        return true;
    }

    private boolean isColumnValid(char[][] board) {
        List<Character> list = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            list.clear();
            for (int j = 0; j < 9; j++) {
                if (board[j][i] != '.') {
                    if (list.contains(board[j][i])) {
                        return false;
                    }
                    list.add(board[j][i]);
                    continue;
                }
                for (int k = 0; k < 9; k++) {
                    char ch = (char) ('1' + k);
                    if (list.contains(ch)) {
                        continue;
                    }
                    board[j][i] = ch;
                    list.add(board[j][i]);
                    if (isValidSudoku1(board)) {
                        break;
                    }
                    list.remove(list.size() - 1);
                }
            }
        }
        return true;
    }

    private boolean isGridValid(char[][] board) {
        List<Character> list = new ArrayList<>();
        int index = 0;
        while (index < 9) {
            list.clear();
            int startRow = index / 3 * 3, startColumn = index % 3 * 3;
            for (int i = startRow; i < startRow + 3; i++) {
                for (int j = startColumn; j < startColumn + 3; j++) {
                    if (board[i][j] != '.') {
                        if (list.contains(board[i][j])) {
                            return false;
                        }
                        list.add(board[i][j]);
                        continue;
                    }
                    for (int k = 0; k < 9; k++) {
                        char ch = (char) ('1' + k);
                        if (list.contains(ch)) {
                            continue;
                        }
                        board[i][j] = ch;
                        list.add(board[i][j]);
                        if (isValidSudoku1(board)) {
                            break;
                        }
                        list.remove(list.size() - 1);
                    }
                }
            }
            index++;
        }
        return true;
    }

    // 一次迭代
    public boolean isValidSudoku2(char[][] board) {
        // init data
        Map<Integer, Integer>[] rows = new HashMap[9];
        Map<Integer, Integer>[] columns = new HashMap[9];
        Map<Integer, Integer>[] boxes = new HashMap[9];
        for (int i = 0; i < 9; i++) {
            rows[i] = new HashMap<>();
            columns[i] = new HashMap<>();
            boxes[i] = new HashMap<>();
        }
        // validate a board
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char num = board[i][j];
                if (num != '.') {
                    int n = num;
                    int box_index = (i / 3) * 3 + j / 3;

                    // keep the current cell value
                    rows[i].put(n, rows[i].getOrDefault(n, 0) + 1);
                    columns[j].put(n, columns[j].getOrDefault(n, 0) + 1);
                    boxes[box_index].put(n, boxes[box_index].getOrDefault(n, 0) + 1);

                    // check if this value has been already seen before
                    if (rows[i].get(n) > 1 || columns[j].get(n) > 1 || boxes[box_index].get(n) > 1) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
