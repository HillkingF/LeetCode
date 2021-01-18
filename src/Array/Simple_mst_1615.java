package Array;

public class Simple_mst_1615 {
    public int[] masterMind(String solution, String guess) {
        char[] s = solution.toCharArray();
        char[] g = guess.toCharArray();
        int[] res = {0, 0};

        // 第一遍先遍历是否有 “猜中” 的情况
        for(int i = 0; i < 4; i++){
            if(s[i] == g[i]){
                res[0] += 1;
                s[i] = 'P';
                g[i] = 'Q';
            }
        }
        // 第二遍再判断是否有“伪猜中” 的情况
        for(int i = 0; i < 4; i++){
            if(g[i] != 'Q'){
                for(int j = 0; j < 4; j++){
                    if(s[j] == g[i]){
                        res[1] += 1;
                        s[j] = 'P';
                        break;
                    }
                }
            }
        }
        return res;

    }
}
