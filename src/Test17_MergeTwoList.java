/**
 * Title: PACKAGE_NAME
 * Description：
 * Date：2018/8/8 18:18
 * Version: 1.0
 * Author: WuXi
 */
class Test17_MergeTwoList {

    /*
    * 输入两个递增排序的链表，合并这两个链表并使新链表中的结点仍然是按照递增排序的
    * */
    public static class ListNode{
        int value;
        ListNode next;
    }

    /*
    * @param head1,head2
    * @return newHead
    * */
    public static ListNode mergeTwoList(ListNode head1, ListNode head2){
        if (head1 ==null && head2!=null)
            return head2;
        if (head1 != null && head2==null)
            return head1;

        ListNode root = new ListNode();
        ListNode pointer=root;

        while(head1!=null && head2!=null){
            if(head1.value<head2.value){
                pointer.next=head1;
                head1=head1.next;
            }else{
                pointer.next=head2;
                head2=head2.next;
            }
            pointer=pointer.next;
        }

        if(head1!=null){
            pointer.next=head1;
        }
        if(head2!=null){
            pointer.next=head2;
        }
        return root.next;
    }
}
