package Hot_100;

import java.util.HashMap;

public class Simple_169_majorityElement {
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int key = 0;
        int maxcount = 0;
        for (int i = 0; i < nums.length; i++) {
            if(map.containsKey(nums[i])) map.put(nums[i], map.get(nums[i]) + 1);
            else map.put(nums[i], 1);
        }
        for (int x: map.keySet()) {
            if(map.get(x) > maxcount){
                key = x;
                maxcount = map.get(x);
            }
        }
        int len = nums.length;
        if(maxcount > len/2) return key;
        return key;

    }
}
