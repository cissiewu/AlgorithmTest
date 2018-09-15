/**
 * Created by cici on 2018/9/15.
 */
public class Test33_SortArrayForMinNumber {
    /*
    * 题目：把数组排成最小的数
    * 输入一个正整数数组，把数组里面所有的数字拼接成一个数，打印出能拼接处的所有数字中的一个。
    * 思路：把数字转换成字符串，由于把数字m和n拼接起来得到mn和nm，位数是相同的，因此比较他们的大小只需要按照字符串的
    * 大小比较久行了
    * */
    public void printMin(int[] arr){
        int[] clone=arr.clone();
        printMinNumber(clone,0,clone.length-1);
        for(int i:clone){
            System.out.print(i);
        }
    }

    //核心+快排
    public static void printMinNumber(int[] arr,int left,int right){
        if(left<right){
            int main_num=arr[right];
            int small_cur=left;
            for(int j=left;j<arr.length;j++){
                if(isSmall(String.valueOf(arr[j]),String.valueOf(main_num))){
                    int temp=arr[j];
                    arr[j]=arr[small_cur];
                    arr[small_cur]=temp;
                    small_cur++;
                }
            }

            arr[right]=arr[small_cur];
            arr[small_cur]=main_num;
            printMinNumber(arr,0,small_cur-1);
            printMinNumber(arr,small_cur,right);
        }
    }

    private static boolean isSmall(String m, String n) {
        String left=m+n;
        String right=n+m;
        boolean result=false;
        for(int i=0;i<left.length();i++){
            if(left.charAt(i)<right.charAt(i))
               result=true;
            else if(left.charAt(i)>right.charAt(i))
                result= false;

        }
        return result;
    }

    public static void main(String[] args) {
        int arr[]={3,32,4,321};
        Test33_SortArrayForMinNumber test = new Test33_SortArrayForMinNumber();
        test.printMin(arr);
    }
}
