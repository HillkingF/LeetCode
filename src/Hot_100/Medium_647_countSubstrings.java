package Hot_100;

public class Medium_647_countSubstrings {
    public static void main(String[] args) {
        String s = "dwucbwinnnnnn";
        String s1 = "aaa";

        System.out.println(countSubstrings(s1));
    }
    /*  [思路]
    使用动态规划，
    创建f[i][j]表示子字符串i-j是否回文；
    i始终小于等于j
    i从尾部往0的方向遍历，j从i开始向尾部遍历。
    因此每一轮循环开始，都只判断i=j位置上的字符是否回文；
    并且每一轮开始，i=j位置的字符都是新增加的字符，i之后所有字符中的回文串个数已经判断过了。
    因此此时只用判断所有从i开始，到末尾的每一组字符串是否是回文串即可。只要是回文串，count就+1
    此外。每一次判断i-j的字符串是否回文，只用判断i，j位置上的字符是否相等：
    - 不相等，直接跳过
    - 相等：判断 i+1 -> j-1 内的字符串是否回文。如果回文，i->j是回文的。此时count++


    */
    public static int countSubstrings(String s) {
        boolean[][] f = new boolean[s.length()][s.length()];  // f的坐标表示自字符串的首尾.f表示i到j是否是回文串
        int count = 0; // 遍历过程中只要有回文串，个数就+1

        for(int i = s.length()-1; i >= 0; i--){  // 逆序遍历  i 始终是前一个坐标
            for(int j = i; j < s.length(); j++){  // j始终始终是i后面的坐标
                // i逆序，j正序可以保证遍历到的子串已经判断过了
                if(s.charAt(i) != s.charAt(j)){
                    f[i][j] = false;
                    continue;
                }else{ // i， j 位置的字符相等
                    f[i][j] = i + 2 >= j || f[i+1][j-1];  // i,j位置字符相等时：① 如果i-j最多只有三个字符则一定回文，否则收缩判断内部字符串是否回文
                }
                if(f[i][j]) {
                    count ++;
                }
            }
        }
        return count;

    }

}
