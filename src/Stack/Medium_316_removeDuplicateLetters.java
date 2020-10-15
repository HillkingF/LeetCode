package Stack;

import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Stack;

public class Medium_316_removeDuplicateLetters {
    public static  void main(String[] args){
        String a =   "bbcaac";
                //"abacb";

        String res = removeDuplicateLetters(a);
        System.out.print(res);


    }

    /**
     * 用栈来存储最终返回的字符串，并维持字符串的最小字典序。
     * 每遇到一个字符，如果这个字符不存在于栈中，就需要将该字符压入栈中。
     * 但在压入之前，需要先将之后还会出现，并且字典序比当前字符小的栈顶字符移除，然后再将当前字符压入。
     */
    public static String removeDuplicateLetters(String s) {
        HashMap<Character, Integer> hashMap = new HashMap<>();
        HashMap<Character, Integer> hashMap1 = new HashMap<>();
        Stack<Character> stack = new Stack();
        int i;
        for(i = 0; i < s.length(); i++){
            if (! hashMap.containsKey(s.charAt(i))){
                hashMap.put(s.charAt(i), 1);
                hashMap1.put(s.charAt(i), 0);
            } else hashMap.put(s.charAt(i), hashMap.get(s.charAt(i)) + 1);
        }
        for(i = 0; i < s.length(); i++){
            if(hashMap1.get(s.charAt(i)) != 1){
                while (!stack.isEmpty()) {
                    if (s.charAt(i) < stack.peek() && hashMap.get(stack.peek()) > 0) {
                        hashMap1.put(stack.peek(), 0);
                        stack.pop();
                    } else break;
                }
                stack.push(s.charAt(i));
                hashMap1.put(s.charAt(i), 1);
            }
            hashMap.put(s.charAt(i), hashMap.get(s.charAt(i)) - 1);
        }

        String res = "";
        while(!stack.isEmpty()) res = stack.pop().toString() + res;
        return res;
    }
}
