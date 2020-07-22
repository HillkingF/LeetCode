package Array;

/**
 * [53. 最大子序和]
 * [思路1：动态规划]
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * 例如，如果数组中有负数，所有元素的和不一定是最大的，子数组的和可能是最大的
 *
 * [思路2：分治法]
 * 没看
 *
 */
public class _53_simple_MaxKidSeqSum {
    public static void main(String[] args){
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        Solution53 s = new Solution53();
        int res = s.maxSubArray(nums);
        System.out.println(res);
    }
}
class Solution53 {
    public int maxSubArray(int[] nums) {
        /**
         * 方法1： 动态规划法
         * 思路：
         * 设 过程移动的和是sum，其中sum[i]是每一个位置上可以累加的结果
         * 设 每一轮中的最大和是res
         * ①初始化：sum 和 res 都指向nums[0]
         * ②从nums[1]开始逐个向后遍历：
         * 如果前一个位置i-1上的sum累加和小于0,则sum=nums[i],重新开始找子序列（<0说明是减弱效果）；否则，sum= sum+nums[i]；
         * ③比较nums[i]位置上的sum和res大小：res>=sum,则res不变；否则res = max
         * 综上：sum的移动过程就是一个子序列的寻找过程，当前一个位置上的sum<0就说明：到前一个位置时效果减弱，直接舍弃并开始考虑下一个元素
         */
        if (nums.length == 0){
            return 0;
        }else if(nums.length == 1){
            return nums[0];
        }else{
            int sum = nums[0];
            int res = nums[0];
            for (int i = 1; i < nums.length ; i++) {
                if (sum < 0){
                    sum = nums[i];
                }else{
                    sum = sum + nums[i];
                }
                if (sum > res){
                    res = sum;
                }

            }
            return res;
        }



    }
}
