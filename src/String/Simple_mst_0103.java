package String;

public class Simple_mst_0103 {
    public String replaceSpaces(String S, int length) {
        /**
         * 思路：
         * 先遍历一遍统计其中空格的数量
         * 再移动
         */
        char[] c0 = S.toCharArray();
        int num = 0;
        for(int i = 0; i < length; i++){
            if(c0[i] == ' ') num ++;
        }
        char[] c1 = new char[length + num * 2];
        int index  = 0;
        for(int i = 0; i < length; i++){
            if(c0[i] == ' '){
                c1[index++] = '%';
                c1[index++] = '2';
                c1[index++] = '0';
            }else{
                c1[index++] = c0[i];
            }
        }
        String res = String.valueOf(c1);
        return res;


    }
}
