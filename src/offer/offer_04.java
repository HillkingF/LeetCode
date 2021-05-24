package offer;

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
        int rows = matrix.length;
        int cols = matrix[0].length;
        if(target < matrix[0][0] || target > matrix[rows-1][cols-1]) return false;
        for (int i = 0; i < rows; i++) {  // 比较表格的最后一列: 列不变,行改变
            if(matrix[i][cols-1] < target){

            }else if(matrix[i][cols] == target ){
                return true;
            }else{ // 说明target一定不在这一行之前


            }


        }



        if(rows < cols){
            for (int i = rows - 1; i >= 0; i--) { // 行数大于列数,从整图右下角的位置开始向内比较


            }
        }else if(rows > cols){
            for (int i = cols - 1; i >= 0; i--) {

            }
        }else{
            for (int i = 0; i < rows; i++) { // 行数和列数下相等,因此从左上角的第一个点开始,向右下角方向比较
                if(matrix[i][i] < target){ // 继续向右下角的方向比较
                }else if(matrix[i][i] > target){ // 说明已经有上限了
                    for (int j = 0; j < i; j++) {
                        if(matrix[i][j] == target) return true;
                        if(matrix[j][i] == target) return true;
                    }
                }else{  // 说明角角上的这个值就是目标值,直接返回找到了
                    return true;
                }
            }
            return false;
        }
        return false;
    }

}
