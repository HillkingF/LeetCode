package dontnowhere_100;

public class Hard_42_trap {
    /**
     * 只有先降低再升高的时候才会接雨水
     * 确定局部最高点，计算其中所有的体积，减去柱子的格子数量
     * @param height
     * @return
     */
    public int trap(int[] height) {
        int res = 0;
        int[] uparr = new int[height.length]; // 维护了一个单调递增的序列（包含连续相同的项）
        int[] downarr = new int[height.length]; // 维护了一个单调递减的序列（包含连续相同的项）
        int max = 1;  // 初始高度至少为1，才能可以开始接水
        int maxloc = 0;
        for (int i = 0; i < height.length; i++) {
            uparr[i] = 0;
            downarr[i] = 0;
            if(height[i] >= max){
                uparr[i] = height[i];
                max = height[i];
                maxloc = i;
            }
        }

        // 开始找递减序列
        for(int i = height.length; i >= maxloc; i++){

        }

        int lastloc = 0;
        int thisloc = 0;
        for (int i = 0; i < uparr.length; i++) {
            if(uparr[i] != 0){
                if(lastloc == 0){ // 第一个上限
                    lastloc = i; // 找到上限的位置
                }else{
                    thisloc = i;
                    int len = uparr[lastloc];
                    // 计算 lastloc 和 thisloc 之前的水滴个数
                    for(int j = lastloc; j < thisloc; j++){
                        res += (len - height[j]);
                    }
                    lastloc = thisloc;
                }
            }else{

            }
        }


    }
}
