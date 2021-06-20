package offer;

import java.util.ArrayList;

public class offer_59_1 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] r = new int[0];
        if(nums.length < k || nums.length == 0) return r;

        // 滑动窗口的起始和结尾的索引
        int start = 0;
        int end = 0;
        // 滑动窗口内的最大值和最大值的索引
        int index = 0;
        int max = Integer.MIN_VALUE;

        ArrayList<Integer> list = new ArrayList<>();
        for(end = 0; end < k; end++){
            if(nums[end] > max){
                max = nums[end];
                index = end;
            }
        }
        list.add(max);

        // 下面从k位置开始，直到数组的最后一个，保持滑动窗口的长度，比较max和index
        for(end = k; end < nums.length; end++){
            // end位置的元素是新窗口的末尾元素
            // 判断end位置的元素是不是最大的
            start ++;
            if(index < start){ // 重新找窗口内的最大值
                max = Integer.MIN_VALUE;
                index = -1;
                for(int i = start; i <= end; i++){
                    if(nums[i] > max){
                        max = nums[i];
                        index = i;
                    }
                }
            }else{ // 只用判断end位置元素和index位置元素的大小
                if(nums[end] > max){
                    max = nums[end];
                    index = end;
                }else{ }
            }
            list.add(max);
        }

        // 返回最终的结果
        int[] res = new int[list.size()];
        for(end = 0; end < list.size(); end++){
            res[end] = list.get(end);
        }
        return res;
    }
}
