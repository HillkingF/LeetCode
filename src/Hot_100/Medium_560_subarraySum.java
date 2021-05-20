package Hot_100;

import java.util.HashMap;

public class Medium_560_subarraySum {
    public int subarraySum(int[] nums, int k) {
        // 设置一个可变大小的滑动窗口，每一次都计算滑动滑动窗口中元素的和：
        // 当元素和小于k的时候，就要向右增大滑动窗口
        // 当元素和大于k的时候，就要从左边收缩滑动窗口

        // 因此这是动态规划的思想：

        // 第一种情况：如果所有的数组元素都是正数，使用下面的策略
        // 定义i,j,d[]：i表示窗口的左边界限、j表示窗口的右边界限（也是每一次遍历的索引位置）
        // d表示以j位置为连续子数组最后一个元素时，窗口内的元素和，d[j]==k时，个数+1
        // 其实可以d，直接计算结果就行

        // 第二种情况：如果数组元素有负数，就只能用下面二维数组的思路来计算了
        // 定义f[i][j]表示i-j位置的元素和，每当f为k时，就计数
        // 优化，使用变量last表示上一个和，使用now表示此时的和

        // 下面的代码是第二种情况有负数存在的情况。结果正确，但是会超出时间空间限制
        if(nums==null || nums.length == 0) return 0;
        int count = 0;
        int last = 0;
        int now = 0;
        int[][] f = new int[nums.length][nums.length];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                if(i == j) {
                    last = nums[i];
                    now = nums[i];
                }else{
                    now = last + nums[j];
                    last = now;
                }
                if(now == k) count ++;
            }
        }
        return count;

    }


    public int subarraySum2(int[] nums, int k) {
        // 下面也是动态规划--使用空间换时间--每次遍历计算0-j的和，保存在hashmap中
        // 则若存在map[x]-k = map[j]中的map[j],则说明此时的和就是k

        // map中key依次表示遍历到i位置时0-i的和，value表示
        // last表示i-1位置的0-》i-1的和，now表示0-i位置的和
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0,1);
        int count = 0; int last = 0;
        int now = 0;
        for (int i = 0; i < nums.length; i++) {
            now = last + nums[i];
            last = now;
            if(map.containsKey(now - k)){
                count = count + map.get(now - k);
            }
            map.put(now, map.getOrDefault(now,0) + 1);
        }
        return count;


    }
}
