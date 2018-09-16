package com.company;

/**
 * Project: AlgorithmTest2
 * Package: com.company
 *
 * @author : cissie
 * @date : 2018/9/14 15:10
 */
public class Test28_Permutation {
    /*
    * 输入一个字符串，打印出该字符串中字符的所有排列
    * 如：输入字符串abc，则打印出由字符a，b，c所能排列出来的所有字符串abc，acb，bac，bca，cabcba
    * 解题思路：把字符串看成两部分：第一部分是它的第一个字符，第二部分是它后面的所有字符。
    * 求整个字符串的排列，可以看成两步：首先求所有可能出现在第一个位置的字符，即把第一个字符后面所有的字符交换。
    * 首先固定一个字符，然后求后面所有字符的排列。递归……
    * */
    
    public static void permutation(char[] chars){
        if(chars==null || chars.length<1){
            return ;
        }
        //进行排列操作
        permutation(chars,0);
    }

    private static void permutation(char[] chars, int begin) {
        //如果是最后一个元素了，就输出排列结果
        if(chars.length-1==begin){
            System.out.print(new String(chars)+ " ");
        }else{
            char tmp;
            //对当前还未处理的字符串进行处理，每个字符都可以作为当前处理位置的元素
            for(int i=begin;i<chars.length;i++){
                tmp = chars[begin];
                chars[begin]=chars[i];
                chars[i]=tmp;
                //处理下一个位置
                permutation(chars,begin+1);
                //换回位置
               /* tmp = chars[begin];
                chars[begin]=chars[i];
                chars[i]=tmp;*/
            }
        }
    }

    public static void main(String[] args){
        char[] c1={'a','b','c','d'};
        permutation(c1);
        System.out.println();
    }

}
