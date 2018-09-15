/**
 * Created by cici on 2018/9/15.
 */
public class Test34_UglyNumber {

    /*
    * 题目：把只包含因子2,3和5的数称作丑数，求从小到大的顺序的第1500个丑数
    * 思路：创建一个数组，里面的数字是排好序的丑数，每一个丑数都是前面的丑数乘以2,3或5得到
    * 已有的丑数是按顺序存放在数组中，对乘以2而言，肯定存在某一个丑数T2，排在它之前的每一个丑数乘以2得到的结果都会小于
    * 已有的最大的丑数，在它之后的每一丑数乘以2的结果都会太大，我们只需要记下这个丑数的位置，同时每次生成新的丑数时
    * 去更新这个T2，对乘以3,5而言，也存在这一的T3，T5
    * */
    /*
    * 判断一个数是否只有2,3,5因子
    * */
    private static boolean isUgly(int num) {
        while (num % 2 == 0) {
            num /= 2;
        }
        while (num % 3 == 0) {
            num /= 3;
        }
        while (num % 5 == 0) {
            num /= 5;
        }
        return num == 1;
    }

    public static int getUglyNumber(int index) {
        if (index < 0) {
            return 0;
        }
        int num = 0;
        int uglyfound = 0;
        while (uglyfound < index) {
            num++;
            if (isUgly(num)) {
                ++uglyfound;
            }
        }
        return num;
    }

    public static int getUglyNumberTwo(int index) {
        if (index < 0) {
            return 0;
        }

        int[] pUglyNumbers = new int[index];
        pUglyNumbers[0] = 1;
        int nextUglyIndex = 1;
        int p2 = 0;
        int p3 = 0;
        int p5 = 0;

        while (nextUglyIndex < index) {
            int min = minNumber(pUglyNumbers[p2] * 2, pUglyNumbers[p3] * 3, pUglyNumbers[p5] * 5);
            pUglyNumbers[nextUglyIndex] = min;

            while (pUglyNumbers[p2] * 2 <= pUglyNumbers[nextUglyIndex]) {
                p2++;
            }
            while (pUglyNumbers[p3] * 3 <= pUglyNumbers[nextUglyIndex]) {
                p3++;
            }
            while (pUglyNumbers[p5] * 5 <= pUglyNumbers[nextUglyIndex]) {
                p5++;
            }
            nextUglyIndex++;
        }
        return pUglyNumbers[nextUglyIndex - 1];
    }

    private static int minNumber(int n1, int n2, int n3) {
        int min = n1 < n2 ? n1 : n2;
        return min < n3 ? min : n3;
    }

    public static void main(String[] args) {

        System.out.println(getUglyNumber(10));
        System.out.println(getUglyNumberTwo(1500));

        System.out.print("hello world");
    }
}
