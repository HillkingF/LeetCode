package String;

public class Medium_151_reverseWords {
    public static void main(String[] args){
        String s = "a good   example";
        String s1 = reverseWords(s);
        System.out.println(s1);

    }
    public static String reverseWords(String s) {
        if(s.length() == 0) return s;
        int start = 0;
        String res = "";
        for(int i =0; i < s.length(); i++){
            if(s.charAt(i) != ' '){
                if(i == 0 || s.charAt(i-1)==' ') start = i;
            }else if(i != 0 && s.charAt(i - 1)!=' ') res = s.substring(start, i) + " " + res;
            if(i==s.length()-1 && s.charAt(i) != ' ')
                res = s.substring(start, i + 1) + " " + res;
        }
        return res.trim();
    }
}
