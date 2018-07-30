/*
* 写一个函数，输入n，求菲波那切数列的第n项。
* */

public class Fibonacci {

    public static long fibonacci(int n) {

        if (n < 0) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return 1;
        }
        long preOne = 1;
        long pre = 1;
        long cur = 2;
        for (int i = 3; i <= n; i++) {
            cur = pre + preOne;
            preOne = pre;
            pre = cur;
        }
        return cur;

    }

}