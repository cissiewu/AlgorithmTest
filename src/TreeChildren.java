/**
 * Title: PACKAGE_NAME
 * Description：
 * Date：2018/8/9 10:59
 * Version: 1.0
 * Author: WuXi
 */
class TreeChildren {
    /*
    * 输入两颗二叉树A和B，判断B是不是A的子结构
    * 思路： 第一步在树A 中找到和B 的根结点的值一样的结点R， 第二步再判断树A 中以R 为根结点的子树是不是包含和树B 一样的结构。
    *
    * */
    public static class BinaryTreeNode {
        int value;
        BinaryTreeNode left;
        BinaryTreeNode right;
    }

    /**
     * 输入两棵二叉树A和B，判断B是不是A的子结构。
     * 该方法是在A树中找到一个与B树的根节点相等的元素的结点，
     * 从这个相等的结点开始判断树B是不是树A的子结构，如果找到其的一个就返回，
     * 否则直到所有的结点都找完为止。
     *
     * @param root1 树A的根结点
     * @param root2 树B的根结点
     * @return true：树B是树A的子结构，false：树B是不树A的子结构
     */

    public static boolean hasSubTree(BinaryTreeNode root1, BinaryTreeNode root2) {
        if (root1 == root2)
            return true;

        if (root2 == null)
            return true;

        if (root1 == null)
            return false;

        boolean result = false;
        if (root1.value == root2.value)
            result = match(root1, root2);

        if (result)
            return true;

        return hasSubTree(root1.left, root2) || hasSubTree(root1.right, root2);
    }

    /**
     * 从树A根结点root1和树B根结点root2开始，一个一个元素进行判断，判断B是不是A的子结构
     *
     * @param root1 树A开始匹配的根结点
     * @param root2 树B开始匹配的根结点
     * @return 树B是树A的子结构，false：树B是不树A的子结构
     */
    private static boolean match(BinaryTreeNode root1, BinaryTreeNode root2) {

        if (root1 == root2)
            return true;

        if (root2 == null)
            return true;
        if (root1 == null)
            return false;

        if (root1.value == root2.value)
            return match(root1.left, root2.left) && match(root1.right, root2.right);

        return false;
    }

}
