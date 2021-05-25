package offer;

import java.io.StringReader;

public class offer_17 {
    // n表示n位数,所以从1-n遍历,最大数max中一共有几个9
    // 拼接字符串9999...99
    // 将字符串转换成int,就是最终数组元素的个数.然后赋值即可
    public int[] printNumbers(int n) {
        // n表示位数
        String str = "";
        for (int i = 1; i <= n; i++) {
            str = str + "9";
        }
        int max = Integer.parseInt(str);
        int[] res = new int[max];
        for (int i = 0; i < max; i++) {
            res[i] = i + 1;
        }
        return res;
    }
}
