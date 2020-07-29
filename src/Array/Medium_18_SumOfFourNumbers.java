package Array;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Medium_18_SumOfFourNumbers {
    public static void main(String[] args){
        int[] nums = {1, 0, -1, 0, -2, 2};
    }
}

class Solution18 {
    /**
     * 整体思路类似于第15题
     * 使用双指针的解法，多一层循环
     */
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);  //1、排序 {-2,-1,0,0,1,2}
        List<Integer> inlist = new ArrayList<>();
        List<List<Integer>> outlist = new ArrayList<>();
        if(nums.length < 4) return outlist;

        // 至少四个数，已经排完序

        // 过程省略

        //最后
        return outlist;


    }
}
