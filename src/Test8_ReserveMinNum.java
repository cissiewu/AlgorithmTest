/**
 * Created by cici on 2018/7/29.
 */
/*
* 旋转数组的最小数字
* 把一个数组最开始的若干个元素搬到末尾，我们称之为数组的旋转。
* 输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。
* 如{3，4,5,1,2}是数组{1,2,3,4,5}的一个旋转，该数组的最小值是1
* */
public class Test8_ReserveMinNum {
    /*
    * @param numbers 旋转数组
    * @return 数组的最小值
    * */
    public static int min(int[] numbers){
        //判断输入是否合法
        if(numbers == null || numbers.length == 0){
            throw new RuntimeException("Invaild input.");
        }

        //开始处理的第一个位置
        int l0 = 0;
        //开始后处理的最后一个位置
        int hi = numbers.length - 1;
        //设置初始值
        int mi = l0;
        //确保l0在前一个排好序的部分，hi在排好序的后一个部分
        while(numbers[l0] >= numbers[hi]){
            //当处理范围只有两个数据时，返回后一个结果
            //因为numbers[l0]>=numbers[hi]总成立，后一个结果对应的是最小的值
            if(hi - l0 == 1){
                return numbers[hi];
            }
            //取中间位置
            mi = l0 + (hi - l0)/2;
            //如果三个数都相等，则需要进行顺序处理，从头到尾找最小的值
            if(numbers[mi] == numbers[l0] && numbers[hi]==numbers[mi]){
                return minInorder(numbers,l0,hi);
            }

            //如果中间位置对应的值在前一个排好序的部分，将l0设置为新的处理位置
            if(numbers[mi]>=numbers[l0]){
                l0 = mi;
            }
            //如果中间位置对应的值在后一个排好序的部分，将hi设置为新的处理位置
            else if(numbers[mi]<=numbers[hi]){
                hi = mi;
            }
        }
        //返回最终处理结果
        return numbers[mi];

    }

    /*
    * @param numbers 数组
    * @param start 数组的起始位置
    * @param end 数组的结束位置
    * @return 找到的最小的数
    * */
    private static int minInorder(int[] numbers, int start, int end) {
        int result = numbers[start];
        for (int i=start+1;i<=end;i++){
            if(result>numbers[i]){
                result = numbers[i];
            }
        }
        return result;
    }


    public static void main(String[] args) {

        int[] array = {3,4,5,1,2};
        System.out.print(min(array));
    }
}
