package Stack;

import java.util.Stack;

public class Medium_394_decodeString {
    public static void main(String[] args){
        String s = "3[a2[c]]";
        String res = decodeString(s);
        System.out.print(res);

    }


    public static String decodeString(String s) {
        int i = 0;
        String tempres = "";
        String res = "";
        String temptime = "";
        int time = 0;
        Stack<String> stack = new Stack<>();
        for(i = 0; i < s.length(); i++){
            if(s.charAt(i) == ']'){ //出栈
                while(!stack.isEmpty() && !stack.peek().equals("[")) tempres = stack.pop() + tempres;
                stack.pop();
                while(!stack.isEmpty() && stack.peek().matches("[0-9]+")) temptime = stack.pop() + temptime;
                time = Integer.valueOf(temptime);
                for(int j = 0; j < time; j++)res = res + tempres;
                stack.push(res);
                res = "";
                tempres = "";
                temptime = "";
            }else stack.push(s.substring(i,i+1));
        }
        while(!stack.isEmpty()) res = stack.pop() + res;
        return res;

    }
}
