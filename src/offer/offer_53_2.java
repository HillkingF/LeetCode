package offer;

// 使用二分查找的方法,如果 nums[index] > index
public class offer_53_2 {
    public int missingNumber(int[] nums) {

        int res = indexarr(nums, 0, nums.length-1);
        return res;
    }
    public int indexarr(int[] nums, int start, int end){
        int res;
        if(start > end) return -1;
        else if(start == end){
            // .....
        }else{

        }



        if(nums[start] == start && nums[end] == end) return -1;
        if(nums[start] > start) return start-1;

        int mid = (start + end)/ 2;

        if(nums[mid] > mid){  // 在左边继续二分
            int r = indexarr(nums, start, mid -1);
            if(r == -1) res = mid;
            else res = r;
        }else{ //  nums[mid] = mid在右边继续二分
            res = indexarr(nums, mid + 1, end);
        }
        return res;
    }
}
class offer_53_2_test{
    public static void main(String[] args) {
        int[] nums = {0,2};
        offer_53_2 test = new offer_53_2();
        int res = test.missingNumber(nums);
        System.out.println(res);
    }
}