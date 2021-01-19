package String;

public class Simple_mst_0109 {
    public boolean isFlipedString(String s1, String s2) {
        /**
         * 思路：
         * ①两个不一样长，一定不是
         * ②两个一样长：
         * 从第一网格位置开始判断子串拼接后是不是等于s2
         */
        if(s1.length() != s2.length()) return false;
        else if(s1.equals(s2)) return true;
        else{
            for(int i = 0; i < s1.length()-1; i++){
                String tmp = s1.substring(i + 1, s1.length()) + s1.substring(0, i + 1);
                if(tmp.equals(s2)){
                    return true;
                }
            }
            return false;
        }

    }

    public boolean gaijin(String s1, String s2){
        /**
         * 改进：
         * 将 s2和s2 自身拼接，
         * 如果拼接后包含s1，说明拼接后的一半是s1，另外一半还是s1
         */
        if(s1.length() != s2.length()) return false;
        String tmp = s2 + s2;
        if(tmp.contains(s1)) return true;
        else return false;
    }
}
