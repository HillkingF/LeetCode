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

        char[] arr2;
        String bijiao;

        HashMap<String, List<String>> hashMap = new HashMap<String,List<String> >();
        List<String> xiang = new ArrayList<>();
        xiang.add(strs[0]);
        hashMap.put(dictsort, xiang);
        System.out.println(hashMap.get(dictsort));

        for(int i = 1; i < strs.length; i++){
            System.out.println(hashMap.get(dictsort));
            arr2 = strs[i].toCharArray();
            Arrays.sort(arr2);
            bijiao = new String(arr2);
            System.out.println(bijiao);

            if(hashMap.containsKey(bijiao)){
                xiang = hashMap.get(bijiao);
                System.out.println(xiang);
                xiang.add(strs[i]);

                hashMap.put(bijiao, xiang);
            }else{
                xiang.clear();
                xiang.add(strs[i]);
                hashMap.put(bijiao, xiang);
            }
        }

        List<List<String>> list = new ArrayList<>();
        for(int km = 0; km < hashMap.size(); km++)
            list.add(hashMap.get(km));

        return list;

    }
}
