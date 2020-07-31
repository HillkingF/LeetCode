package Array;

public class Medium_34_StartToFinish {
    public static void main(String[] args){
        Solution34 s = new Solution34();
        int[] nums = {5,7,7,8,8,10};
        int[] nums1 = {1,3};
        int target = 1;
        int[] res = s.searchRange(nums1, target);
        System.out.println(res[0]);
        System.out.println(res[1]);
    }
}

class Solution34 {
    public int[] searchRange(int[] nums, int target) {
        int[] res = {-1, -1};  // 设置初始值
        // 二分查找
        if(nums.length == 0) return res;
        res = midFind(nums, target, 0, nums.length - 1, -1, -1);
        return res;

    }
    public int[] midFind(int[] nums, int target, int start, int finish, int zuo, int you){
        int[] res = {zuo, you};
        if(start == finish || start + 1 == finish){
            if(nums[start] == target && nums[finish] == target){res[0] = start;res[1] = finish;}
            else if(nums[start] == target && nums[finish] != target) {res[0] = res[1] = start; }
            else if(nums[start] != target && nums[finish] == target) {res[0] = res[1] = finish; }
            return res;
        }else {
            int mid = (start + finish) / 2;
            if (nums[mid] < target) res = midFind(nums, target, mid + 1, finish, res[0], res[1]);
            if (nums[mid] > target) res = midFind(nums, target, start, mid, res[0], res[1]);
            if (nums[mid] == target) {
                int[] resr = {-1,-1};
                int[] resl = {-1,-1};
                resr = midFind(nums, target, mid + 1, finish, zuo, mid);
                resl = midFind(nums, target, start, mid, mid, you);
                res[0] = resl[0];
                res[1] = resr[1];
            }
            return res;
        }
    }
}
