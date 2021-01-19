package String;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

public class Simple_mst_0104 {
    public static void main(String[] args){
        String s = "aab";
        Boolean res = canPermutePalindrome(s);
        System.out.print(res);
    }
    public static boolean canPermutePalindrome(String s) {
        /**
         * 思路：
         * 回文串：
         * 奇数个：只有一个字符的数量是基数，其余字符数量都是偶数
         * 偶数个：所有字符数量都是偶数
         */
        if(s.length() <= 1) return true;
        HashMap<Character, Integer> map = new HashMap<>();
        char[] c = s.toCharArray();
        for(char x: c){
            if(map.containsKey(x)){
                map.put(x, map.get(x)+1);
            }else{
                map.put(x,1);
            }
        }
        int jishucount = 0;
        for(char x: map.keySet()){
            if(map.get(x) % 2 == 1) jishucount += 1;
        }
        if((s.length()%2==1 && jishucount == 1) ||
                s.length() % 2 == 0 && jishucount == 0)
            return true;
        else return false;


        // Arrays.sort(chars); 字符数组排序，然后使用栈，两两相消

    }
}
