/**
 * Title: PACKAGE_NAME
 * Description：
 * Date：2018/8/9 14:23
 * Version: 1.0
 * Author: WuXi
 */
class Test20_PrintMatrix {

    /*
    * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数
    字，例如，如果输入如下矩阵：
    1 2 3 4
    5 6 7 8
    9 10 11 12
    13 14 15 16
    则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
    * */
    //打印矩阵函数，通过递归调用来循环打印出矩阵的每一圈
    public void printMatrixClock(int[][] numbers, int cols, int rows) {
        System.out.println("顺时针打印的矩阵为：");
        if (numbers == null || cols <= 0 || rows <= 0)
            return;
        int start = 0;
        while (cols > start * 2 && rows > start * 2) {
            printMatrixInCircle(numbers, cols, rows, start);
            ++start;
        }
    }
    //打印矩阵每一圈函数
    private void printMatrixInCircle(int[][] numbers, int cols, int rows, int start) {
        int endX = cols - 1 - start;
        int endY = rows - 1 - start;
        for (int i = start; i <= endX; ++i) {
            int number = numbers[start][i];
            printNumber(number);
        }

        if (start < endY) {
            for (int i = start + 1; i < endY; ++i) {
                int number = numbers[i][endX];
                printNumber(number);
            }
        }

        if (start < endX && start < endY) {
            for (int i = endX - 1; i >= start; --i) {
                int number = numbers[endY][i];
                printNumber(number);
            }
        }

        if (start < endX && start < endY - 1) {
            for (int i = endY - 1; i >= start + 1; --i) {
                int number = numbers[i][start];
                printNumber(number);
            }
        }

    }

    private void printNumber(int number) {
        System.out.print(number + ",");
    }

}
