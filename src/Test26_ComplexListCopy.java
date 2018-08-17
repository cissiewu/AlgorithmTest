/**
 * Created by cici on 2018/8/17.
 */
public class Test26_ComplexListCopy {

    public static class ComplexNode {
        int value;
        ComplexNode next;
        ComplexNode sibling;
    }

    public static void CopyNode(ComplexNode head) {
        while (head != null) {
            ComplexNode copyed = new ComplexNode();
            copyed.value = head.value;
            copyed.next = head.next;
            copyed.sibling = head.sibling;
            head.next = copyed;
            head = copyed.next;
        }
    }

    public static void connectSiblingNode(ComplexNode head) {
        while (head != null) {
            ComplexNode copyed = head.next;
            if (copyed.sibling != null) {
                copyed.sibling = head.sibling.next;
            }
            head = copyed.next;
        }
    }

    public static ComplexNode ReConnectNode(ComplexNode head) {
        ComplexNode copyedHead = null;
        ComplexNode copyedNode = null;
        if (head != null) {
            copyedHead = copyedNode = head.next;
            head.next = copyedNode.next;
            head = head.next;
        }
        while (head != null) {
            copyedNode.next = head.next;
            copyedNode = copyedNode.next;
            head.next = copyedNode.next;
            head = head.next;
        }
        return copyedHead;
    }

    public static ComplexNode Clone(ComplexNode head) {
        CopyNode(head);
        connectSiblingNode(head);
        return ReConnectNode(head);
    }

    public static void main(String[] args) {
        System.out.print("hello world");
    }
}
