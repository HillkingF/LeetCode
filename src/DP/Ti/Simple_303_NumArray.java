package DP.Ti;

import java.util.HashMap;

class Simple_303_NumArray {
    private int[] sum;
    public Simple_303_NumArray(int[] nums) {
        sum = new int[nums.length + 1];
        sum[0] = 0;
        for(int i = 0; i< nums.length; i++){
            sum[i+1] = sum[i] + nums[i];
        }
    }

    public int sumRange(int i, int j) {
        return sum[j + 1] - sum[i];
    }
}
