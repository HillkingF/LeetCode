package offer;

public class offer_33 {
    /**
     * 二叉查找树（Binary Search Tree），（又：二叉搜索树，二叉排序树）
     * 左子树值 <= 根 <= 右子树值
     */
    public static void main(String[] args) {
        //int a = 1;
        //int b = 1;
        //System.out.println(a==b);
        //a = 289;
        //b = 289;
        //System.out.println(a==b);


        String a = "123cbeucveyvsccbve123cbeucveyvsccbve";
        String b = "123cbeucveyvsccbve123";

        System.out.println(a == b);
        System.out.println(a.equals(b));

        b = "123cbeucveyvsccbve123" + "cbeucveyvsccbve";
        System.out.println(a == b);
        System.out.println(a.equals(b));


    }
    public boolean verifyPostorder(int[] postorder) {
        if(postorder == null || postorder.length < 2) return true;



        return false;
    }


    public boolean verify(int[] postorder, int start, int end) {
        if( start == end) return true;
        // 1.确定这棵树根节点的位置: 一定是这一组数的最后一个
        int root = postorder[end];
        boolean left = true;
        boolean right = true;
        // 2. 找到左子树 和 右子树,并判断左右子树是否分别小于和大于树根
        int l = 0;  // 表示目前还是左子树
        int lend = -1;
        for (lend = start; lend < end; lend++) {
            if(postorder[lend] < root){
            }else{
                break;
            }
        }
        // 3.判断左子树是否存在,并开始遍历右子树
        for (int i = lend; i < ; i++) {

        }
        if(lend == start){  // 说明从start - end全是右子树
            left = true;
            for (int i = 0; i < ; i++) {
                
            }

        }else if(lend == end){ // 说明全是左子树
            left = true;
            right = true;
        }else{
            

        }

        return false;
    }
}
