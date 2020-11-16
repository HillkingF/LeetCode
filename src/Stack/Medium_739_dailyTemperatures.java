package Stack;

import java.util.Stack;

public class Medium_739_dailyTemperatures {
    public static void main(String[] args){
        int[] T = {73, 74, 75, 71, 69, 72, 76, 73};
        int[] res = dailyTemperatures(T);
        for (int i = 0; i< res.length; i++){
            System.out.println(res[i]);
        }
    }
    public static int[] dailyTemperatures(int[] T) {
        /**
         * 思路：还是维护一个单调栈、栈中存放的是温度数组的位置索引
         */
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[T.length];

        for(int i = 0; i < T.length; i++){
            res[i] = 0;
            while (!stack.isEmpty()){
                if(T[i] > T[stack.peek()]){  //说明栈顶元素可以出栈并继续与栈顶比较
                    res[stack.peek()] = i - stack.peek();
                    stack.pop();
                }else{  //说明此位置的温度小于等于栈顶的温度，则入栈
                    break;
                }
            }
            stack.push(i);
        }
        return res;


    }
}
