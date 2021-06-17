package offer;

public class offer_50 {
    public char firstUniqChar(String s) {
        String res = "";
        if(s.length() == 0) return ' ';
        if(s.length() == 1) return s.charAt(0);
        String rest = s;
        while(rest.length() > 0){
            if(rest.length() == 1) return rest.charAt(0);
            else{
                String c = String.valueOf(rest.charAt(0));
                rest = rest.substring(1, rest.length());
                if(rest.contains(c)){
                    rest = rest.replaceAll(c, "");  // 替换字符串中的子字符串
                }else{
                    return c.charAt(0);
                }
            }
        }
        return ' ';
    }
}
class test_offer_50{
    public static void main(String[] args) {


    }
}
