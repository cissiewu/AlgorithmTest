/**
 * Title: PACKAGE_NAME
 * Description：
 * Date：2018/7/25 13:24
 * Version: 1.0
 * Author: WuXi
 */
/*
* 题目：请实现一个函数，把字符串中的每个空格替换成"%20"，例如“We are happy.”，则输出“We%20are%20happy.”
* */



class ReplaceSpace {

    /*

     * 时间复杂度为O(n)的解法：利用数组从后向前替换
     * 1、先遍历一次字符串，统计出要替换的字符的个数
     * 2、创建新的临时数组，数组长度为初始字符串字符个数+替换每个字符多出来的字符个数*要替换的字符个数
     * 3、从原来字符串数组后面开始向前进行复制、替换到临时数组。两个数组下标变量分别为原始字符数组长度-1，临时数组长度-1
     * 4、原始字符数组的字符如果不为空格，则把这个字符复制到临时数组的对应位置，两个数组下标都减1
     * 5、原始字符数组的字符如果为空格，则把临时数组相对应的位置从后向前依次写入替换的字符，临时数组下标减少相应的替换的字符数量
     * 6、循环复制替换，直到初始数组的下标小于0，此时替换完毕，临时数组转换成字符串后返回
  */
    /*
    * @param string 要转换的字符数组
    *
    * */
    public static String replaceSpace(char[] string) {
        if (string == null) {
            return null;
        }
        int originLength = string.length;
        int spaceCount = 0;
        for (int i=1;i<originLength;i++){
            if(string[i]==' ')
                spaceCount++;
        }
        int newLength=originLength+2*spaceCount;
        char[] temp=new char[newLength];
        int i=originLength-1;
        int j=newLength-1;
        while (i>=0){
            if (string[i]==' '){
                temp[j]='0';
                temp[j-1]='2';
                temp[j-2]='%';
                j=j-3;
            }
            else{
                temp[j]=string[i];
                j=j-1;
            }
            i=i-1;
        }
        return new String(temp);
    }

    /*
    *
    * 时间负责度为O(n)，利用stringBuffer实现
    * 通过indexof（string str,fromIndex）方法和subSequence(int start,int end)方法联合实现
    * */

    public static String replaceSpace2(StringBuffer str){
        if (str == null)
            return null;
        int fromIndex = 0;
        int index = 0;
        StringBuffer temp = new StringBuffer();
        while(index<=str.length()){
            index = str.indexOf(" ",fromIndex);
            if (index>=0){
                temp.append(str.subSequence(fromIndex,index)).append("%20");
                index=index+1;
                fromIndex=index;
            }else{
                temp.append(str.substring(fromIndex,str.length()));
                break;
            }
        }
        return temp.toString();

    }

    public static void main(String[] args){
        String string1="we are happy";
        String string2="we  are happy";
        System.out.println(replaceSpace(string1.toCharArray()));
        System.out.println(replaceSpace2(new StringBuffer(string2)));
    }

}
