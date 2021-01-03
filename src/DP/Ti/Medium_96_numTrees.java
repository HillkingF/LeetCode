package DP.Ti;

public class Medium_96_numTrees {
    public int numTrees(int n) {
        /**
         * 【知识点】
         * 二叉搜索树：任意一个点的左子树值<根<右子树
         * 【思路】
         * 1、最后一步：以每一个数字为根节点时，分别可以得到几个二叉搜索树
         * 2、子问题：将每一个数字为根节点的二叉搜索树的个数相加
         * 3、.......【这道题其实没什么思路，直接看了题解】
         *
         */
        if(n == 0) return 1;
        int[] f = new int[n+1]; // 长度为n的序列可以构成的二叉搜索树的个数
        f[0] = 1; // 一个节点都没有时，好似空树，也可以算作一棵二叉搜索树
        f[1] = 1;
        for(int i = 2; i <= n; i++){
            for(int j = 1; j <= i; j++){
                f[i] += f[j-1] * f[i - j];
            }
        }
        return f[n];


    }
}
