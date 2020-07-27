package Array;

/**
 * 数组--简单--35题
 * 思想：二分查找
 */
public class _35_simple_ForkInsertLocation {
    public static void main(String[] args){
        int[] nums = {1, 3, 5, 6};
        int[] nums1 = {1,3};
        int target = 4;
        Solution35 s = new Solution35();
        int x = s.searchInsert(nums, target);
        System.out.print(x);
    }
}
class Solution35 {
    public int searchInsert(int[] nums, int target) {
        if(target < nums[0]){
            return 0;
        }else if(target > nums[nums.length-1]){
            return nums.length;
        }else return mid(nums, 0, nums.length-1, target);
    }
    public int mid(int[] nums, int start, int finish, int target){  // 递归方法
        int loc = start;
        if(start == finish){
            loc = finish;
        }else if(nums[(start + finish)/2] >= target){
            loc = mid(nums, start, (start + finish)/2, target);
        }else if(nums[(start + finish)/2] < target){
            loc = mid(nums, (start + finish)/2 + 1, finish, target);
        }
        return loc;
    }
}