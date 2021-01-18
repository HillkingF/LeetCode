package Array;

import java.util.HashMap;

public class Simple_mst_1710 {

    public int majorityElement(int[] nums) {
        /**
         * 使用一个map来计数
         * 其中几种边界情况：
         * 数组中没有元素，返回-1；
         * 数组只有一个元素，返回这个元素
         * 数组中所有的元素都只出现了一次，返回-1
         *
         */
        if(nums.length == 0) return -1;
        if(nums.length == 1) return nums[0];

        // 下面的情况说明数组中至少有两个元素
        HashMap<Integer, Integer> map = new HashMap<>();
        int maxcount = 0;
        int maxkey = -1;
        int count = 0;

        for(int i = 0; i < nums.length; i++){
            // count 用来显示现在的map中这个数字已经出现了几次 + 1；当等于1 时
            // 说明是第一次出现
            count = map.containsKey(nums[i]) ? map.get(nums[i]) + 1 : 1;
            map.put(nums[i], count);
        }
        for(int key: map.keySet()){
            if(map.get(key) > maxcount && map.get(key) > nums.length /2){
                maxcount = map.get(key);
                maxkey = key;

            }
        }
        return maxkey;
    }


    public int majorityElement1(int[] nums) {
        /**
         * 对上面进行优化
         */
        if(nums.length == 0) return -1;
        if(nums.length == 1) return nums[0];

        // 下面的情况说明数组中至少有两个元素
        HashMap<Integer, Integer> map = new HashMap<>();
        int maxcount = 0;
        int maxkey = -1;
        int count = 0;

        for(int i = 0; i < nums.length; i++){
            // count 用来显示现在的map中这个数字已经出现了几次 + 1；当等于1 时
            // 说明是第一次出现
            count = map.containsKey(nums[i]) ? map.get(nums[i]) + 1 : 1;
            if(count > nums.length/2){
                return nums[i];
            }
            map.put(nums[i], count);
        }
        return -1;
    }
}
