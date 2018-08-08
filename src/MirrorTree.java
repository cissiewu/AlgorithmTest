/**
 * Title: PACKAGE_NAME
 * Description：
 * Date：2018/8/8 19:06
 * Version: 1.0
 * Author: WuXi
 */
class MirrorTree {
    /*
    * 请完成一个函数，输入一个二叉树，该函数输出它的镜像。
    * 思路：先前序遍历这棵树的每个结点，如果遍历到的结点有子结点，就交换它的两个子结点。当交换完所有非叶子结点的左右子结点之后，就得到了树的镜像。
    * */

    public static class BinarryTreeNode {
        int value;
        BinarryTreeNode left;
        BinarryTreeNode right;
    }

    public static void mirror(BinarryTreeNode node) {
        if (node != null) {
            BinarryTreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;

            mirror(node.left);
            mirror(node.right);
        }
    }
}
