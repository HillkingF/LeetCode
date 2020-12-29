package DP.Ti;

public class Simple_121_maxProfit {
    public int maxProfit(int[] prices) {
        /**
         * 规定：卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
         * 股票问题，可以再看看视频
         * 分析如下：
         * 最后一步：到第i天售出的话可以得到的最大利润是多少。
         * 子问题：求每一天作为售出日时，每一天的利润，最后从所有i天中选一个最大的利润
         * 状态：f(i)表示第i天售出或者没买没卖时的利润
         * 转移方程: f(i) = (  f(i-1) + prices[i]-prices[i-1]  )>0 ?
         *                 f(i-1) + prices[i]-prices[i-1] :
         *                 0
         * 返回值：max( f(0), f(1),....f(n-1)  )
         * 初始状态：f(0)=0;
         * 边界：差值小于0 的时候直接为0； f(i)=0的时候，直接比较跟上一个的结果
         */

        /**
         * 动态规划上面思路的答案
        if(prices.length < 2) return 0;
        int[] f = new int[prices.length];
        f[0] = 0;
        int tmp = 0;
        int mx = 0;
        for(int i = 1; i < f.length; i++){
            tmp = f[i-1] + prices[i] - prices[i-1];
            if(tmp <= 0) f[i] = 0;
            else f[i] = tmp;
            if(f[i] > mx) mx = f[i];
        }
        return mx;

         */

        // 对上面的答案进行优化，使用mx记录最大利润后，每次遍历只使用上一步的结果，
        // 所以不用f数组记录每一步卖出的利润，而只使用lastnum记录上一步卖出的利润就行了
        if(prices.length < 2) return 0;
        int lastnum = 0;
        int tmp;
        int mx = 0;
        for(int i = 1; i < prices.length; i++){
            tmp = lastnum + prices[i] - prices[i-1];
            if(tmp <= 0) lastnum = 0;
            else lastnum = tmp;
            if(lastnum > mx) mx = lastnum;
        }
        return mx;

    }
}
