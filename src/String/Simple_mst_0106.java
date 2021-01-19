package String;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class Simple_mst_0106 {
    public String compressString(String S) {

        char[] s = S.toCharArray();
        int count = 0;
        char lastchar = ' ';
        String res = "";

        for(int i = 0; i < s.length; i++){
            if(lastchar == ' '){
                lastchar = s[i];
                count = 1;
            }else{
                if(s[i] == lastchar) count += 1;
                else{
                    //先清算上一个字符个数
                    res = res + String.valueOf(lastchar) + String.valueOf(count);
                    count = 1;
                    lastchar = s[i];
                }
            }
            if(i == s.length-1)
                res = res + String.valueOf(lastchar) + String.valueOf(count);
        }

        if(res.length() >= S.length()) return S;
        else return res;

    }

    public String compressString1(String S) {
        /**对上面进行优化
         *
         */
        if(S.length() <= 1) return S;
        char[] s = S.toCharArray();
        String res = "";

        int end = 0;
        int start = 0;
        while(end < s.length){
            if(s[end] == s[start]) end ++;
            else {
                res = res + S.substring(start, start+1) +  String.valueOf(S.substring(start,end).length());
                start = end;
            }
        }
        res = res + S.substring(start, start+1) +  String.valueOf(S.substring(start,end).length());
        if(res.length() > S.length())return S;
        return res;

    }
}
