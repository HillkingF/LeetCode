package Stack;

import java.util.*;

public class Medium_636_exclusiveTime {
    public static void main(String[] args){
        List<String> logs = new ArrayList<>();
        logs.add("0:start:0");
        logs.add("0:start:2");
        logs.add("0:end:5");
        logs.add("1:start:7");
        logs.add("1:end:7");
        logs.add("0:end:8");

        int[] res = exclusiveTime(2, logs);
        for (int i: res){
            System.out.println(i);
        }
    }
    public static int[] exclusiveTime(int n, List<String> logs) {
        int[] res = new int[n];
        for(int i = 0; i<n; i++){
            res[i]= 0;
        }
        Stack<String> stack = new Stack<String>();
        int pre = 0;  //用于记录上一个线程结束的时间
        int sign = 0;  //记录两个start 之间有没有 其他end
        // 每一行的变量
        int line_time = 0;
        String line_sign = "";
        int line_func = 0;

        // 栈顶的内容
        int stack_func = 0;
        int stack_time = 0;

        for(String line: logs){
            // 日志的每一行内容分解
            line_func = Integer.parseInt(line.split(":")[0]);
            line_sign = line.split(":")[1];
            line_time = Integer.parseInt(line.split(":")[2]);

            // 栈顶的内容分解
            if(!stack.isEmpty()){
                stack_func = Integer.parseInt(stack.peek().split(":")[0]);
                stack_time = Integer.parseInt(stack.peek().split(":")[1]);
            }

            //当遍历到的这一行是start时，先通过sign看此时刻前有没有出栈的线程：没有需要将栈顶的使用时间更新到此刻
            //当有出栈的线程时，再判断上一个线程的结束是不是此时刻的开始：如果不是则更新栈顶的使用时间到此时，否则不用更新栈顶的使用时间
            // 更新后此行入栈，更新上一个线程的使用时间pre，同时更新sign变量
            if(line_sign.equals("start")){
                if(!stack.isEmpty() && sign == 0){
                    res[stack_func] += line_time - stack_time;
                }else if(sign == 1 && line_time != pre ){
                    res[stack_func] += line_time - pre;
                }
                stack.push(line_func + ":" + line_time);
                pre = line_time;
                sign = 0;
            }else{
                // 如果遍历的这一行为end。首先判断上一个线程的停止时间是不是栈顶的时间，如果是则说明此时和栈顶之间没有其他线程，直接更新
                // 否则说明栈顶和此时刻之间有其他的线程，所以要减去其他线程的执行时间，剩下的才是栈顶的阶段性运行时间
                // 最后出栈。更新刚刚使用的线程停止时间pre
                // 设置sign=1，说明下一个start和栈顶的start之间存在线程出栈
                if(pre == stack_time){
                    res[stack_func] +=  line_time + 1 - stack_time;
                }else{
                    res[stack_func] += line_time + 1 - pre;
                }
                stack.pop();
                pre = line_time + 1;
                sign = 1;
            }
        }
        return res;
    }
}