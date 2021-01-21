package Array;

public class Hard_4_findMedianSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double res = 0;
        if(nums1.length==0 && nums2.length==0) return 0;
        if(nums1.length==0){
            res = nums2.length % 2 == 1?
                    nums2[nums2.length/2]:
                    ((double)(nums2[nums2.length/2] + nums2[nums2.length/2-1]))/2;
        }else if(nums2.length==0){
            res = nums1.length % 2 == 1?
                    nums1[nums1.length/2]:
                    ((double)(nums1[nums1.length/2] + nums1[nums1.length/2-1]))/2;
        }else{
            // 两个数组都不为空时
            int len = nums1.length + nums2.length;  // 奇数个 count = len/2 + 1,偶数个 count = len/2 和 len+1的一半
            int sign = len % 2 == 1 ? 1 : 0;;  // 0表示偶数个  1表示奇数个元素
            int count = 0;
            int[] all = new int[len + 1];
            int i=0,j=0,index = 0;  // nums1和2的索引位置 // 合并后all的索引位置

            len = len / 2 + 1;
            while(i < nums1.length && j < nums2.length){
                if(count < len){
                    if(nums1[i] <= nums2[j]) all[index ++] = nums1[i++];
                    else  all[index ++] = nums2[j++];
                    count ++;
                }else  break;
            }
            if(i == nums1.length){ // 说明nums1遍历完了
                while(count < len){
                    all[index++] = nums2[j++];
                    count ++;
                }
            }else if(j == nums2.length){ // 说明2完了
                while(count < len){
                    all[index ++] = nums1[i ++];
                    count ++;
                }
            }
            res = sign == 1 ? all[count - 1]: ((double)(all[count - 2] + all[count - 1]))/2;
        }
        return res;
    }
}
