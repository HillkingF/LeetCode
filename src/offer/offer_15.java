package offer;

import org.omg.PortableInterceptor.ServerRequestInfo;

import java.util.Arrays;

public class offer_15 {
    // java中会自动把 01011 这样的数当成二进制数.
    // 01011 这种0开头的数字,使用String.valueOf(n)转换的结果也不是01011
    // java 0 开头的是八进制数

    // 这道题的关键是记住:
    // 按位与& 的用法. n&1中的1是0000....0001
    // n&1的结果是数字1,不是boolean 1
    // 无符号数右移一位  : n >>>= 1

    public static void main(String[] args) {
        int n =01011;
        int res = hammingWeight(n);

    }
    // you need to treat n as an unsigned value
    public static int hammingWeight(int n) {
        int count = 0;
        int a = 1;   // a实际上也是: 00000....0001
        while(n != 0){  // 这里不能写成 n>0,因为是无符号数
            // 下面进行按位或运算: n&1实际上是n& 000...0001.
            // 其中只有最后一位是1,所以按位&后也只有最后一位是二进制数字1
            // if判断 1==1的结果是个布尔值
            if((n & 1) == 1)
                count ++;
            // 不管n最后一位是0还是1,都要无符号右移一位
            n >>>= 1;
        }
        return count;



    }




}
