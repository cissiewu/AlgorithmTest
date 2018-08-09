/**
 * Title: PACKAGE_NAME
 * Description：
 * Date：2018/8/3 19:27
 * Version: 1.0
 * Author: WuXi
 */
class Test11_Power {
    /*
    *  实现函数double (double base, int exponent)，求base的exponent次方。
     * 不得使用库函数，同时不需要考虑大数问题。
     * @param base 指次
     * @param exponent 幂
     * @return base的exponent次方
    * */
    public static double powers(double base,int exponent){
        //指数和底数不能同时为0
        if(base==0 && exponent==0){
            throw new RuntimeException("invalid imput.");
        }
        if(exponent==0)
            return 1;
        //求指数的绝对值
        long exp = exponent;
        if(exponent<0){
            exp = -exp;
        }
        //求幂次方
        double result=powerWithUsignedExponent(base,exp);
        //指数是负数，要进行求倒数
        if(exponent<0){
            result=1/result;
        }
        return result;
    }
    /*
    * 求一个数的正整数次幂
    * @param base 指次
    * @param exponent 幂
    * @return 结果
    * */
    private static double powerWithUsignedExponent(double base, long exponent) {
        //如果指数为0，返回1
        if(exponent==0)
        {
            return 1;
        }
        //指数为1，返回底数
        if(exponent==1){
            return base;
        }
        //递归求一半的值
        double result=powerWithUsignedExponent(base,exponent>>1);
        //求最终值，如果是奇数，还要乘以一次底数
        result *=result;
        if(exponent%2!=0){
            result *=base;
        }
        return result;
    }
}
