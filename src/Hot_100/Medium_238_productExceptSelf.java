package Hot_100;

public class Medium_238_productExceptSelf {
    public static void main(String[] args) {
        int[] n1 = {1,2,3,4};
        int[] res = productExceptSelf(n1);
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }
    }
    public static int[] productExceptSelf(int[] nums) {
        // 1.复制原数组，作为最终输出数组，也是后缀计算结果的数组
        int[] res = nums.clone();  // 深拷贝
        int lastnum = 0;
        int nownum = 0;
        // 2. 计算前缀乘积
        lastnum = nums[0];
        nums[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            nownum = nums[i-1] * lastnum;
            lastnum = nums[i];
            nums[i] = nownum;
        }
        // 3.计算后缀乘积
        lastnum = res[res.length-1];
        res[res.length-1] = 1;
        for (int i = res.length-2; i >= 0; i--) {
            nownum = lastnum * res[i + 1];
            lastnum = res[i];
            res[i] = nownum;
        }
        for (int i = 0; i < res.length; i++) {
            res[i] = nums[i] * res[i];
        }
        return res;


    }
}
