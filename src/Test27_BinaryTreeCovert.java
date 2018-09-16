package com.company;

/**
 * Project: AlgorithmTest2
 * Package: com.company
 *
 * @author : cissie
 * @date : 2018/9/14 14:03
 */
public class Test27_BinaryTreeCovert {
    /*
    * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的节点，
    * 只能调整树中节点指针的指向。
    * */
    /*
    * 二叉树的节点
    * */
    public static class BinaryTreeNode {
        int value;
        BinaryTreeNode left;
        BinaryTreeNode right;
    }
    /*
    * @param root 二叉树的根节点
    * @return 双向链表的头结点
    * */
     public static BinaryTreeNode covert(BinaryTreeNode root){
         //用于保存处理过程中的双向链表的尾节点
         BinaryTreeNode[] lastNode = new BinaryTreeNode[1];
         covertNode(root ,lastNode);

         //找到双向链表的头结点
         BinaryTreeNode head = lastNode[0];
         while(head!=null && head.left!=null){
             head=head.left;
         }
         return head;
     }

     /*
     * 链表转换操作
     * @param node 当前的根节点
     * @param lastNode 已经处理好的双向链表的尾节点，使用一个长度为1的数组
     * */
    private static void covertNode(BinaryTreeNode node, BinaryTreeNode[] lastNode) {
        //节点不为空
        if(node !=null){
            //如果有左子树就先处理左子树
            if(node.left!=null){
                covertNode(node.left,lastNode);
            }

            //将当前节点的前驱指向已经处理好的双向链表（由当前节点的左子树构成）的尾节点
            node.left=lastNode[0];

            //如果左子树转换成双向链表不为空，设置尾节点的后继
            if(lastNode[0]!=null){
                lastNode[0].right=node;
            }

            //记录当前节点为尾节点
            lastNode[0]=node;
            //处理右子树
            if(node.right!=null){
                covertNode(node.right,lastNode);
            }
        }
    }
}
