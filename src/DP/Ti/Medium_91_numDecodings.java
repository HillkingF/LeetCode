package DP.Ti;

import javax.print.DocFlavor;

public class Medium_91_numDecodings {
    public static void main(String[] args){
        String s= "230";
        int x = numDecodings(s);
        System.out.println(x);


    }
    public static int numDecodings(String s) {
        /**
         * 1、最后一步：解码到最后一步时一共有多少种方式
         * 2、子问题：解码到倒数第二步时一共有多少种方式
         * 3、状态：设f[i]表示以i-1位置的字符作为结尾时，一共有多少种解码方式
         * 4、转移方程：
         *      f[i] = f[i-1] + [i-2],  上一位 和本位 <27 且 >10
         *      f[i] = f[i-1],    上一位 和本位 <10 或 >= 27 且 本位不为0
         *      f[i] = f[i-2],    上一位 和本位 =10 或 =20
         *      f[i] = 0;         上一位 和本位 > 26 且 本位为0
         * 5、初始条件：f[0] = 1 | s[0] > 0
         * 6、边界条件：初始 s=0直接返回0，上一位和本位都是0，直接返回0，方程中的各种约束条件
         * 7、计算：f[0] 到 f[n]
         * 8、返回值：f[n]
         */
        if(s.contains("00")||s.substring(0,1).equals("0"))return 0;
        int len = s.length();
        int[] f = new int[len + 1];
        f[0] = 1;
        f[1] = 1;  // 到索引第1个字符之前，一共有多少种方法：也就是有多少种方法可以编码出第0个字符
        int lb = 0;
        for(int i = 2; i < len + 1; i++){ //从第一个字符开始遍历
            lb = Integer.valueOf(s.substring(i-2,i));

            if(lb == 10 || lb == 20){
                f[i] = f[i-2];
            }else if(lb%10 == 0) {
                f[i] = 0;
            }else if(lb < 27 && lb > 10){
                f[i] = f[i-1] + f[i-2];
            }else if(lb < 10 || lb > 26){
                f[i] = f[i-1];
            }
        }
        return f[len];

    }
}
