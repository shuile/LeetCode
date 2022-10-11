package cn.shui.order;

/**
 * Created by chenyiting on 2022/10/11
 * 矩形面积
 */
public class L223 {
    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        int square1 = (ax2 - ax1) * (ay2 - ay1);
        int square2 = (bx2 - bx1) * (by2 - by1);
        if (!isNotIntersect(ax1, ay1, ax2, ay2, bx1, by1, bx2, by2)) {
            int cx1 = Math.max(ax1, bx1);
            int cy1 = Math.max(ay1, by1);
            int cx2 = Math.min(ax2, bx2);
            int cy2 = Math.min(ay2, by2);
            int square3 = (cx2 - cx1) * (cy2 - cy1);
            return square1 + square2 - square3;
        }
        return square1 + square2;
    }

    private boolean isNotIntersect(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        return ay2 <= by1 || ay1 >= by2 || ax1 >= bx2 || ax2 <= bx1;
    }

    // 优化
    private int computeArea2(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        int square1 = (ax2 - ax1) * (ay2 - ay1);
        int square2 = (bx2 - bx1) * (by2 - by1);
        int xSide = Math.max(Math.min(ax2, bx2) - Math.max(ax1, bx1), 0);
        int ySide = Math.max(Math.min(ay2, by2) - Math.max(ay1, by1), 0);
        return square1 + square2 - xSide * ySide;
    }
}
