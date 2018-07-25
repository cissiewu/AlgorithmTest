/**
 * Created by cici on 2018/7/25.
 */
/*
* 重建二叉树
*输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。例如：前序遍历序列｛ 1, 2, 4, 7, 3, 5, 6, 8｝
* 和中序遍历序列｛4, 7, 2, 1, 5, 3, 8，6}，重建出下图
*
* */
public class RebuildTree {

    /*
    * 二叉树结点
    * */
    public static class BinaryTreeNode {
        int value;
        BinaryTreeNode left;
        BinaryTreeNode right;
    }

    /*
    * @param preorder 前序遍历
    * @param inorder 中序遍历
    * @return 树的根结点
    * */

    public static BinaryTreeNode rebuildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length != inorder.length || inorder.length < 1)
            return null;
        return rebuildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    /*
    * @param preorder 前序遍历
    * @param ps 前序遍历的开始位置
    * @param pe 前序遍历的结束位置
    * @param inorder 中序遍历
    * @param is 中序遍历的开始位置
    * @param ie 中序遍历的结束位置
    * @return 树的根结点
    * */
    public static BinaryTreeNode rebuildTree(int[] preorder,int ps,int pe,int[] inorder,int is,int ie) {

        //开始位置大于结束位置说明已经没有需要处理的元素了
        if (ps > pe) {
            return null;
        }
        //前序遍历的第一个数字，就是当前的根结点
        int value = preorder[ps];
        int index = is;
        //在中序遍历的数组中找根结点的位置
        while (index <= ie && inorder[index] != value) {
            index++;
        }
        //如果在整个中序遍历的数组中没有找到，说明输入的参数不合法
        if (index > ie) {
            throw new RuntimeException("Invalid input");
        }
        //创建当前的根结点，并且为结点赋值
        BinaryTreeNode node = new BinaryTreeNode();
        node.value = value;
        //递归构建左子树，元素个数：index-is+1
        //左子树对应的前序遍历位置在[ps+1,ps+index-is]
        //右子树对应的中序遍历位置在[is,index-1]
        node.left = rebuildTree(preorder, ps + 1, ps + index - is, inorder, is, index - 1);
        //递归构建右子树，元素个数：ie-index
        //左子树对应的前序遍历位置在[ps+index-is+1,pe]
        //右子树对应的中序遍历位置在[index+1,ie]
        node.right = rebuildTree(preorder, ps + index - is + 1, pe, inorder, index + 1, ie);
        return node;
    }
        //中序遍历二叉树
        public static void printTree(BinaryTreeNode root){
            if(root!=null){
                printTree(root.left);
                System.out.print(root.value+ " ");
                printTree(root.right);
            }
    }

    public static void main(String[] args){
        int[] preorder={1,2,4,5,3,6,7};
        int[] inorder={4,2,5,1,6,3,7};
        BinaryTreeNode root=rebuildTree(preorder,inorder);
        printTree(root);
    }
}
