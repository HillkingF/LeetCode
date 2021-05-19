package Hot_100;

public class Medium_152_maxProduct {
    public static void main(String[] args) {
        int[] nums = {-3, -1, -1};
        int[] nums1 = {2,3,-2,4};
        int[] nums2 = {-2,0,-1};
        int res = maxProduct1(nums2);
        System.out.println(res);

    }
    // maxProduct：是用二维数组表示的 动态规划
    public static  int maxProduct(int[] nums) {
        /**
         * 给你一个整数数组 nums ，
         * 请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字），
         * 并返回该子数组所对应的乘积。
         * [感觉这道题跟回文串那道题一曲同工]
         *
         * 使用下面这种动态规划的方法超过了时间或者空间限制，还得改进
         */
        int[][] f = new int[nums.length][nums.length];  // 使用数组会超出内存限制
        int maxres = Integer.MIN_VALUE;
        int tmp = 1;

        for (int i = nums.length - 1; i >= 0 ; i--) {
            for (int j = i; j < nums.length; j++) {
                if(i == j){
                    tmp = nums[i];
                }
                else{
                    tmp = 1;
                    // f[i][j] = f[i][i] * f[i + 1][j];
                    for(int l = i; l <= j; l++){
                        tmp = tmp * nums[l];
                    }
                }
                if(tmp > maxres) {
                    maxres = tmp;
                }
            }
        }
        return maxres;
    }

    //  maxProduct1使用一维数组表示的动态规划
    /*  [思路]
    * 创建两个一维数组：D[i] 表示以i位置的元素作为 子数组的最后一个元素时，最大的乘积，
    * T[i]表示以 i位置的元素作为 子数组的最后一个元素时，最小的乘积，
    * 每次计算到i位置的D和T时，
    * 根据i位置的正负0分别计算：
    * - nums[i] > 0: 则以i位置元素结尾的最大乘积子数组的值为 nums[i] 或者 nums[i] * D[i-1](其中D[i-1]必须大于0，使得正正为正)
    *                则以i位置元素结尾的最小乘积子数组的值为 nums[i] 或者 nums[i] * T[i-1](其中T[i-1]必须小于0，使得正负为负)
    * - nums[i] < 0: 则以i位置元素结尾的最大乘积子数组的值为 nums[i] 或者 nums[i] * T[i-1](其中T[i-1]必须小于0，使得负负为正)
    *                则以i位置元素结尾的最小乘积子数组的值为 nums[i] 或者 nums[i] * D[i-1](其中D[i-1]必须大于0，使得正负为负)
    * - = 0，D[i]和T[i] 怎么乘到i位置都是0
    *比较D[i]和上一个局部最大值的大小并更新
    *
    * 重复上述i的步骤
    * */
    public static int maxProduct1(int[] nums) {
        if(nums.length == 1) return nums[0];
        int[] D = new int[nums.length];
        int[] T = new int[nums.length];
        int maxres = nums[0];
        D[0] = nums[0];
        T[0] = nums[0];

        for (int i = 1; i < nums.length; i++){
            // 默认的初始D，T
            T[i] = nums[i];
            D[i] = nums[i];
            if(nums[i] > 0){
                // 计算nums[i]>0时以i位置作为子数组结尾的最大值
                if(D[i-1] > 0) { D[i] = D[i- 1] * nums[i]; } // 正正得正
                if(T[i-1] < 0) T[i] = T[i-1] * nums[i];  // 最小
                // 判断nums[i]>0时以i位置作为子数组结尾的最大值
                if(D[i] > maxres) maxres = D[i];
            }else if(nums[i] == 0){
                if( 0 > maxres) maxres = 0;
            }else{  // nums[i]<0
                if(T[i-1] < 0){ D[i] = T[i-1] * nums[i];} // 负负得正
                if(D[i-1] > 0){ T[i] = D[i-1] * nums[i];}  // 正负最小
                // 判断此时的最大值
                if(D[i] > maxres) maxres = D[i];
            }

        }
        return maxres;

    }
}
