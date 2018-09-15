/**
 * Created by cici on 2018/9/15.
 */
public class Test31_MaxChildArray {

    /*
    * 题目：输入一个整型数组，数组里有正数也有负数。数组中一个或连续多个整数组成一个子数组，求所有子数组的和的最大值。
    * 思路：第一种方法
    * currentSum：当前子数组之和，初始化为0
    * maxSum：最大和，初始化为0
    * 遍历数组并判断currentSum的值，如果小于等于0，则放弃之前的数，从当前遍历的这个元素计算，每次在遍历过后都要跟最大值比较
    * 如果大于最大值就更新最大值的值。
    *
    * */
    public static int FindMaxSumOfArray(int[] numbers){


        if(numbers==null||numbers.length<1){
            System.out.print("Invaild Array");
        }
        int currentSum=0;
        int maxSum=0;
        for(int i=0;i<numbers.length;i++){
            if(currentSum<0){
                currentSum=numbers[i];
            }else{
                currentSum+=numbers[i];
            }
            if(maxSum<currentSum){
                maxSum=currentSum;
            }
        }
         return maxSum;

    }

    /*
    * 方法二：动态规划以第i个元素结尾和最大的连续子数组。假设对于元素i，所有以它前面的元素结尾的子数组的长度都已经求得，那么以
    * 第i个元素结尾和最大的连续子数组，实际上，要么是以第i-1个元素结尾且和最大的连续子数组加上这个元素，要么是只包含第i个元素
    * 即sum[i]=max(sum[i-1]+a[i],a[i]),可以通过判断sum[i-1]+a[i]是否大于a[i]来做选择，而实际上等价于判断sum[i-1]是否大于0.
    * 由于每次运算只需要前一次的结果，因此并不需要像普通的动态规划那样保留之前所有的计算结果，只需要保留上一次的即可。
    * 设sum[i]
    * */

    public static int FindMaxSumOfArrayTwo(int[] numbers){
        int[] arrRes = new int[numbers.length];
        arrRes[0]=numbers[0];
        int start=0,end=0;
        int temp=0;
        int maxSum=-100;
        for(int i=1;i<numbers.length;i++){
            if(arrRes[i-1]<=0){
                arrRes[i]=numbers[i];
                temp=i;
            }else{
                arrRes[i]=numbers[i]+arrRes[i-1];
            }
            if(arrRes[i]>maxSum){
                maxSum=arrRes[i];
                start=temp;
                end=i;
            }
        }

        for(int i=0;i<numbers.length;i++){
            System.out.println(arrRes[i]+" ,");

        }
        System.out.println("最大子序列的位置，start " + start+",end "+  end);
        return maxSum;
    }

    public static void main(String[] args) {
        int arr[]={1,2,3,4,-1,-3};
        System.out.println(FindMaxSumOfArray(arr));
        System.out.println(FindMaxSumOfArrayTwo(arr));
    }
}
