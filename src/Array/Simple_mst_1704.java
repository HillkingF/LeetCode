package Array;

public class Simple_mst_1704 {
    public int missingNumber(int[] nums) {
        /**
         * 思路：
         * 0-n,少了其中一个，
         * 实际应该有 n+1个数字，但是少了一个，就只有n个
         */
        int res = 0;
        int[] pxnums = new int[nums.length + 1];
        // 验证是否存在的存在数组初始化
        for(int i = 0; i < nums.length; i++){
            pxnums[i] = 0;
        }
        for(int i = 0; i < nums.length; i++){
            pxnums[nums[i]] = 1;
        }
        for(int i = 0; i < pxnums.length; i++){
            if(pxnums[i] == 0) return i;
        }
        return res;


    }
}
