package String;

import java.util.HashMap;

public class Simple_13_RomanToInt {
    public static void main(String[] args){

    }
    public int romanToInt(String s){
        /**
         * 解法一：后一个跟前一个是配对关系
         * 用时24%
         * 缺点：配对比较用了太多时间
         */
        HashMap<String, Integer> hashMap = new HashMap<String, Integer>();
        hashMap.put("I", 1);
        hashMap.put("V", 5);
        hashMap.put("X", 10);
        hashMap.put("L", 50);
        hashMap.put("C", 100);
        hashMap.put("D", 500);
        hashMap.put("M", 1000);

        int num = 0;
        int i;
        String s1 = "";
        String s2 = "";
        for(i = 0; i < s.length() - 1; i++){
            s1 = Character.toString(s.charAt(i));
            s2 = Character.toString(s.charAt(i + 1));
            if((s1.equals("I")||s1.equals("X")||s1.equals("C")) &&
                    ((hashMap.get(s1) * 10 ==  hashMap.get(s2))||(hashMap.get(s1) * 5 ==  hashMap.get(s2)))){
                num += hashMap.get(s2) - hashMap.get(s1);
                i++;
            }else num += hashMap.get(s1);
        }
        if(i == s.length() - 1) num += hashMap.get(Character.toString(s.charAt(i)));
        return num;

    }



    public int romanToInt_v1(String s){
        /**
         * 解法二：将hashmap换成switch
         */
        int num = 0;
        int i;
        char s1;
        char s2;
        for(i = 0; i < s.length() - 1; i++){
            s1 = s.charAt(i);
            s2 = s.charAt(i + 1);
            if((s1=='I'||s1=='X'||s1=='C') &&
                    ((getValue(s1) * 10 ==  getValue(s2))||(getValue(s1) * 5 == getValue(s2)))){
                num += getValue(s2) - getValue(s1);
                i++;
            }else num += getValue(s1);
        }
        if(i == s.length() - 1) num += getValue(s.charAt(i));
        return num;

    }
    public int getValue(char ch) {
        switch(ch) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return 0;
        }
    }
}
