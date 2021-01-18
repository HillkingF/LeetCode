package Array;

public class Simple_mst_0803 {
    public int findMagicIndex(int[] nums) {
        /**
         * 要求是返回最小的一个魔术索引
         * 给定的是有序数组
         *
         * 思路：
         * 顺序遍历？
         * 有没有更好的思路-----youyouyou
         * 顺序遍历的优化：由于是升序数组，所以当：
         * 数组元素比索引大的时候，直接跳跃到 索引等于元素值的位置
         */
        int j = 0;
        while(j < nums.length){
            if(j == nums[j]) return j;
            else if(nums[j] > j){
                j = nums[j];
            }else{
                j = j + 1;
            }
        }
        return -1;
    }
}
