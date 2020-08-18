package String;

import javax.print.DocFlavor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 回溯算法：递归求解。下一层的条件都满足时加入组合，不满足时回溯并改变上一层的记录
 */
public class Medium_17_PhoneLetterCombinations {
    public static void main(String[] args){
        String s = "23";
        List<String> l = letterCombinations(s);
    }
    public static HashMap<Character, String> hashmap = new HashMap<Character, String>(){{
        put('2', "abc");
        put('3', "def");
        put('4', "ghi");
        put('5', "jkl");
        put('6', "mno");
        put('7', "pqrs");
        put('8', "tuv");
        put('9', "wxyz");
    }};
    public static List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList();
        res = findRecurrent(res, "",digits, 0);
        return res;

    }
    public static List<String> findRecurrent(List<String> res,String arr , String next, int index){
        if(index < next.length()){
            String str = hashmap.get(next.charAt(index));
            for(int j = 0; j < str.length(); j++){
                if(j == 0 )arr = arr + Character.toString(str.charAt(j));
                else if(arr.length() < 2)arr = Character.toString(str.charAt(j));
                else if(arr.length() >= 2)arr = arr.substring(0, arr.length()-1) + Character.toString(str.charAt(j));
                if(index == next.length()-1) res.add(arr);
                else res = findRecurrent(res,arr, next, index + 1);
            }
        }
        return res;



    }

}
