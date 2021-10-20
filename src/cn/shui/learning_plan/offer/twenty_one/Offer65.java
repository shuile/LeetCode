package cn.shui.learning_plan.offer.twenty_one;

/**
 * @author shui.
 * @date 2021/10/20.
 * @time 10:31.
 */
public class Offer65 {

    public static void main(String[] args) {
        int a = 1;
        System.out.println(a);
        a = a << 0;
        System.out.println(a);

        Offer65 test = new Offer65();
        test.add(1, -1);
    }

    public int add(int a, int b) {
        while (b != 0) {
            int c = (a & b) << 1;
            a ^= b;
            b = c;
        }
        return a;
    }
}
