/**
 * Title: PACKAGE_NAME
 * Description：
 * Date：2018/8/6 10:30
 * Version: 1.0
 * Author: WuXi
 */
class Test12_PrintOne2NthDigits {
    /*
    * 输入数字n，按顺序打印出从1到最大n位的十进制数，
    * 如，输入3，打印出1到999
    * */
  //方法1：先找出最大n位数，然后循环打印，int范围不够会溢出
    public static void printOne(int n){
        int number=1;
        int i=0;
        while(i++<n){
            number *=10;
        }
        for(int j=1;j<number;j++){
            System.out.println(j);
        }
    }
    //方法2：用字符串来存储数字
    public static void printTwo(int n){
        if (n<=0){
            return;
        }
        StringBuffer number=new StringBuffer();
        for(int i=0;i<n;i++){
            number.append('0');
        }
        while(!Increment(number)){
            PrintNumber(number);
        }
    }

    private static void PrintNumber(StringBuffer s) {
        boolean isBegining0=true;
        for(int i=0;i<s.length();i++){
            if(isBegining0 && s.charAt(i)!='0'){
                isBegining0=false;
            }
            if(!isBegining0){
                System.out.print(s.charAt(i));
            }
        }
        System.out.println();
    }

    private static boolean Increment(StringBuffer s) {
        boolean isOverflow = false;
        int nTakeOver=0;
        int nLength=s.length();
        for(int i=nLength-1;i>=0;i--){
            int nSum=s.charAt(i)-'0'+nTakeOver;
            if(i==nLength-1){
                nSum++;
            }
            if(nSum>=10){
                if(i==0){
                    isOverflow=true;
                }else{
                    nSum -=10;
                    nTakeOver=1;
                    s.setCharAt(i,(char)('0'+nSum));
                }
            }else{
                s.setCharAt(i,(char)('0'+nSum));
                break;
            }
        }
        return isOverflow;
    }
    public static void main(String[] args){
        printTwo(3);
    }
}
