package Hot_100;

public class Medium_647_countSubstrings {
    public static void main(String[] args) {
        String s = "dwucbwinnnnnn";
        String s1 = "aaa";

        System.out.println(countSubstrings(s1));
    }
    public static int countSubstrings(String s) {
        boolean[][] f = new boolean[s.length()][s.length()];  // f的坐标表示自字符串的首尾.f表示i到j是否是回文串
        int count = 0; // 遍历过程中只要有回文串，个数就+1

        for(int i = s.length()-1; i > 0; i++){  // 逆序遍历  i 始终是前一个坐标
            for(int j = i; j < s.length(); j++){  // j始终始终是后一个坐标
                // i逆序，j正序可以保证遍历到的子串已经判断过了
                if(s.charAt(i) != s.charAt(j)){
                    f[i][j] = false;
                    continue;
                }else{ // i， j 位置的字符相等
                    f[i][j] = i + 2 <= j || f[i+1][j-1];
                }

            }


        }


    }

}
