package Array;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Medium_15_SumOfThreeNumbers {
    public static void main(String[] args){
        int[] nums = {-1,0,1,2,-1,-4};
        Solution15 s = new Solution15();
        List<List<Integer>> a = s.threeSum(nums);
        System.out.println(a);



    }
}

/**
 * 三个数都相等，只能是[0,0,0]----这种情况最多只有一组，如果同时出现3个及四个以上的0只有一组
 * 此外最多有两个相同
 */
class Solution15 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList();
        int len = nums.length;
        if (len < 3 || nums == null) return ans;
        Arrays.sort(nums);
        for(int now=0; now < nums.length; now++) {
            if (nums[now] > 0) break; // 小于0结束
            if (now > 0 && nums[now] == nums[now - 1]) continue; //去重
            int lo = now + 1;
            int hi = nums.length - 1;
            while (lo < hi) {
                if (nums[now] + nums[lo] + nums[hi] == 0) {
                    ans.add(Arrays.asList(nums[now], nums[lo], nums[hi]));
                    while (lo < hi && nums[lo] == nums[lo + 1]) {
                        lo++;
                    }
                    while (hi > lo && nums[hi] == nums[hi - 1]) {
                        hi--;
                    }
                    lo++;
                    hi--;
                } else if (nums[now] + nums[lo] + nums[hi] < 0) {
                    lo++;
                } else if (nums[now] + nums[lo] + nums[hi] > 0) {
                    hi--;
                }
            }
        }
        return ans;
    }

}
