package offer;

// 解析题目: 数组长度为n,每一个数都在0-n之间,有一个是缺少的,其余递增
// 这道题重要的是理解题目的意思:
// 如果从0开始 i != i位置上的数, 返回i
// 如果 i 超过了 数组最后一个数的索引,说明缺少的是 nums.length这个数,直接返回数组长度这个数值
public class offer_53_2 {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if(i != nums[i]) return i;
        }
        return n;
    }
}
class offer_53_2_test{
    public static void main(String[] args) {
        int[] nums = {0,2};
        offer_53_2 test = new offer_53_2();
        int res = test.missingNumber(nums);
        System.out.println(res);
    }
}