package Array;

/**
 * [66.加1]
 * 用一个数组表示一个非负整数
 * 末位+1，输出
 * 主要考虑的是进位，从末位往前如果若干位是9，需要进位，所有位都为9时新建一个长度为length+1的数组。
 */
public class _66_simple_AddOne {
    public static void main(String[] args){
        int[ ] digits = {1,2,3,4};
        Solution66 s = new Solution66();
        int[] nums = s.plusOne(digits);
        for (int num: nums){
            System.out.println(num);
        }

    }
}
class Solution66 {
    public int[] plusOne(int[] digits) {
        boolean sign = false;
        int k = 0;
        for(int x = digits.length-1; x >= 0; x--){
            if(digits[x] != 9){
                sign = true;
                k = x;
                break;
            }
        }
        if (sign == true){  // 并非全是9
            int[] nums = digits;
            if (k == nums.length-1){

            }else{
                for(int j = digits.length-1; j > k; j--){
                    nums[j] = 0;
                }
            }
            nums[k] = nums[k] + 1;
            return nums;
        }else{ // 全是9
            int[] nums = new int[digits.length + 1];
            nums[0] = 1;
            for(int i = 1; i < nums.length; i++){
                nums[i] = 0;
            }
            return nums;
        }

    }
}
