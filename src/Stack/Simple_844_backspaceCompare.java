package Stack;

import java.util.Stack;

public class Simple_844_backspaceCompare {
    public boolean backspaceCompare(String S, String T) {
        if(stackSimplfy(S).equals(stackSimplfy(T))) return true;
        return false;
    }

    public String stackSimplfy(String str){
        Stack stack = new Stack();
        String res = "";
        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) == '#'){
                if(!stack.isEmpty())stack.pop();
            }else stack.push(str.charAt(i));
        }
        while(!stack.isEmpty()) res = res + stack.pop().toString();
        return res;
    }
}
