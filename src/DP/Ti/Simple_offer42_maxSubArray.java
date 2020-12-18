package DP.Ti;

public class Simple_offer42_maxSubArray {
    public int maxSubArray(int[] nums) {

        /**
         * 分析：
         * 最后一步：以最后一个数字结尾时，得到的连续子数组和是多少
         * 子问题：求数组中，以每一个位置上数结尾时，每一个位置为止的子数组和，然后求所有位置中的最大结果
         * 状态：设f[n] 为以n为子数组最后一个值时的子数组和
         * 转移方程：f[n] = (nums[n] | 其中 f[n-1] < 0) || (f[n-1] + nums[n] | 其中 f[n-1] > 0)
         * 对转移方程的解释：若前n-1位置结尾的子数组和 < 0，说明没有继续相加的意义，直接以n位置的值作为以n位置结尾的子数组的和；
         * 不然n位置的值加 上 n-1位置结尾的子数组和 就比n位置的值更小了；
         * 初始条件：f[0] = nums[0]   边界条件：无
         */
        if(nums.length == 0) return 0;
        int len = nums.length;
        int[] f = new int[len];
        f[0] = nums[0];
        int max = f[0];
        for(int i = 1; i < len; i++){
            if(f[i-1] < 0){
                f[i] = f[i - 1] + nums[i];
            }else{
                f[i] = nums[i];
            }
            if(f[i] > max) max = f[i];
        }
        return max;

    }
}
