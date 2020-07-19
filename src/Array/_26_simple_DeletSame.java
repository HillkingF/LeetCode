package Array;

/**
 * 【26. 删除排序数组中的重复项】
 * 给定一个排序数组，你需要在 原地 删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 */
public class _26_simple_DeletSame {
    /**
     * 【思路】
     * 双指针
     * 排序数组的元素顺序已知，假设从小到大
     * 不使用额外的数组空间，原地修改数组
     * 创造两个指针i,j
     * 初始：i,j都在0位置
     * 首先依次+1移动j，将j位置的元素与i位置比较，如果一样j+1,如果j不一样，令nums[j]赋值到i下一个位置
     * i = i+1
     */
    public static void main(String[] args){
        Solution sobj = new Solution();
        int[] nums = {1,1,2};
        int[] nums1 = {};
        int[] nums2 = {0,0,0,1,1,2,3};
        int i = sobj.removeDuplicates(nums);
        System.out.println(i);

    }

}
class Solution{
    public int removeDuplicates(int[] nums) {
        int i = 0;
        if (nums.length < 2){
            return nums.length;
        }
        for(int num: nums){
            if (num != nums[i]){
                nums[i+1] = num;
                i = i+1;
            }
        }
        return i+1;

//        for (int j=1; j<nums.length; j++){
//            if(nums[j] != nums[i]){
//                nums[i + 1] = nums[j];
//                i += 1;
//            }
//        }
//        return i + 1;




    }
}

