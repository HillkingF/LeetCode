package String;

import java.util.Arrays;

public class Simple_mst_0102 {
    public static void main(String[] args){
        String s1 = "abc";
        String s2 = "bab";
        Boolean res = CheckPermutation(s1,s2);

    }
    public static boolean CheckPermutation(String s1, String s2) {
        if(s1.length() != s2.length()) return false;
        if(s1.length() == 0) return true;

        char[] a = s1.toCharArray();
        Arrays.sort(a);   // 直接在原数组上进行排序
        String r1 = String.valueOf(a);
        char[] b = s2.toCharArray();
        Arrays.sort(b);
        String r2 = String.valueOf(b);
        if(r1.equals(r2)) return true;
        else return false;




    }

}
