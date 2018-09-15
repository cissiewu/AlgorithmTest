/**
 * Created by cici on 2018/9/15.
 */
public class Test32_NumOfOne {

    /*
    * 题目：输入一个整数n求从1到n这n个整数的十进制表示中1出现的次数
    * 从数字规律着手明显提高时间效率的解法
    * 21345作为例子来分析。
    * 把1到21345的所有数字分为两段，一段是从1到1345，另一段是从1346到21345.
    * 先看从1346到21345中1出现的次数。1的出现分为两种情况。首先分析出1出现在最高位的情况，从1346到21345的数字中，
    * 1出现在10000~19999这10000个数字的万位中，一共出现了10000个。
    * 但并不是对又有5位数而言在万位出现的次数都是10000个。对于万位是1的数字如输入12345,1只出现在10000~12345的万位，出现的次数是2345+1=2346
    * （除去最高位数字之后剩下的数字再加上1）。在1346~21345这200000个数字中后四位中1出现的次数是20000，由最高位是2，可以再把
    * 1346~21345分成两段，1346~11345和11346~21345.每一段剩下的4位数字中，选择其中一位是1，其余三位可以在0~9这
    * 10个数字中任意选择，因此根据排列组合原则，总共出现的次数是2*10的3次方=2000
    * */

    public static int numberOfOne(int n){
        if(n<=0){
            return 0;
        }
        String value=n+"";
        int[] numbers=new int[value.length()];
        for(int i=0;i<numbers.length;i++){
            numbers[i]=value.charAt(i)-'0';
        }
        return numberOf1(numbers,0);

    }

    private static int numberOf1(int[] numbers, int index) {
        if(numbers==null||index>=numbers.length||index<0){
            return 0;
        }
        int first=numbers[index];
        int length=numbers.length-index;
        if(length==1&&first==0){
            return 0;
        }
        if(length==1&&first>0){
            return 1;
        }
        int numFirstDigit=0;
        if(first>1){
            numFirstDigit=powerBase10(length-1);
        }else if(first==1){
            numFirstDigit=atoi(numbers,index+1)+1;
        }
        int numOtherDigits=first*(length-1)*powerBase10(length-2);
        int numRecursive=numberOf1(numbers,index+1);

        return numFirstDigit+numOtherDigits+numRecursive;
    }
    /*
    * 将数字数组转换成数值
    * */

    private static int atoi(int[] numbers, int index) {
        int result=0;
        for(int j=index;j<numbers.length;j++){
            result=(result*1+numbers[j]);
        }
        return result;
    }
    /*
    * 10的n次方
    * */
    private static int powerBase10(int n) {
        int result=1;
        for(int i=0;i<n;i++){
            result*=10;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(numberOfOne(530));
        System.out.println(numberOfOne(534));
        System.out.println(numberOfOne(514));
        System.out.println(numberOfOne(10));
        System.out.println(numberOfOne(110));
        System.out.println(numberOfOne(504));

    }
}
