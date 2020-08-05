package Array;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;


// 剪枝算法
// 深度遍历
// 【说实话这道题不是很懂咋写，再看几遍】
public class Medium_39_CombineSum {
    public static void main(String[] args){
        Solution39 s = new Solution39();
        int[] candidates = {2,3,6,7};
        int target = 7;
        List<List<Integer>> outlist = s.combinationSum(candidates, target);


    }
}
class Solution39 {
    public List<List<Integer>> outlist = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if(candidates == null || candidates.length == 0)return outlist;
        deepFind(target,0,new Stack<Integer>(),candidates);
        return outlist;


    }

    // 深度遍历，使用减法构造候选集
    public void deepFind(int target, int index, Stack<Integer> pre, int[] candidates){
        // target == 0 说明还需要0个元素，目前已经找到合适的一组了
        if(target == 0){
            outlist.add(new ArrayList<>(pre));
            return;
        }

        // target != 0, 继续遍历
        for(int i = index; i < candidates.length; i++){  // i从index开始遍历是为了防止重复
            if(candidates[i] <= target){
                pre.push(candidates[i]);
                deepFind(target-candidates[i],i, pre, candidates);
                pre.pop();
            }

        }

    }
}
