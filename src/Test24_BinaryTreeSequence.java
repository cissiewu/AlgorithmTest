/**
 * Created by cici on 2018/8/16.
 */
public class Test24_BinaryTreeSequence {


    /*
    * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
    * 如果是则返回true。否则返回false。假设输入的数组的任意两个数字都互不相同
    * 思路：
    * 在后序遍历得到的序列中， 最后一个数字是树的根结点的值。数组中前面的数字可以分为两部分：
    * 第一部分是左子树结点的值，它们都比根结点的值小： 第二部分是右子树结点的值，它们都比根结点的值大
    * */

    public static boolean verifySequenceOfBST(int[] sequence) {
        if (sequence == null || sequence.length <= 0) {
            return false;
        }
        return verifySequenceOfBST(sequence, 0, sequence.length - 1);
    }

    private static boolean verifySequenceOfBST(int[] sequence, int start, int end) {
        if (start >= end) {
            return true;
        }
        int index = start;
        while (index < end - 1 && sequence[index] < sequence[end]) {
            index++;
        }
        int right = index;
        while (index < end - 1 && sequence[index] > sequence[end]) {
            index++;
        }

        if (index != end - 1) {
            return false;
        }
        index = right;
        return verifySequenceOfBST(sequence, start, index - 1) && verifySequenceOfBST(sequence, index, end - 1);
    }


    public static void main(String[] args) {
        System.out.print("hello world");
    }
}
