/**
 * Title: PACKAGE_NAME
 * Description：
 * Date：2018/8/3 19:14
 * Version: 1.0
 * Author: WuXi
 */
/*
* 请实现一个函数， 输入一个整数，输出该数二进制表示中1的个数。
     * 例如把9表示成二进制是1001 ，有2位是1. 因此如果输入9，该出2。
* */
class Test10_NumberOfOne {
    /*
    * @param n待计算的数字
    * @return 数字中二进制表的1的数目
    * */
    public static int numberOfOne(int n) {
        //记录数字中1的位数
        int result = 0;
        //java中，int整形占四个字节，总计32位
        //对每一个位置与1进行求与操作，再累加就可以求得当前数字的表示是多少为
        for (int i = 0; i < 32; i++) {
            result += (n & 1);
            n >>>= 1;
        }
        return result;
    }

    /**
     * 请实现一个函数， 输入一个整数，输出该数二进制表示中1的个数。
     * 例如把9表示成二进制是1001 ，有2位是1. 因此如果输入9，该出2。
     * 【这种方法的效率更高】
     *
     * @param n 待的数字
     * @return 数字中二进制表表的1的数目
     */
    public static int numberOfOne2(int n) {
        // 记录数字中1的位数
        int result = 0;

        // 数字的二进制表示中有多少个1就进行多少次操作
        while (n != 0) {
            result++;
            // 从最右边的1开始，每一次操作都使n的最右的一个1变成了0，
            // 即使是符号位也会进行操作。
            n = (n - 1) & n;
        }

        // 返回求得的结果
        return result;
    }

}
