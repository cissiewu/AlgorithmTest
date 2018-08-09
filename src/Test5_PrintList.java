import java.util.Stack;

/**
 * Created by cici on 2018/7/25.
 */

/*
* 输入一个链表，从尾到头打印链表每个节点的值
* 思路：借助辅助栈，或者使用递归
* */
public class Test5_PrintList {

    /*
    * 结点对象
    */
    public static class ListNode{
        int val;//结点的值
        ListNode next;//下一个结点
    }

    /**
     * 用栈的方式实现
     * @param root 链表头结点
     */
    public static void printList(ListNode root){
        Stack<ListNode> stack = new Stack<>();
        while (root != null){
            stack.push(root);
            root = root.next;
        }
        ListNode tmp;
        while (!stack.isEmpty()){
            tmp = stack.pop();
            System.out.print(tmp.val + " ");
        }
    }


    /**
     * 使用递归方式实现
     */
    public static void printList2(ListNode root){
        if (root != null){
            printList2(root.next);
            System.out.print(root.val + " ");
        }
    }

    public static void main(String[] args){
        ListNode root = new ListNode();
        root.val = 1;
        root.next = new ListNode();
        root.next.val = 2;
        root.next.next = new ListNode();
        root.next.next.val = 3;

        printList(root);
        System.out.println();
        printList2(root);
    }
}
