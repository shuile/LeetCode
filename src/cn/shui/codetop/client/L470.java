package cn.shui.codetop.client;

/**
 * Created by chenyiting on 2022/4/6
 * 用Rand7()实现Rand10()
 */
public class L470 {
    // 拒绝采样
    public int rand10() {
        int row, col, idx;
        do {
            row = rand7();
            col = rand7();
            idx = col + (row - 1) * 7;
        } while (idx > 40);
        return 1 + (idx - 1) % 10;
    }

    private int rand7() {
        return -1;
    }

    public int rand10_2() {
        int first, second;
        while ((first = rand7()) > 6);
        while ((second = rand7()) > 5);
        return (first & 1) == 1 ? second : 5 + second;
    }
}
