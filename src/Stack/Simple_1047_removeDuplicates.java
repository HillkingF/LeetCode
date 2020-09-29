package Stack;

import java.util.Stack;

public class Simple_1047_removeDuplicates {
    public String removeDuplicates(String S) {
        Stack<Character> onlystr = new Stack();
        String res = "";
        for(int i= 0; i < S.length(); i++){
            if(onlystr.isEmpty()) onlystr.push(S.charAt(i));
            else{
                if(S.charAt(i) == onlystr.peek()) onlystr.pop();
                else onlystr.push(S.charAt(i));
            }
        }
        while(!onlystr.isEmpty()){
            res = Character.toString(onlystr.pop()) + res ;
        }
        return res;


    }
}
