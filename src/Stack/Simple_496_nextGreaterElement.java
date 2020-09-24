package Stack;

import java.util.HashMap;
import java.util.Stack;

/**
 * 仔细读题目，注意不能改变数组中的顺序，直接固定位置查找后面大的数
 * 本题的思路：对nums2 进行单调栈处理
 */
public class Simple_496_nextGreaterElement {
    public static void main(String[] args){
        int[] nums1 = {4,1,2};
        int[] nums2 = {1,3,4,2};
        int[] res = nextGreaterElement(nums1, nums2);

    }
    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] res = new int[nums1.length];
        HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
        Stack biggerstack = new Stack();
        int i;
        for(i = 0; i < nums2.length; i++){
            if(!biggerstack.isEmpty()){
                while(!biggerstack.isEmpty()){
                    if(nums2[i] < (int)biggerstack.peek())break;
                    else{
                        hashMap.put((int)biggerstack.peek(), nums2[i]);
                        biggerstack.pop();
                    }
                }
            }
            biggerstack.push(nums2[i]);
        }
        while(!biggerstack.isEmpty()){
            hashMap.put((int)biggerstack.peek(), -1);
            biggerstack.pop();
        }
        for(i = 0; i < nums1.length; i++){
            System.out.print(hashMap.get(nums1[i]));
            res[i] = hashMap.get(nums1[i]);
        }
        return res;

    }
}
