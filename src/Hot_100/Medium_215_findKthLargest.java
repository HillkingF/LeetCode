package Hot_100;

import java.util.ArrayList;
import java.util.Arrays;

/*
* 在未排序的数组中找到第 k 个最大的元素。
* 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
* */
public class Medium_215_findKthLargest {
    public static void main(String[] args) {
        int[] nums = {3,2,5,6,4};
        int k = 2;
        int res = findKthLargest2(nums, k);
        System.out.println(res);
        // for (int i = 0; i < 5; i++) {
        //     System.out.println(nums[i]);
        // }

    }

    /**
     * 直接调用API求解
     */
    public static int findKthLargest1(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length- k];
    }

    /**
     *使用快排进行排序：
     * https://www.runoob.com/w3cnote/quick-sort.html
     * 【思路】
     * 分治法：快速排序
     * 从整个数组开始，以数组的第一个元素作为基准：
     * - j: 先从尾向前遍历，直到第一次找到比基准元素大的元素，将其复制到基准位置，此时j表示新的空位置，结束j的遍历(注意：当j位置的元素<基准元素时，j不-1.直到下面j位置有元素填充的时候j-1)
     * - i: 再从前向后遍历，直到第一次找到比基准元素小的元素，将其复制到空位置j，此时i表示新的空位置，结束i的遍历(注意：当i位置的元素>基准元素时，i不+1.直到下面i位置有元素填充的时候i+1)
     * 重复上面两个步骤，直到本轮的 i = j，则i就是本轮基准元素的最终位置
     *
     * 分治法递归处理本轮基准元素左右两侧的子数组，每个子数组都会重复上面的过程
     * 子数组结束的标志是：i>=j
     */
    private static int[] N;

    public static int findKthLargest2(int[] nums, int k) {
        N = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            N[i] = nums[i];
        }
        fastsort(0 , nums.length-1);   // 对数组进行排序
        return N[nums.length - k];     // 返回第k大的元素
    }
    public static void fastsort( int start, int end){
        if(start >= end) return;
        int i = start;
        int j = end;
        int out = N[i];

        while( i < j){
            // 首先从末尾往前找,直到找到比out小的数值 移动
            while(i < j && N[j] >= out)  j--;
            if(i < j){  // 退出上面的循环说明 N[j] < out 或者 i >= j;
                N[i] = N[j];
                i++;
            }
            // 然后从前往末尾找,直到找到比out大的数值 移动
            while(i < j && N[i] <= out)  i++;
            if(i < j){  // 退出上面的循环说明 N[i] > out 或者 i >= j;
                N[j] = N[i];
                j--;
            }
        } // while

        if(i == j)   N[i] = out;
        fastsort(start, i-1);
        fastsort(j+1, end);
    }
}
