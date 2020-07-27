package Array;

/**
 * 数组88题
 * 思路：设置三指针，其中两个从后往前遍历比较，另外一个用于移动存放
 * 数组nums1 和 nums2最后要合并到nums1中，无重复删减，所以最后num1的元素是原来两个数组的完全合并，元素个数是m+n
 * 解决：
 * 设置三个指针，p1指向num1的最后一个，p2指向nums2的最后一个，p指向 num1[m+n-1]。
 * p1和p2指向的元素比较，哪个大哪个移动到p位置；
 * 然后p往前移动1个，p1或者p2往前移动一个，继续比较。。。。
 * [这种方法的时间复杂度是O(m+n)，空间复杂度是O(1)]
 */
public class _88_simple_merge {
    public static void main(String[] args){
        int[] nums1 = new int[100];
        nums1[0] = 2;
        int m = 1;
        int[] nums2 = {1};
        int n = 1;
        Solution88 s = new Solution88();
        s.merge(nums1, m, nums2, n);

    }
}
class Solution88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if(n != 0 && m == 0){
            for(int i = 0; i < n; i++ ){
                nums1[i] = nums2[i];
            }
        } else if(n != 0 && m != 0){
            int p1 = m-1; // 指向nums1的末尾
            int p2 = n-1; // 指向nums2的末尾
            int p;  // 指向nums1[m+n-1]，p是最终元素存放的位置
            for(p = m + n -1; p >= 0; p--){
                if(p1 < 0 && p2 >= 0){
                    nums1[p] = nums2[p2--];
                }else if(p2 < 0 && p1 >= 0){
                    break;
                }else{
                    if(nums1[p1] >= nums2[p2]){
                        nums1[p] = nums1[p1--];
                    }else{
                        nums1[p] = nums2[p2--];
                    }
                }
            }
        }
    }
}
