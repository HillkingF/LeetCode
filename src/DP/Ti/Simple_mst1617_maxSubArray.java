package DP.Ti;

public class Simple_mst1617_maxSubArray {
    public int maxSubArray(int[] nums) {
        /**
         * 【类型：序列型？】
         * 1、最后一步：若以f[n]作为连续数列的结尾时，最大总和是多少
         * 2、子问题，求nums中从第一个到最后一个数字 作为子数列结尾的总和。最后求其中最大的一个
         * 3、状态：f[n]表示连续数列的结尾时，最大总和是多少
         * 4、方程：f[n] = max(nums[n], f[n-1] + nums[n] | f[n-1] > 0)
         * 5、初始化： f[0] = nums[0]
         * 6、计算：从 f[0] 到 f[n-1]
         * 7、返回 0-(n-1) 中最大的f
         *
         */
        
        if(nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        int len = nums.length;
        int[] f = new int[len];
        f[0] = nums[0];
        int mx = f[0];
        for(int i = 1; i < nums.length; i++){
            if(f[i-1] < 0){
                f[i] = nums[i];
            }else{
                f[i] = f[i-1] + nums[i];
            }
            if(mx < f[i]) mx = f[i];
        }
        return mx;




    }
}
