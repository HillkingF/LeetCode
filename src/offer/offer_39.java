package offer;

import java.util.HashMap;

public class offer_39 {
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        int max = Integer.MIN_VALUE;
        int res = 0;
        for (int x : map.keySet()){
            if(map.get(x) > max){
                max = map.get(x);
                res = x;
            }
        }
        return res;
    }
}
