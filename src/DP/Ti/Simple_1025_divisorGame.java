package DP.Ti;


public class Simple_1025_divisorGame {
    public boolean divisorGame(int N) {
        /**
         * 【类型：博弈】
         * 博弈类型是唯一一个从第一步开始分析的类型（不太懂，再理解一下）
         * 分析：爱丽丝先手选择一个x, 剩下的N-x类似于 原来的N个数字
         *
         * 1、最后一步：面对当前的N，若是1，则当前的先手失败
         * 2、子问题：
         *    当前该爱丽丝时，若n=1，alice必败；n=2，alice必胜；n=3,alice必败；
         *    n=4,alice不一定
         * 3、状态：设 f(n) 表示面对当前的数字n，爱丽丝是否获胜（true/false）
         * 4、转移方程：f(n) = f(n-x)==false? true: false
         * 5、初始化： f(1)=false; f(2)=True;
         * 6、边界条件：
         * 7、计算顺序：
         * 8、返回值：
         * 9、优化：
         * 10、时间复杂度和空间复杂度
         *
         */
        if(N < 2) return false;
        if(N == 2) return true;

        boolean[] f = new boolean[N + 1];
        f[0] = false;
        f[1] = false;
        f[2] = true;

        for(int i = 3; i < N + 1; i++){
            f[i] = false;
            for(int j = 1; j < i; j ++){
                if(i % j == 0 && !f[i-j]){  // 精华：当n-x有一个是false时，说明alice可以选择这个x，则下一个人下一步必败，alice必胜
                    f[i] = true;
                }
            }
        }
        return f[N];
    }
}
