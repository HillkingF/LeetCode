package offer;

public class offer_21 {
    public int[] exchange(int[] nums) {
        // 使用插入排序的思想,前后依次遍历
        // 但这里不是排序,而是找奇数和偶数
        if(nums == null || nums.length <= 1) return nums;

        int out;
        int i = 0;
        int j = nums.length-1;
        while(i < j){
            while(i < j && nums[i] % 2 == 1){
                i = i + 1;
            }
            out = nums[i];  // 只要停止了就令i位置的out = nums[i]

            while(j > i && nums[j]%2 == 0){
                j --;
            }
            if(j > i && nums[j] % 2 == 1){
                nums[i++] = nums[j];
                nums[j--] = out;
            }
        }
        return nums;

    }
}
