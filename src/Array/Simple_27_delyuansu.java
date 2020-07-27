package Array;

/**
 * 【27. 移除元素】
 * 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
 * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 */
class _27_delyuansu {
    public static void main(String[] args){
        Solution27 s = new Solution27();
        int[] nums = {3,2,3,3};
        int x = s.removeElement(nums, 3);
        System.out.println(x);
    }

}
class Solution27 {
    public int removeElement(int[] nums, int val) {
        /**
         * 【思路】
         * 双指针
         * i指向下一个需要更改的位置
         * j依次遍历并比较：
         * j遍历到最后一个元素之前，j位置上的元素==给定的需要删除的元素时，j++
         * 当j指向的元素！=给定删除元素时，将此时j位置上的元素赋值给i位置，i位置+1
         */

        if(nums.length < 1  || nums == null){
            return 0;
        }
        int i = 0;
        for(int j = 0; j < nums.length; j++){
            if(nums[j] != val){
                nums[i] = nums[j];
                i = i + 1;
            }
        }
        return i;
    }
}
