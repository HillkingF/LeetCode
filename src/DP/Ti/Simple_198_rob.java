package DP.Ti;

public class Simple_198_rob {
    public int rob(int[] nums) {
        /** 【序列型】
         * 1、最后一步：到最后一个房子时偷窃的最高金额
         * 2、子问题：前n-1个房屋偷窃的最高金额
         * 3、状态：f(n)表示前n-1个房屋偷窃的最高金额,还没有包括第n个的金额
         * 4、转移方程：f(n)=max(f(n-1),f(n-2) + nums[n-1])
         * 5、初始状态：f(0)=0,f(1)=nums[0]
         * 6、边界：
         * 7、计算 f(0),f(1),f(2),.......,f(n).
         * 8、返回f(n)
         */
        if(nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        int[] f = new int[nums.length + 1];
        f[0] = 0;
        f[1] = nums[0];

        for(int i = 2; i < f.length; i++){
            if(f[i-1] > f[i-2] + nums[i-1]){
                f[i] = f[i-1];
            }else{
                f[i] = f[i-2] + nums[i-1];
            }
        }
        return f[nums.length];
    }

    public int rob1(int[] nums) {
        /** 【序列型】
         * 对 rob()的优化
         * 思路都差不多，不过存储使用滚动数组
         */
        if(nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        int[] f = new int[3];
        f[0] = 0;
        f[1] = nums[0];
        int i;
        int i1, i2, i3;

        for(i = 2; i < nums.length + 1; i++){
            i1 = (i-1) % 3;
            i2 = (i-2) % 3;
            i3 = i % 3;
            if(f[i1] > f[i2] + nums[i-1]){
                f[i3] = f[i1];
            }else{
                f[i3] = f[i2] + nums[i-1];
            }
        }
        return f[(i-1)%3];
    }
}
