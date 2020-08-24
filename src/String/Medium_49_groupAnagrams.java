package String;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Medium_49_groupAnagrams {
    public static void main(String[] args){
        String[] strs = {"eat","tea","tan","ate","nat","bat"};
        List<List<String>> l = groupAnagrams(strs);

    }
    public static List<List<String>> groupAnagrams(String[] strs) {
        char[] arr = strs[0].toCharArray();
        Arrays.sort(arr);
        String dictsort = new String(arr);
        String bijiao;
        HashMap<String, List<String>> hashMap = new HashMap<String,List<String> >();
        List<String> xiang = new ArrayList<>();
        xiang.add(strs[0]);
        hashMap.put(dictsort, xiang);
        for(int i = 1; i < strs.length; i++){
            arr = strs[i].toCharArray();
            Arrays.sort(arr);
            bijiao = new String(arr);
            if(hashMap.containsKey(bijiao)){
                xiang = hashMap.get(bijiao);
                xiang.add(strs[i]);
                hashMap.put(bijiao, xiang);
            }else{
                List<String> l = new ArrayList<>();
                l.add(strs[i]);
                hashMap.put(bijiao,l);
            }
        }
        List<List<String>> list = new ArrayList<>();
        for (String key:hashMap.keySet()) list.add(hashMap.get(key));
        return list;
    }
}
