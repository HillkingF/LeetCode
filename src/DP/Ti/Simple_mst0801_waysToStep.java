package DP.Ti;

public class Simple_mst0801_waysToStep {
    public int waysToStep(int n) {
        /**
         * 【思路：】
         * 1、最后一步：最后一次上1,2,3前一共有多少种方式
         * 2、子问题：求卖出最后一步时，一共有多少种方式
         * 3、状态：f(n)表示上到第 n阶台阶 一共有多少种方式
         * 4、转移方程：f(n) = f(n-1) + f(n-2) + f(n-3)
         * 5、初始状态：f(0)=1, f(1)=1, f(2)=2, f(3)=4
         * 6、计算顺序：f(0) 到 f(n)
         * 7、边界条件：
         * 8、返回值：f(n)
         * 9、优化：使用一个固定变量记录 f[i-1]即可，懒得优化了
         *
         * 另外分治法没尝试
         */
        if(n <= 2) return n;
        int[] f = new int[n + 1];
        int i;
        f[1] = 1;
        f[2] = 2;
        f[3] = 4;
        int buma = 1000000007;

        for(i = 4; i < n + 1; i++){
            f[i] = (f[i-1] + (f[i-2]+ f[i-3])%buma)%buma;

        }
        return f[n];



    }
}
