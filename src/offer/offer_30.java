package offer;

import java.util.*;

/*
* 定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中，
* 调用 min、push 及 pop 的时间复杂度都是 O(1)。
 */

//offer_30 是使用list和栈共同维护最小的元素的类,min的时间不是O(1).
// 因此在下面的MinStack类中进行改进
public class offer_30 {
    private ArrayList<Integer> minlist;  // 存储最小元素
    private Stack<Integer> stack ;  // 定义栈

    /** initialize your data structure here. */
    public offer_30() {
        minlist = new ArrayList<>();
        stack = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
        // 改变在minlist中的顺序
        minlist.add(x);

        return ;
    }

    public void pop() {
        if(stack.isEmpty()){
        }else{
            int x = stack.pop();
            boolean res = minlist.remove((Object) x);
        }
        return ;
    }

    public int top() {
        if(stack.isEmpty()){
            return -1;
        }else{
            return stack.peek();
        }

    }

    public int min() {
        if(stack.isEmpty()) return -1;
        else{
            Collections.sort(minlist);
            return minlist.get(0);
        }
    }
}

//参考这个题解: https://leetcode-cn.com/problems/bao-han-minhan-shu-de-zhan-lcof/solution/mian-shi-ti-30-bao-han-minhan-shu-de-zhan-fu-zhu-z/
// 使用 A和B两个栈.A用于压入和弹出
// 辅助栈B 用于维护A中的部分最小元素
class MinStack {
    private Stack<Integer> A;
    private Stack<Integer> B;
    /** initialize your data structure here. */
    public MinStack() {
        A = new Stack<>();
        B = new Stack<>();
    }
    public void push(int x) {
        A.push(x);
        if(B.isEmpty()){
            B.push(x);
        }else{
            if(x <= B.peek()){  // 注意这里一定是 <=
                B.push(x);
            }
        }
    }

    public void pop(){
        if(A.isEmpty()){
        }else{
            int x = A.pop();
            if(x == B.peek()){
                B.pop();
            }
        }
    }

    public int top() {
        return A.peek();
    }

    public int min() {
        if(A.isEmpty()) return -1;
        return B.peek();
    }

}