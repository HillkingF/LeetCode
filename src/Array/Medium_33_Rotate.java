package Array;
 class Mediun_33_Rotate {
    public static void main(String[] args){
        int[] nums = {1};
        int target = 0;
        Solution33 s = new Solution33();
        int c = s.search(nums, target);
        System.out.println(c);

    }
}
class Solution33 {
    /**
     * 【思路】
     * 先二分查找找到断点，然后中断点和target比较，最后再分段二分查找target
     * 要注意几个边界条件
     * 如果nums有0个元素、nums顺序排列、target小于nums[0]且大于nums[nums.length]
     */
    public int search(int[] nums, int target) {
        // target 在断点重点则一定不存在
        int fin = 0;
        if(nums.length == 0) return -1;
        if(nums[0] <= nums[nums.length-1]){  // 顺序排列
            fin = targetloc(nums, 0, nums.length - 1, target);
        }else {
            if (target < nums[0] && target > nums[nums.length - 1]) return -1;
            // 因为时间复杂度是logn,所以用二分查找
            int point = findstop(nums, 0, nums.length - 1);

            if (target <= nums[nums.length - 1]) {
                // 在后半段小的子序中
                fin = targetloc(nums, point, nums.length - 1, target);
            } else if (target > nums[0]) {
                // 在前半段大的子序中
                fin = targetloc(nums, 0, point - 1, target);
            }
        }
        return fin;


    }
    // 找断点
    public int findstop(int[] nums, int start, int end){
        int mid;
        int point = 0;
        if(start == end){
            point = start;
        }else{
            mid = (start + end)/2;
            if (nums[mid] > nums[end]) {
                point = findstop(nums, mid+1, end);
            }else if(nums[mid] < nums[end]){
                point = findstop(nums, start, mid);
            }
        }
        return point;  // 返回的是小的断点

    }
    public int targetloc(int[] nums, int start, int end, int target){
        int loc;
        if(start == end || start + 1 == end) {
            if(nums[start] == target)loc = start;
            else if(nums[end] == target)loc = end;
            else loc = -1;
        } else{
            int mid = (start + end)/2;
            if (nums[mid] > target) {
                loc = targetloc(nums, start, mid, target);
            }else if(nums[mid] < target){
                loc = targetloc(nums, mid + 1, end, target);
            }else loc = mid;
        }
        return loc;  // 返回的是小的断点

    }
}

