package Hot_100;

import java.util.HashMap;

public class Hard_128_longestConsecutive {
    public static void main(String[] args) {
        int[] nums = {100, 4, 200, 1, 3, 2};
        int res = longestConsecutive(nums);
        System.out.println(res);
    }


    /*思路：
    由于最长序列中每一个数字前后最多只有一个相邻的数字。因此：
    第一次遍历：将数组表示成一个有向图
    第二次遍历：从任意一个节点开始计算路径，比较几条路径中最大的一条。
    将遍历到的节点的值设置成null表示已经遍历过了
    另外设置一个lenmap表示有可能成为最长路径的第一个节点对应的整个路径的长度
    * */
    public static int longestConsecutive(int[] nums) {
        HashMap<Integer, Integer> g = new HashMap<>();
        // 定义一个map用来存储每次作为头节点开始的路径长度
        HashMap<Integer, Integer> lenmap = new HashMap<>();

        for (int j = 0; j < 2; j++) {
            for (int i = 0; i < nums.length; i++) {
                g.put(nums[i], g.getOrDefault(nums[i], null));
                lenmap.put(nums[i], 1);
                if(g.containsKey(nums[i] - 1)){
                    g.put(nums[i]-1, nums[i]);
                }
            }
        }

        // 下面遍历HashMap，计算最长路径
        int maxpath = 0;
        int count,last, nextkey= 0;
        for (int key: g.keySet()){
            count = lenmap.get(key);  // 当前作为开始节点的个数为1，就是初始化的路径长度
            nextkey = key;
            while(g.get(nextkey) != null){  // 说明当前节点有子节点
                last = nextkey;
                nextkey = g.get(nextkey);
                g.put(last, null);
                if(lenmap.get(nextkey) == 1)  count ++;
                else count += lenmap.get(nextkey);
            }
            if(count > maxpath) maxpath = count;
            lenmap.put(key, count);
        }
        return maxpath;
    }
}
