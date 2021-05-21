package offer;

import java.util.HashMap;

public class offer_03 {
    public static void main(String[] args) {

    }
    public int findRepeatNumber(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(map.containsKey(nums[i])) return nums[i];
            else {
                map.put(nums[i], 1);
            }
        }
        return nums[0];
    }
}
