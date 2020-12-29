package DP.Ti;

public class Simple_746_minCostClimbingStairs {
    public int minCostClimbingStairs(int[] cost) {
        /**
         * 【类型:序列型】
         * 1、最后一步：到达顶层（cost最后一个位置的下一个位置）的最小花费
         * 2、子问题：到达楼梯最高一阶的最小花费
         * 3、状态：f[n]表示到达第n层的最小花费
         * 4、转移方程：f(n) = min( f(n-1) + cost[n-1], f(n-2) + cost[n-2])
         * 5、初始状态：f[0]=0,表示从第0阶开始； f[1]=0
         * 6、边界条件：
         * 7、计算顺序：f[0],f[1],....,f[n]
         * 8、返回值: f[n]
         * 9、优化：使用滚动数组
         */
        if(cost.length <= 1)return 0;
        int[] f = new int[cost.length + 1];
        f[0] = 0; //到达cost[0]层的最小花费0,可以从实际的0层开始直接到cost[0]
        f[1] = 0; //到达cost[1]层的最小花费0,可以从实际的0层开始直接到cost[1]
        int i;

        for(i = 2; i < f.length; i++){
            if(f[i-1]+cost[i-1] < f[i-2] + cost[i-2]){
                f[i] = f[i-1]+cost[i-1];
            }else{
                f[i] = f[i-2] + cost[i-2];
            }
        }
        return f[i-1];



    }
}
