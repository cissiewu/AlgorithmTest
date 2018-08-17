import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by cici on 2018/8/16.
 */
public class Test23_PrintTree {

    /*
    * 从上往下打印出二叉树的每个结点，同层的按照从左往右的顺序打印
    *从上到下打印二叉树的规律：每一次打印一个结点的时候，如果该结点有子结点， 则把该结点的子结点放到一个队列的末尾。
    * 接下来到队列的头部取出最早进入队列的结点，重复前面的打印操作，直至队列中所有的结点都被打印出来为止
    * */
    /*二叉树的树结点*/
    public static class BinaryTreeNode{
        int value;
        BinaryTreeNode left;
        BinaryTreeNode right;
    }
    public static void printTreeNode(BinaryTreeNode root){
        if(root!=null){
            Queue<BinaryTreeNode> list = new LinkedList<>();
            list.add(root);
            BinaryTreeNode curNode;

            while(!list.isEmpty()){
                curNode = list.remove();
                System.out.print(curNode.value+" ");

                if(curNode.left!=null){
                    list.add(curNode.left);
                }
                if(curNode.right!=null){
                    list.add(curNode.right);
                }
            }
        }
    }
    public static void main(String[] args) {


        BinaryTreeNode root = new BinaryTreeNode();
        root.value = 8;
        root.left = new BinaryTreeNode();
        root.left.value = 6;
        root.left.left = new BinaryTreeNode();
        root.left.left.value = 5;
        root.left.right = new BinaryTreeNode();
        root.left.right.value = 7;
        root.right = new BinaryTreeNode();
        root.right.value = 10;
        root.right.left = new BinaryTreeNode();
        root.right.left.value = 9;
        root.right.right = new BinaryTreeNode();
        root.right.right.value = 11;
        printTreeNode(root);
    }
}
