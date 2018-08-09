/**
 * Title: PACKAGE_NAME
 * Description：
 * Date：2018/8/7 11:52
 * Version: 1.0
 * Author: WuXi
 */
class Test14_ReorderOddEven {
    /*
    *输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
    *使得所有奇数位于数组的前半部分，所有偶数位予数组的后半部分。
    * @param arr输入的数组
    * */
    /*
    * 思路：维护两个指针，第一个指针初始化时指向数组的第一个数字，它只向后移动：第二个指针初始化时指向数组的最后一个数字，
    * 它只向前移动。在两个指针相遇之前，第一个指针总是位于第二个指针的前面。如果第一个指针指向的数字是偶数，并且第二个指针指向的数字是奇数，我们就交换这两个数字。
    * */
    public static void reorderoddEven(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        //从左向右记录偶数的位置
        int start = 0;
        int end = arr.length - 1;
        while (start < end) {
            //找偶数
            while (start < end && arr[start] % 2 != 0) {
                start++;
            }
            //找奇数
            while (start < end && arr[end] % 2 == 0) {
                end--;
            }
            int tmp = arr[start];
            arr[start] = arr[end];
            arr[end] = tmp;
        }
    }

    //输出数组
    public static void printArr(int[] arr) {
        if (arr != null && arr.length > 0) {
            for (int i : arr) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
