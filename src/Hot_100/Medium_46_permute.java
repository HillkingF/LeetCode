package Hot_100;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 回溯的典型例题：
 * 回溯算法需要再多看看
 */
public class Medium_46_permute {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int len = nums.length;
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            list.add(nums[i]);
        }

        backseed(len, list, res, 0);
        return res;

    }

    public void backseed(int len, List<Integer> list , List<List<Integer>> res, int loc){
        if(loc == len){  // 说明每一个都遍历到了
            res.add(new ArrayList<Integer>(list));
        }else{
            for(int i = loc; i < len; i++){
                Collections.swap(list, loc, i); // 交换位置维护一个左右两部分的列表
                backseed(len, list, res, loc + 1); // 确定下一个位置的数字
                Collections.swap(list, loc, i); // 撤销交换操作，进行回溯
            }
        }
    }
}
