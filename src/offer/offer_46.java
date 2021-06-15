package offer;

import java.util.Arrays;

public class offer_46 {
    public int translateNum(int num) {
        /** 动态规划: 0-26
        设 f[i] 表示到 第i位时一共有f[i]种组合
         f[i] = f[i-1]|i位单字翻译 + f[i-2]|前两位组合翻译且这两位在0-25之间
         **/
        String snum = String.valueOf(num);

        int[] f = new int[snum.length() + 1];
        f[0] = 1;
        f[1] = 1;// 表示第1位之前一共有多少种组合方法.也就是第0位只有1种方法
        for(int i = 1; i < snum.length(); i++){
            f[i + 1] = f[i];
            //
            if(10 <= Integer.valueOf(snum.substring(i - 1, i + 1)) &&
                    Integer.valueOf(snum.substring(i - 1, i + 1)) <= 25){
                f[i + 1] = f[i] + f[i - 1];
            }
        }
        return f[snum.length()];

    }
}
class test_46{
    public static void main(String[] args) {
        offer_46 test = new offer_46();
        int x = test.translateNum(12258);
        System.out.println(x);
    }
}
