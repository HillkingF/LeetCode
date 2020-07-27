package Array;

public class Medium_11_MostWater {
    public static void main(String[] args){
        Solution11 s = new Solution11();
        int[] height = {1,8,6,2,5,4,8,3,7};
        int maxwater = s.maxArea(height);
        System.out.println(maxwater);
    }
}

class Solution11 {
    public int maxArea(int[] height) {
        // 使用双指针的方法（两端分别移动可以使用双指针）
        // 分别在数组两端定义双指针，记录最大容积。
        // 之后移动短边的指针（因为移动长边指针容积只会变小或不变，而移动短边指针容积可能会增大）
        if(height.length < 1){
            return 0;
        }else{
            int p1 = 0, p2 = height.length-1;
            int bottomlen = 0;
            int maxwater = -1;
            while(p2 > p1){
                bottomlen = p2 - p1;
                int newmaxwater = bottomlen * Math.min(height[p2], height[p1]);
                if(newmaxwater > maxwater){
                    maxwater = newmaxwater;
                }
                if(height[p1] >= height[p2]){
                    p2--;
                }else{
                    p1++;
                }
            }
            return maxwater;
        }

    }
}
