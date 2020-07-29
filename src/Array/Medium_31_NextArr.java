package Array;

import java.util.Arrays;

public class Medium_31_NextArr {
    public static void main(String[] args){
        int[] nums = {5,4,7,5,3,2};
        Solution31 s = new Solution31();
        s.nextPermutation(nums);
    }
}

/**
 * [思路]
 * 从后往前一直遍历直到找到 连续的两个数，且a[i] > a[i-1]
 * 将a[i]到最后一个数赋值给一个新的数组rest，rest从小到大排序。
 * 从rest[0]开始依次和a[i-1]比较：
 * 如果rest[j] <= a[i-1], 将rest[j]依次赋值给nums
 * 当rest[j] > a[i-1], rest[j] 和 a[i-1]互换
 * 之后继续赋值给nums
 */
class Solution31 {
    public void nextPermutation(int[] nums) {
        if(nums.length > 1){
            int p = nums.length -1;
            while(p > 0){
                if(nums[p] <= nums[p-1])p = p - 1;
                else break;
            }
            if(p == 0){
                // 两端置换
                int l = 0;
                int r = nums.length - 1;
                int linshi = nums[0];
                while(l < r){
                    nums[l] = nums[r];
                    nums[r] = linshi;
                    r--;
                    l++;
                    linshi = nums[l];
                }
                if(l == r) nums[l] = linshi;
            }else{
                int q = p-1;
                int[] rest = new int[nums.length - p];
                int temp = nums[q];
                for( int i = 0; i < nums.length - q - 1; i++){
                    rest[i] = nums[p];
                    p++;
                }
                p = q + 1;
                Arrays.sort(rest);
                int sign = 0;
                for(int j = 0; j < rest.length; j++){
                    if(rest[j] <= temp){
                        nums[p] = rest[j];
                    }else{
                        if(sign == 0){
                            nums[q] = rest[j];
                            nums[q + j + 1] = temp;
                            sign = 1;
                        }else{
                            nums[p] = rest[j];
                        }
                    }
                    p = p + 1;
                }
                rest = null;
            }
        }
    }
}