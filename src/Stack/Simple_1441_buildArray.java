package Stack;

import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Simple_1441_buildArray {
    public List<String> buildArray(int[] target, int n) {
        List<String> res = new ArrayList<>();
        int index = 0;
        for(int i = 1; i<= n; i++){
            if(i > target[target.length-1])break;
            else{
                if(target[index] > i){
                    res.add("Push");
                    res.add("Pop");
                }else if(target[index] == i){
                    res.add("Push");
                    index ++;
                }
            }
        }
        return res;
    }
}
