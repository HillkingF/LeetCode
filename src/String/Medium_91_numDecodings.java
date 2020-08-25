package String;

public class Medium_91_numDecodings {
    public static void main(String[] args){
        String s = "12344";
    }
    public static int numDecodings(String s) {
        // 字母从 1-26 ，所以不可能出现单个字符小于1 或两个字母大于26
        // 特殊规则：0一定跟前面1个一组。 7,8,9前面是1可以一组，大于等于2不能一组
        // 用动态规划的方法-----
        return 0;

    }
}
