package String;

import java.util.ArrayList;
import java.util.List;

public class Medium_49_groupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<String> dict = new ArrayList<>();

        dict.add(strs[0]);
        boolean sign = true;
        for(int i = 1; i < strs.length; i++){
            for(int k = 0; k < dict.size(); k++){
                for(int j = 0; j < strs[i].length(); j++){
                    if(dict.get(k).contains(strs[i].substring(j, j+1))){
//                      sign = true;
                    }else{sign = false;}
                }
                if(sign != false){

                }

            }


        }

    }
}
