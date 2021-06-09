package offer;

import sun.awt.image.OffScreenImage;

public class offer_40 {
    // 排序 + 输出
    // 首先对数组进行排序: 使用快排

    // 如果没有重复数字
    public int[] getLeastNumbers(int[] arr, int k) {
        paixu(arr,0, arr.length-1);  // 这个函数的问题
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = arr[i];
        }
        return res;
    }

    public void paixu(int[] arrnum, int start, int end){
        if(start >= end) return;
        int out = arrnum[start];
        int i = start;
        int j = end;
        // 首先j从后往前找比out小的数字
        while(i < j){
            while( i < j){
                if(arrnum[j] >= out) j--;
                else break;
            }
            if(i < j)  arrnum[i++] = arrnum[j];
            while (i < j){
                if(arrnum[i] <= out) i++;
                else break;
            }
            if(i < j)  arrnum[j--] = arrnum[i];
        }
        if( i == j )arrnum[i] = out;
        paixu(arrnum, start, i-1);
        paixu(arrnum ,i + 1, end);
    }

}

class test{
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        offer_40 test = new offer_40();

        int[] res = test.getLeastNumbers(arr, 2);
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }
    }
}
