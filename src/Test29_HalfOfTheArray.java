package com.company;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Project: AlgorithmTest2
 * Package: com.company
 *
 * @author : cissie
 * @date : 2018/9/14 14:35
 */
public class Test29_HalfOfTheArray {
    /*
    * 数组中有一个数字出现次数超过数组长度的一半，请找出这个数字
    * 思路一：基于partition函数的o(n)算法：排序后位于中间的数字就是中位数
    * 思路二：根据数组特点找出o(n)的算法：这个数字出现的次数比所有数字出现的次数还要多
    * 数组中有一个数字出现的次数超过数组长度的一半，也就是说它出现的次数比其他所有数字出现次数的和还要多。因此我们可以考虑在遍历数组的时候保存两个值：
    * 一个是数组中的一个数字， 一个是次数。当我们遍历到下～个数字的时候，
    * 如果下一个数字和我们之前保存的数字相同，则次数加l ：
    * 如果下一个数字和我们之前保存的数字，不同，则次数减1 。
    * 如果次数为霉，我们需要保存下一个数字，并把次数设为1 。
    * 由于我们要找的数字出现的次数比其他所有数字出现的次数之和还要多，
    * 那么要找的数字肯定是最后一次把次数设为1 时对应的数字
    * */

    //方法一
    public static int moreThanHalfNumOne(int[] num){
        if(num ==null || num.length<1){
            throw new IllegalArgumentException("array length must larger than 0");
        }
        Arrays.sort(num);
        int result = num[num.length/2];

        return result;
    }

    //方法二
    public static int moreThanHalfNum(int[] num){
        if(num ==null || num.length<1){
            throw new IllegalArgumentException("array length must larger than 0");
        }
        //用于记录出现次数大于数组一半的数
        int result=num[0];
        //用于当前记录的数不同的数的个数
        int count=1;
        for (int i=1;i<num.length;i++){
            if(count==0){
                result=num[i];
                count=1;
            }else if(result==num[i]){
                count++;
            }else{
                count--;
            }
        }
        count =0;
        for(int n:num){
            if(result==n){
                count++;
            }
        }
        if(count>num.length/2){
            return result;
        }else{
            throw new IllegalArgumentException("invalid input");
        }

    }
    public static void main(String[] args) {
        // 存在出现次数超过数组长度一半的数字
        int numbers[] = {1, 2, 3, 2, 2, 2, 5, 4, 2};
        System.out.println(moreThanHalfNumOne(numbers));
        int numbers3[] = {1, 3, 4, 5, 2, 2, 2, 2, 2};
        System.out.println(moreThanHalfNumOne(numbers3));
       /* // 出现次数超过数组长度一半的数字都出现在数组的前半部分
        int numbers2[] = {2, 2, 2, 2, 2, 1, 3, 4, 5};
        System.out.println(moreThanHalfNum(numbers2));

        // 出现次数超过数组长度一半的数字都出现在数组的后半部分
        int numbers3[] = {1, 3, 4, 5, 2, 2, 2, 2, 2};
        System.out.println(moreThanHalfNum(numbers3));

        // 只有一个数
        int numbers4[] = {1};
        System.out.println(moreThanHalfNum(numbers4));

        // 输入空指针
        moreThanHalfNum(null);
        // 不存在出现次数超过数组长度一半的数字
        int numbers5[] = {1, 2, 3, 2, 4, 2, 5, 2, 3};
        moreThanHalfNum(numbers5);*/
    }

}
