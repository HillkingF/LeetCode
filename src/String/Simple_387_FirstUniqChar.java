package String;

import java.util.HashMap;

public class Simple_387_FirstUniqChar {
    public static void main(String[] args){
        String a = "aab";




    }
    public int firstUniqChar(String s) {

        HashMap<Character, Integer> h = new HashMap<Character, Integer>();

        // 第一次遍历，用于统计个数
        for(int i= 0; i < s.length(); i++){
            if(h.containsKey(s.charAt(i))) h.put(s.charAt(i), h.get(s.charAt(i)) + 1);
            else h.put(s.charAt(i), 1);
        }
        // 第二次遍历，查询个数
        for(int i = 0; i < s.length(); i++){
            if(h.get(s.charAt(i)) == 1) return i;
        }
        return -1;


    }


}
