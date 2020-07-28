package Array;

import java.util.Arrays;


/**
 * 类似于15题，还是双指针的做法。看15题的题解就行
 * @param <x>
 */
public class Medium_16_MostClose3Numbers<x> {
    public static void main(String[] args){
        int[] nums = {-1,2,1,-4}; // -4 -1  2 3 6 7
        int target = 1;  // 5
        Solution16 s = new Solution16();
        int x = s.threeSumClosest(nums, target);
        System.out.println(x);
    }


}
class Solution16 {
    public int threeSumClosest(int[] nums, int target) {
        if(nums.length < 3) return 0;
        // 1、将原数组排序
        Arrays.sort(nums);
        // 2、双指针移动
        int one = 0;
        int l = 1;
        int r = nums.length - 1;
        int mostclose = Integer.MAX_VALUE;  // 求差值
        int sum = 0;
        int threesum = 0;
        int len = nums.length;

        for(one = 0; one < len; one++){
            l = one + 1;
            r = len - 1;
            while(l < r){
                threesum = nums[one] + nums[l] + nums[r];
                if(threesum == target){
                    mostclose = 0;
                    sum = threesum;
                    break;}
                else if(Math.abs(threesum - target) < mostclose){
                    mostclose = Math.abs(threesum - target);
                    sum = threesum;
                }
                if(threesum < target) l++;
                else r--;
            }
            if(mostclose == 0) break;
        }
        return sum;
    }
}
