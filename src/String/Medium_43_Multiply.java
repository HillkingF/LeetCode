package String;

import java.util.ArrayList;
import java.util.List;

public class Medium_43_Multiply {
    public static void main(String[] args){
        String s = multiply("9133", "0");
    }
    public static String multiply(String num1, String num2) {
        String resstr = "";
        String longnum = num1.length() >= num2.length() ? num1: num2;
        String shortnum = num1.length() < num2.length() ? num1: num2;
        int jinwei = 0;
        int sum = 0;
        String mul = "";
        String count = "";

        int sumjinwei = 0;
        int[] finalres = new int[longnum.length() + shortnum.length()];

        for(int i = shortnum.length() -1 ; i >= 0 ; i--){
            for(int j = longnum.length()-1; j >= 0; j-- ){
                sum = Character.getNumericValue(longnum.charAt(j)) * Character.getNumericValue(shortnum.charAt(i)) + jinwei;
                mul = Integer.toString(sum % 10) + mul;
                jinwei = sum / 10;
            }
            mul = Integer.toString(jinwei) + mul + count;
            // 竖向相加 restemp + mul
            resstr = sumStrings(resstr, mul);
            //清零
            jinwei = 0;
            mul = "";
            count += "0";
        }
        int i;
        for(i = 0; i < resstr.length(); i++){
            if(resstr.charAt(i) != '0')break;
        }
        if(i == resstr.length()) return  "0";
        else return resstr.substring(i);



    }
    public static String sumStrings(String s1, String s2){
        String longstr = s1.length() >= s2.length() ? s1: s2;
        String shortstr = s1.length() < s2.length() ? s1: s2;
        int jinwei = 0;
        int j = shortstr.length()-1;
        int sum = 0;
        String res = "";

        for(int i = longstr.length()-1 ; i >= 0 ; i--){
            if(j >= 0){
                sum = Character.getNumericValue(longstr.charAt(i)) + Character.getNumericValue(shortstr.charAt(j)) + jinwei;
                j--;
            }else sum = jinwei + Character.getNumericValue(longstr.charAt(i));
            jinwei = sum / 10;
            res = Integer.toString(sum % 10) + res;
        }
        res = jinwei + res;
    return res;
    }
}
