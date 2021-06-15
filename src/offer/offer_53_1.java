package offer;

import java.util.HashMap;

public class offer_53_1 {
    public int search(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);  // 注意默认值设置为0
            //if(map.containsKey(nums[i])){
            //    map.put(nums[i], map.get(nums[i]) + 1);
            //}else{
            //    map.put(nums[i], 1);
            //}
        }
        System.out.println(map);
        return map.getOrDefault(target, 0);
    }
}
class offer_53_1_test{
    public static void main(String[] args) {
        offer_53_1 test = new offer_53_1();
        int[] nums = {5,7,7,8,8,10};
        int res = test.search(nums, 8);
        System.out.println(res);
    }
}
