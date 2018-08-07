import java.util.Stack;

/**
 * Title: PACKAGE_NAME
 * Description：
 * Date：2018/8/7 15:45
 * Version: 1.0
 * Author: WuXi
 */
class ReverseList {
    /*
    * 定义一个函数，输入一个链表的头结点，反转该链表并输出反转后链表的头结点
    * */
    //思路：使用三个指针，一个为当前结点，一个指向当前结点的下一个界定啊，另一个结点指向新链表表头从而保存结果
    public static class ListNode{
        int value;
        ListNode next;
    }

    public static ListNode reverseListOne(ListNode head){

        if(head==null || head.next==null)
            return head;
        ListNode current = head;
        ListNode newHead = null;
        ListNode next = null;
        while(current!= null){
            //将当前节点的下一个保存
            next = current.next;
            //将原来的链表断了，将current的下一个结点指向新链表的头结点
            current.next=newHead;
            newHead = current; //将current设为新表头
            current = next;//将之前保存的next设为下一个结点
        }
        return newHead;
    }

    //递归
    public static void reverseListTwo(ListNode head) {
        if(head == null) {
            return;
        }
        reverseListTwo(head.next);
        System.out.print(head.value + " ");
    }

    //非递归,用栈模拟
    public static void reverseListThree(ListNode head) {
        if(head == null) {
            return;
        }

        Stack<ListNode> stack = new Stack<ListNode>();
        ListNode current = head;

        while(current != null) {
            stack.push(current);
            current = current.next;
        }

        while(!stack.isEmpty()) {
            System.out.print(stack.pop().value + " ");
        }

    }
    public static void main(String[] args){

    }
}
