package Stack;

import java.util.*;

public class Medium_636_exclusiveTime {
    public static void main(String[] args){
        List<String> logs = new ArrayList<>();
        logs.add("0:start:0");
        logs.add("0:start:2");
        logs.add("0:end:5");
        logs.add("1:start:6");
        logs.add("1:end:6");
        logs.add("0:end:7");

        int[] res = exclusiveTime(2, logs);
        for (int i: res){
            System.out.println(i);
        }
    }
    public static int[] exclusiveTime(int n, List<String> logs) {
        int[] res = new int[n];
        for(int i= 0; i<n; i++){
            res[i]= 0;
        }
        Stack<String> stack = new Stack<String>();
        String[] str = new String[3];
        int fun = 0;
        int temp = 0;
        int pro = 0;
        for(String line: logs){
            str = line.split(":");
            if(str[1].equals("start")){
                stack.push(str[0] + ":" + str[2]);
            }else{
                fun = Integer.parseInt(str[0]);
                pro = Integer.parseInt(str[2]) + 1 - Integer.parseInt(stack.pop().split(":")[1]);
                res[fun] = res[fun] + pro;
                temp = temp + pro;
            }
        }
        return res;
    }
}