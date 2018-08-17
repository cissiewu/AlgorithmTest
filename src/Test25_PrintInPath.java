import java.util.ArrayList;
import java.util.List;

/**
 * Created by cici on 2018/8/16.
 */
public class Test25_PrintInPath {

    /*
    * 输入一棵二叉树和一个整数，打印出二叉树中结点值的和为所输入整数的所有路径。
    * 从树的根结点开始往下直到叶结点所经过的结点形成一条路径。
    * */
    public static class BinaryTreeNode{
        int value;
        BinaryTreeNode left;
        BinaryTreeNode right;
    }
    
    public static void findPath(BinaryTreeNode root,int expectedSum){
        List<Integer> list = new ArrayList<>();
        if(root!=null){
            findPath(root,0,expectedSum,list);
        }
    }

    private static void findPath(BinaryTreeNode root, int curSum, int expectedSum, List<Integer> result) {

        if(root!=null){
            curSum += root.value;
            result.add(root.value);
            if(curSum<expectedSum){
                findPath(root.left,curSum,expectedSum,result);
                findPath(root.right,curSum,expectedSum,result);
            }
            else if(curSum==expectedSum){
                if(root.left==null&&root.right==null){
                    System.out.println(result);
                }
            }
            result.remove(result.size()-1);
        }
    }

    public static void main(String[] args) {
        System.out.print("hello world");
    }
}
