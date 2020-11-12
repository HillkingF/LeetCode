package Stack;

import java.util.Stack;

public class Medium_503_nextGreaterElements {
    public static void main(String[] args){
        int[] nums = {1,2,1};
        int[] res = nextGreaterElements(nums);
        for(int num: res){
            System.out.print(num);
        }

    }
    public static int[] nextGreaterElements(int[] nums) {

//        //单调栈，两次遍历数组。首次遍历更新结果数组。逆向解法
//        int[] res = new int[nums.length];
//        Stack<Integer> stack = new Stack<>();
//        for (int i = 2 * nums.length - 1; i >= 0; --i) {
//            while (!stack.empty() && nums[stack.peek()] <= nums[i % nums.length]) {
//                stack.pop();
//            }
//            res[i % nums.length] = stack.empty() ? -1 : nums[stack.peek()];
//            stack.push(i % nums.length);
//        }
//        return res;

        //单调栈，两次遍历数组。首次遍历更新结果数组。正向解法
        int[] res = new int[nums.length];
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < 2*nums.length; i++){
            while(!stack.isEmpty() && nums[stack.peek()] < nums[i % nums.length]){
                res[stack.peek()] = nums[i % nums.length];
                stack.pop();
            }
            stack.push(i % nums.length);
            if(i < nums.length)res[i % nums.length] = -1;
        }
        return res;

    }
}
