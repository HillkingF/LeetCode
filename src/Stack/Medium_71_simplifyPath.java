package Stack;

import java.util.Stack;

public class Medium_71_simplifyPath {
    public static void main(String[] args){
        String path = "/..hidden";//   "/a/./b/../../c/";
        String res = simplifyPath(path);
        System.out.println(res);

    }
    public static String simplifyPath(String path) {
        int sign = 0;
        Stack<Character> stack = new Stack();
        for(int i = 0; i < path.length(); i++){
            if (path.charAt(i) == '/'){
                if(stack.isEmpty()){
                    stack.push('/');
                }else{
                    if(stack.peek() == '/'){//   /字符重复了，直接过
                    }else if(stack.peek() == '.'){  // 出栈2次 ，入栈一次
                        if(sign == 1){

                        }else{
                            stack.pop();
                        }

                    }else{
                        stack.push(path.charAt(i));
                    }
                }
            }else if(path.charAt(i) == '.'){
                if(!stack.isEmpty()){
                    if(stack.peek() == '/') stack.push(path.charAt(i));
                    else if(stack.peek() == '.'){
                        if (sign == 1){
                            stack.push('.');
                        }else{
                            if(i != path.length() - 1 && path.charAt(i + 1) == '.'){
                                sign = 1;
                                stack.push('.');
                            }else if(i != path.length() - 1 && path.charAt(i + 1) != '/'){
                                stack.push('.');
                            } else if(i == path.length() - 1){
                                stack.pop();  //出栈 .
                                stack.pop();  //出栈 /
                                while (!stack.isEmpty() && stack.peek()!='/'){
                                    stack.pop();
                                }
                            }else{
                                stack.pop();  //出栈 .
                                stack.pop();  //出栈 /
                                while (!stack.isEmpty() && stack.peek()!='/'){
                                    stack.pop();
                                }
                            }
                        }

                    }
                }

            }else{ //字母
                if(!stack.isEmpty()){
                    stack.push(path.charAt(i));
                }
            }
        }
        //出栈，转换成字符串，翻转
        String res = "";
        if (stack.isEmpty()){
            res = "/";
        }else{
            while(!stack.isEmpty()){
                res = stack.pop().toString() + res;
            }
            int len = res.length();
            if(len == 1){
            }else if(res.charAt(len-1) == '/'){
                res = res.substring(0, len-1);
            }else if(res.charAt(len-1)=='.'){
                if(len >= 4 && res.substring(len-4).equals("/...")){
                }else{
                    res = res.substring(0, len-1);
                }


            }
        }

        return res;

    }
}
