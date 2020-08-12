package String;

import java.util.Scanner;

public class Simple_383_canConstruct {
    public static void main(String[] args){
        String a = "aab";
        String b = "baa";

        boolean c = canConstruct(a, b);
        System.out.print(c);

    }
    public static boolean canConstruct(String ransomNote, String magazine) {
        if(magazine.length() < ransomNote.length()) return false;
        for(int i = 0; i < ransomNote.length(); i++){
            int j;
            for(j = 0; j <= magazine.length(); j++){
                if(ransomNote.charAt(i) == magazine.charAt(j)){
                    if(j == 0) magazine = magazine.substring(1);
                    else magazine = magazine.substring(0, j) + magazine.substring(j + 1);
                    System.out.println(magazine);
                    break;
                }
            }
            if(j == magazine.length()) return false;
        }
        return true;

    }
}
