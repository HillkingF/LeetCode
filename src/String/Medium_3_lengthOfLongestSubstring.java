package String;

import java.util.HashMap;

public class Medium_3_lengthOfLongestSubstring {
    public static void main(String[] args){
        String s = "tmmzuxt";
        int x = lengthOfLongestSubstring(s);
        System.out.print(x);
    }

    public static int lengthOfLongestSubstring(String s) {
        /**
         * 一旦涉及次数，需要使用到散列表：字符是键，次数是值
         * 其次用到了滑动窗口
         * 滑动窗口左右分别设置一个指针，start和end
         * 当end指向的字符在散列表中出现且值为1时，
         * start向前移动，在遇到end对应的字符之前，将每一个经过的字符对应的散列表值设置为0
         * （这样是为了保证滑动窗口中每一个字符出现次数为1）
         * 并且每一次无重复字符时的移动都比较max和end-start的大小。
         */
        if(s.length() <= 1) return s.length();
        HashMap<Character, Integer> hashMap = new HashMap<Character, Integer>();
        int max = 0;
        int start = 0, end = 0;
        hashMap.put(s.charAt(start), 1);
        max = 1;
        int count = 0;
        char a = ' ';
        for(end = 1; end < s.length(); end++){
            a = s.charAt(end);
            if(hashMap.containsKey(a)&&(hashMap.get(a) == 1)){
                while(true){
                    if(s.charAt(start) != a){
                        hashMap.put(s.charAt(start), 0);
                        start++;
                    }else{
                        start++;
                        break;
                    }
                }
            }else{
                hashMap.put(a, 1);
                count = end - start + 1;
                if(count > max) max = count;
            }
        }
        return max;

    }
}
