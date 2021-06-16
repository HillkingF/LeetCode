package offer;

/**
 * [题目]
 * 请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度
 *
 * [思路]
 * 双指针 滑动窗口,
 * 动态规划也能解
 */
public class offer_48 {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 0) return 0;
        int start = 0;
        int max = 0;
        String loc = "";
        for (int i = 0; i < s.length(); i++) {
            // 先判断当前字符是不是在现有局部字符串中
            if(loc.contains(String.valueOf(s.charAt(i)))){
                // 首先start往前直到start位置的字符等于i位置的字符
                while(s.charAt(start) != s.charAt(i)){
                    start ++;
                }
                // 更新loc和max
                loc = s.substring(++start, i + 1);
            }else{
                // 更新最大字串
                loc = s.substring(start, i + 1);
                if(loc.length() > max) max = loc.length();
            }
        }
        return max;
    }
}
class test_offer_48{
    public static void main(String[] args) {
        offer_48 test = new offer_48();
        String x = "abcabcbb";
        int res = test.lengthOfLongestSubstring(x);
        System.out.println(res);


    }
}
