package Array;

public class Simple_mst_1001 {
    public void merge(int[] A, int m, int[] B, int n) {
        /**
         * 思路：
         * 数组线性表的合并:
         * 不能像链表一样随便更改指针地址
         *
         * 可以这么做：
         * 两个数组倒序遍历，每次将一个大的元素从后往前排列
         * 边界情况：
         * A 一个元素都没有， m = 0；
         */
        if( m == 0){
            for(int i = 0; i < n; i++){
                A[i] = B[i];
            }
        }else if(n == 0){
        }else{
            int alast  = m - 1;
            int blast = n - 1;
            int input = m + n -1;

            while(blast >= 0 && alast >= 0){
                if(B[blast] >= A[alast]){
                    A[input] = B[blast];
                    input --;
                    blast --;
                }else{
                    A[input] = A[alast];
                    alast --;
                    input --;
                }
            }
            // 判断剩余的b
            if(alast < 0 && blast >= 0){
                while (blast >= 0){
                    A[input] = B[blast];
                    input --;
                    blast --;
                }
            }
        }
    }


    public void merge1(int[] A, int m, int[] B, int n) {
        /**
         * 思路：
         * 对上面方法的改进
         */

        int alast  = m - 1;
        int blast = n - 1;
        int input = m + n -1;

        while(blast >= 0 && alast >= 0){
            if(B[blast] >= A[alast]){
                A[input] = B[blast];
                input --;
                blast --;
            }else{
                A[input] = A[alast];
                alast --;
                input --;
            }
        }
        // 判断剩余的b
        if(alast < 0 && blast >= 0){
            while (blast >= 0){
                A[input] = B[blast];
                input --;
                blast --;
            }
        }

    }
}
