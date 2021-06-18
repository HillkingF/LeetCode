package offer;

import java.util.HashMap;

public class offer_57 {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer>  map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        int a, b;
        for (int i = 0; i < nums.length; i++) {
            a = nums[i];
            b = target - a;
            if(a == b){
                if(map.containsKey(a) && map.get(a) >= 2) return new int[]{a,b};
            }else{
                if(map.containsKey(b)) return new int[]{a, b};
            }
        }
        return new int[0];

    }
}
