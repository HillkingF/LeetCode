package dontnowhere_100;

public class Hard_42_trap {
    /**
     * 只有先降低再升高的时候才会接雨水
     * 确定局部最高点，计算其中所有的体积，减去柱子的格子数量
     */
    public static void main(String[] args){
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        int res = trap1(height);
        System.out.println(res);
    }
    public static int trap(int[] height) {
        int res = 0;
        int[] upAndDownArr = new int[height.length];
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

        max = 1;
        for(int i = height.length-1; i >= maxloc; i--){
            if(height[i] >= max){
                downarr[i] = height[i];
                max = height[i];
            }
        }

        int lastloc = -1;
        int thisloc = 0;
        for (int i = 0; i < uparr.length; i++) {
            if(uparr[i] != 0){
                if(lastloc == -1){ // 第一个上限
                    lastloc = i; // 找到上限的位置
                }else{
                    thisloc = i;
                    int len = uparr[lastloc];
                    // 计算 lastloc 和 thisloc 之前的水滴个数
                    for(int j = lastloc; j < thisloc; j++){
                        res = res +  (len - height[j]);
                    }
                    lastloc = thisloc;
                }
            }
        }
        for(int i = height.length-1; i >= maxloc; i--){
            if(downarr[i] != 0){
                if(i == height.length - 1){
                    lastloc = height.length -1;
                }else{
                    thisloc = i;
                    int len = downarr[lastloc];
                    for(int j = thisloc + 1; j <= lastloc; j++){
                        res += (len - height[j]);
                    }
                    lastloc = thisloc;
                }
            }
        }
        return res;


    }
    public static int trap1(int[] height) {
        int res = 0;
        int max = 1;  // 初始高度至少为1，才能可以开始接水
        int maxloc = 0;
        int lastloc = -1;
        int thisloc;
        int len;
        int[] upAndDownArr = new int[height.length];

        for (int i = 0; i < height.length; i++) {
            upAndDownArr[i] = 0;
            if(height[i] >= max){
                upAndDownArr[i] = height[i];
                max = height[i];
                maxloc = i;
            }
        }

        for (int i = 0; i < upAndDownArr.length; i++) {
            if(upAndDownArr[i] != 0){
                if(lastloc == -1){  lastloc = i; // 找到上限的位置
                }else{
                    thisloc = i;
                    len = upAndDownArr[lastloc];
                    for(int j = lastloc; j < thisloc; j++){ // 计算 lastloc 和 thisloc 之前的水滴个数
                        res = res +  (len - height[j]);
                    }
                    lastloc = thisloc;
                }
            }
        }

        max = 1;
        for(int i = height.length-1; i >= maxloc; i--){
            upAndDownArr[i] = 0;
            if(height[i] >= max){
                upAndDownArr[i] = height[i];
                max = height[i];
            }
        }

        for(int i = height.length-1; i >= maxloc; i--){
            if(upAndDownArr[i] != 0){
                if(i == height.length - 1){ lastloc = height.length -1;
                }else{
                    thisloc = i;
                    len = upAndDownArr[lastloc];
                    for(int j = thisloc + 1; j <= lastloc; j++){
                        res += (len - height[j]);
                    }
                    lastloc = thisloc;
                }
            }
        }
        return res;


    }
}
