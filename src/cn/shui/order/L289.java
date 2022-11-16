package cn.shui.order;

/**
 * Created by chenyiting on 2022/11/16
 * 生命游戏
 */
public class L289 {

    private int[][] ans;

    public void gameOfLife(int[][] board) {
        if (board == null || board.length < 1 || board[0] == null || board[0].length < 1) {
            return;
        }
        int row = board.length, column = board[0].length;
        ans = new int[row][column];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                ans[i][j] = isAlive(board, i, j);
            }
        }
        for (int i = 0; i < row; i++) {
            System.arraycopy(ans[i], 0, board[i], 0, column);
        }
    }

    private int isAlive(int[][] board, int x, int y) {
        int row = board.length, column = board[0].length;
        int one = 0;
        // (x - 1, y - 1)
        if (x > 1 && y > 0) {
            one += board[x - 1][y - 1];
        }
        // (x -1 , y)
        if (x > 0) {
            one += board[x - 1][y];
        }
        // (x - 1, y + 1)
        if (x > 0 && y < column - 1) {
            one += board[x - 1][y + 1];
        }
        // (x, y + 1)
        if (y < column - 1) {
            one += board[x][y + 1];
        }
        // (x + 1, y + 1)
        if (x < row - 1 && y < column - 1) {
            one += board[x + 1][y + 1];
        }
        // (x + 1, y)
        if (x < row - 1) {
            one += board[x + 1][y];
        }
        // (x + 1, y - 1)
        if (x < row - 1 && y > 0) {
            one += board[x + 1][y - 1];
        }
        // (x, y - 1)
        if (y > 0) {
            one += board[x][y - 1];
        }
        if (board[x][y] == 1) {
            return one == 2 || one == 3 ? 1 : 0;
        } else {
            return one == 3 ? 1 : 0;
        }
    }

    // O(n)的空间复杂度
    public void gameOfLife2(int[][] board) {
        int[] neighbors = {0, -1, 1};
        int rows = board.length, columns = board[0].length;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < columns; col++) {
                int liveNeigh = 0;
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        if (i == 0 && j == 0) {
                            continue;
                        }
                        int r = row + neighbors[i];
                        int c = col + neighbors[j];
                        if ((r < rows && r >= 0) && (c < columns && c >= 0) && Math.abs(board[r][c]) == 1) {
                            liveNeigh++;
                        }
                    }
                }
                if (board[row][col] == 1 && (liveNeigh < 2 || liveNeigh > 3)) {
                    board[row][col] = -1;
                }
                if (board[row][col] == 0 && liveNeigh == 3) {
                    board[row][col] = 2;
                }
            }
        }
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < columns; col++) {
                board[row][col] = board[row][col] > 0 ? 1 : 0;
            }
        }
    }
}
