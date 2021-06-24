package offer;



// 分治的思想：与对角线的元素比较，然后分成上下左右四个块分治比较
public class offer_04 {
    /*任意一个子长方型,
    左上角的元素一定是最小的,
    右下角的元素一定是最大的,
    另外两个角的元素大小不一定*/

    /*
    * [1,   4,  7, 11, 15],
      [2,   5,  8, 12, 19],
      [3,   6,  9, 16, 22],
    *
    *
    * */
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if(matrix.length == 0 || matrix == null) return false;
        return f(matrix, target, 0,0, matrix.length-1, matrix[0].length-1);

    }

    // 将整个数组分成四块分治判断：以对角线上的元素与target比较大小进行分治判断
    public boolean f(int[][] m, int t, int is, int js, int ix, int jx){
        if(is > ix || js > jx) return false;
        // 说明这个整块的数全都小于或者大于t
        if(m[is][js] > t || m[ix][jx] < t) return false;

        // 比较此块中的对角线大小
        int i = is;
        int j = js;
        while(i <= ix && j <= jx){
            if(m[i][j] == t)return true;
            else if(m[i][j] < t){
                i ++;
                j ++;
            }else{
                break;
            }
        }

        boolean zuos = false;
        boolean yous = false;
        boolean zuox = false;
        boolean youx = false;

        yous = f(m,t,is,j,i-1,jx);
        zuox = f(m,t,i,js,ix,j-1);
        youx = f(m,t,i,j,ix,jx);
        return zuos || yous || zuox || youx;
    }


}


class test_offer_04{
    public static void main(String[] args) {
        offer_04 test = new offer_04();
        int[][] m = {{-1,3}};
        System.out.println(test.findNumberIn2DArray(m, 3));

    }
}
