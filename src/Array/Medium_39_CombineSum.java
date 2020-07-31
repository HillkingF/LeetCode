package Array;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Medium_39_CombineSum {
    public static void main(String[] args){
        Solution39 s = new Solution39();
        int[] candidates = {2,3,6,7};
        int target = 7;
        List<List<Integer>> outlist = s.combinationSum(candidates, target);


    }
}
class Solution39 {
    private List<List<Integer>> outlist = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> outlist = new ArrayList<>();
        List<Integer> inlist = new ArrayList<>();
        if(candidates.length == 0 || candidates == null) outlist = null;
        Arrays.sort(candidates); // candidates这个数组至少有一个数字,从小到大排序数组
        inlist = find(candidates, target, inlist,0);
        return outlist;

    }
    public List<Integer> find(int[] candidates, int changetarget, List<Integer> inlist, int start){
        for(int i1 = start; i1 < candidates.length; i1++){
            //i1 指向每次一定包含的数字
            List<Integer> in = new ArrayList<>();
            if(candidates[i1] > changetarget) {
                inlist.clear(); //说明从这个数字开始都比target大了，没必要往后遍历
                break;
            }
            if(candidates[i1] == changetarget) {
                inlist.add(candidates[i1]);
                break;
            }
            int maxtime = changetarget/candidates[i1]; // 计算每一轮必有candidates[i1]时，最多有几个数字
            for(int time = 1; time <= maxtime; time++ ){
                int newtarget = changetarget - time * candidates[i1];
                inlist.add(candidates[i1]);
                if(i1 != candidates.length - 1){
                    inlist = find(candidates, newtarget, inlist,i1 + 1);
                }else{
                    inlist = find(candidates, newtarget, inlist, i1);
                }
            }
            if(inlist.size() > 0){
                this.outlist.add(inlist);
                inlist.clear();
            }
        }
        return inlist;

    }
}
