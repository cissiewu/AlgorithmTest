import java.util.Stack;

/**
 * Created by cici on 2018/8/16.
 */
public class Test22_StackPutPopOrder {

    /*
    * 输入两个整数序列，第一个序列表示栈的压入顺序，判断两个序列是否为该栈的弹出顺序
    *假设压入栈的所有数字均不相等。如序列1,2,3,4,5是某栈压栈序列，序列4,5,3,2,1是该
    * 压栈序列对应的一个弹出序列，但4,3,5,1，2就不可能是该压栈序列的弹出序列。
     *  */
    public static boolean isPopOrder(int[] push, int[] pop) {
        if (push == null || pop == null || push.length == 0 || pop.length == 0) {
            return false;
        }
        Stack<Integer> stack = new Stack<>();
        int pushIndex = 0;
        int popIndex = 0;
        while (popIndex < pop.length) {
            while (pushIndex < push.length && (stack.isEmpty() || stack.peek() != pop[popIndex])) {
                //入栈数组值的元素入栈
                stack.push(push[pushIndex]);
                pushIndex++;
            }

            //如果在上一步的入栈过程中找到了出栈元素
            if (stack.peek() == pop[popIndex]) {
                stack.pop();
                popIndex++;
            } else {
                return false;
            }
        }
        return true;
    }


    /*
    *
    * */
    public static boolean isPopOrder2(int[] push, int[] pop) {
        boolean isPossible = false;
        if (push != null && pop != null && push.length > 0 && push.length == pop.length) {
            Stack<Integer> stack = new Stack<>();
            int nextPush = 0;
            int nextPop = 0;
            while (nextPop < pop.length) {
                while (stack.isEmpty() || stack.peek() != pop[nextPop]) {
                    if (nextPush >= push.length) {
                        break;
                    }
                    stack.push(push[nextPush]);
                    nextPush++;
                }
                if (stack.peek() != pop[nextPop]) {
                    break;
                }
                stack.pop();
                nextPop++;
            }
            if (stack.isEmpty()) {
                isPossible = true;
            }
        }
        return isPossible;
    }

    public static void main(String[] args) {

        System.out.print("hello world");
    }
}
