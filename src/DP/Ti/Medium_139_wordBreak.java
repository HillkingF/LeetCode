package DP.Ti;

import java.io.FileOutputStream;
import java.util.List;

public class Medium_139_wordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        /**
         * 【思路】
         * 1、最后一段：最后一段是否在列表中
         * 2、子问题：求最后一段是否在列表中
         * 3、状态：设f[i][j]表示从i开始到j之间的子序列是否可以被拆分，可以true，不可以false
         * 3、状态：设f[i]表示长度为0到i-1的子序列是否可以被拆分
         * 4、方程：f[i] = f[j] && s(j到i)in wordDict | 两个都为真时，结果才为真
         * 5、初始状态: f[0]=true,f[1]表示第0个字符是否在列表中；
         * 其中 j 到 i是最后一段
         * 6、边界条件
         * 7、返回值：f[n]
         */
        Boolean[] f = new Boolean[s.length() + 1];
        f[0] = true;

        for(int i = 1; i <= s.length(); i ++){
            for(int j = 0; j < i; j++){
                f[i] = f[j] && wordDict.contains(s.substring(j,i));
                if(f[i]) break;
            }
        }
        return f[s.length()];
    }
}
