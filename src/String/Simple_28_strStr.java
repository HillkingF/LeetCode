package String;

public class Simple_28_strStr {
    public static void main(String[] args){
        String s1 = "hello";
        String s2 = "ll";
        int x = strStr(s1, s2);
        System.out.println(x);


    }
    public static int strStr(String haystack, String needle) {
        /**
         * 第一个想到的思路就是双指针
         */
        int p1 = 0, p2 = 0;
        int start = -1;
        if(haystack.equals("")  && needle.equals("") ) return 0;
        else if(haystack.equals(""))return -1;
        else if(needle.equals(""))return 0;

        while(p1 < haystack.length()){
            System.out.print(start);
            if(haystack.charAt(p1) == needle.charAt(p2)){
                if(start == -1)start = p1;
                p2++;
                p1++;
            }else{
                if(start != -1){
                    p1 = start + 1;
                    p2 = 0;
                    start = -1;
                }else{
                    p1++;
                    start = -1;
                }

            }
            if(p2==needle.length()){ break;}

        }
        if(p1 == haystack.length() && p2 != needle.length()) start = -1;
        return start;
    }
}
