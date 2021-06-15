package offer;


// 本质上是一个排序问题。设数组 nums 中任意两数字的字符串为 x 和 y ，则规定排序判断规则为：
//若拼接字符串 x + y > y + x ，则 xx “大于” yy ；
//反之，若 x + y < y + x ，则 xx “小于” yy ；
//xx “小于” yy 代表：排序完成后，数组中 xx 应在 yy 左边；“大于” 则反之。
//
//根据以上规则，套用任何排序方法对 numsnums 执行排序即可。
// 其中: X+y和y+x的比较使用 x.compareTo(y):
// compareTo() 的 结果大于 0 表示 x > y
//  < 0 表示x < y
// = 0 表示 x=y


public class offer_45 {
    // 使用快速排序算法进行求解
    public String minNumber(int[] nums) {
        String[] str = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            str[i] = String.valueOf(nums[i]);
        }
        recurrent(str, 0, nums.length-1);
        String res = "";
        for (int i = 0; i < str.length; i++) {
            res = res + str[i];
        }
        return res;
    }
    public void recurrent(String[] str, int start, int end){
        // 子数组中待排序的元素只有一个或者没有,直接返回
        if(start >= end) return;
        // 子数组中至少有两个元素,继续循环进行快速排序
        String out = str[start];
        int i = start;
        int j = end;
        // 找到out的位置
        while(i < j){
            while(i < j){// 首先从后往前比较
                if((out + str[j]).compareTo(str[j] + out) <= 0) j--;
                else  break;
            }
            if( i < j) str[i++] = str[j];
            while(i < j){ // 从前往后走,找比out大的
                if((out + str[i]).compareTo(str[i] + out) >= 0) i++;
                else break;
            }
            if(i < j) str[j--] = str[i];
        }
        if(i == j) str[i] = out;
        // 对out的左右进行循环
        recurrent(str, start, i-1);
        recurrent(str, i+1, end);
    }
}
class test_45{
    public static void main(String[] args) {
        offer_45 test = new offer_45();
        int[] nums = {10,2};
        String x = test.minNumber(nums);
        System.out.println(x);
    }
}
