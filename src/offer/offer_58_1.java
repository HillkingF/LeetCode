package offer;

import java.util.HashMap;

public class offer_58_1 {
    public String reverseWords(String s) {
        String[] strarr = s.split(" ");
        String res = "";
        for(int i = strarr.length-1; i >= 0; i--){
            if(strarr[i].equals("")){
            }else  res = res + " " + strarr[i];
        }
        if(res.length() == 0)return res;
        else return res.substring(1, res.length());
    }
}

