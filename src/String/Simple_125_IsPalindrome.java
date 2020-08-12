package String;

public class Simple_125_IsPalindrome {
    public static void main(String[] args){

    }
    public static boolean isPalindrome(String s) {
        /**
         * 定义两头双指针，向中间移动
         * 遇到不是字母和数字的情况时，跳过这个字符
         */
        int l = 0, r = s.length()-1;
        boolean res = true;
        s = s.toLowerCase();   // 将字符串转换成小写 0-9对应48-57， a-z对应97-122
        while(r >= l){
            if(Character.isLetterOrDigit(s.charAt(l)) && Character.isLetterOrDigit(s.charAt(r))){
                if(s.charAt(l) == s.charAt(r)){
                    l++;
                    r--;
                }else return false;
            }else{
                if(!Character.isLetterOrDigit(s.charAt(l))) l++;
                if(!Character.isLetterOrDigit(s.charAt(r))) r--;
            }
        }
        return res;

    }
}
