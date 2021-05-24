package offer;

public class offer_12 {
    private int[][] find;
    public boolean exist(char[][] board, String word) {
        if(board == null || board.length == 0 || board.length * board[0].length < word.length()) return false;
        find = new int[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                find[i][j] = 0;
            }
        }
        Boolean res = false;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                 res = seek(board, word,0, i, j);
                 if(res) return res;
            }
        }
        return res;
    }
    public boolean seek(char[][] board, String word,int index, int i, int j) {
        // 1. 判断[i, j] 位置的元素是不是目标字符: 是:继续向四个方向遍历, 不是:返回false
        if(find[i][j] == 0 && board[i][j] == word.charAt(index)){
            // 2.将目前的这一位标记为已访问
            int[] grid = {i, j};
            find[i][j] = 1;
            // 3.如果index已经是最后一个字符了,则直接返回true
            if (index == word.length() - 1) return true;
            // 4.如果还有没有未查找到的字符,开始向四个方向延伸
            Boolean up = false, right= false, down= false, left = false;
            if(i > 0) up = seek(board, word, index + 1, i - 1, j);
            if(j < board[0].length-1) right = seek(board, word, index + 1, i , j + 1);
            if(i < board.length-1) down = seek(board, word, index + 1, i + 1 , j);
            if(j > 0) left = seek(board, word, index + 1, i , j - 1);
            if(up || right | down ||left) return true;
            else{
                find[i][j] = 0;
                return false;
            }
        }else{
            return false;
        }
    }
}
