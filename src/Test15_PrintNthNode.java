import java.util.List;

/**
 * Title: PACKAGE_NAME
 * Description：
 * Date：2018/8/7 14:01
 * Version: 1.0
 * Author: WuXi
 */
class Test15_PrintNthNode {
    /*
    * 输入一个链表，输出该链表中倒数第k个结点。
    * */
    public static class ListNode{
        int value;
        ListNode next;
    }

    /*思路：
    *为了实现只遍历链表一次就能找到倒数第k 个结点，我们可以定义两
    个指针。第一个指针从链表的头指针开始遍历向前走k-1步，第二个指针保持不动；
    从第k 步开始，第二个指针也开始从链表的头指针开始遍历。由于两个指针的距离保持在k-1 ，
    当第一个（走在前面的）指针到达链表的尾结点时，第二个指针（走在后面的）指针正好是倒数第k 个结点。
    * */
    /**
     * @param head 链表的头结点
     * @param k 倒数第k个结点
     * @return 倒数第k个结点
     */
    public static ListNode findKthTail(ListNode head,int k){
        //输入的链表不能为空，并且k大于0
        if(k<1 || head==null)
            return null;
        ListNode pointer = head;
        //倒数第k个阶段与袋鼠第一个结点相隔k-1个位置
        //pointer先走k-1个位置
        for(int i=1;i<k;i++){
            if(pointer.next!=null){
                pointer = pointer.next;
            }else {
                //已经没有结点了，但是i还没到k-1说明k太大了，链表中没有那么多的结点
                return null;
            }
        }
        //pointer还没走到链表末尾，那么pointer和head一起走，当pointwer走到最后一个结点，head就是倒数第k个结点
        while (pointer.next!=null){
            head=head.next;
            pointer=pointer.next;
        }
        return head;
    }
}
