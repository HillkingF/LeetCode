package Hot_100;

public class Medium_239_maxSlidingWindow {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length - k + 1];   //返回结果数组的长度为nums.length - k + 1
        // 初始第一个窗口的最大值和对应的索引位置
        int kindex = -1;
        int kmax = Integer.MIN_VALUE;
        int j = 0;
        for (int i = 0; i <= nums.length - k; i++) {
            if(i == 0){ // 第一个滑动窗口需要全部比较
                for (j = i; j < i + k; j++) {
                    if(kmax < nums[j]){
                        kindex = j;
                        kmax = nums[j];
                    }
                }
            }else{ // 第二个滑动窗口开始只用比较一部分,j 始终是窗口移动后新增的那一个
                j = i + k - 1;  // j 不会超过 数组长度
                if(kindex == i - 1) { // 说明在滑动窗口外面
                    kindex = i;
                    kmax = nums[i];
                    for(int n = i + 1; n < i + k; n++){
                        if(nums[n] > kmax){
                            kmax = nums[n];
                            kindex = n;
                        }
                    }
                }else if(i <= kindex){
                    if(kmax < nums[j]){
                        kmax = nums[j];
                        kindex = j;
                    }
                }


            }
            res[i] = kmax;
        }
        return res;
    }
}
