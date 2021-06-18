package offer;

import java.util.Collections;


// 位运算  异或运算的经典题目

/**
 * 四个异或运算的规则:
 * 1. Java两个数进行异或^操作: 相当于两个数的二进制逐位进行异或操作
 * 2. 0 ^ 任何数字 = 数字本身
 * 3. 任何数字 ^ 本身 = 0
 * 4. 交换律: a^b^c = a^c^b
 */
public class offer_56 {
    public int[] singleNumbers(int[] nums) {
        // 1. 获得所有数字的异或结果 x
        // 最终x 是 两个只出现了一次的元素 a 和 b 的异或结果
        int x = 0;
        for (int i = 0; i < nums.length;  i++) {
            x = x ^ nums[i];
        }

        // 2. x的二进制每一位, 等于1表示a和b在这一位不相同, 等于0表示a和b在这一位相同
        // 因此将所有数字分为两组:
        // 选择x中任意为 1 的位置 y, 说明a和b在第y位是不同的: a[y]为0,[b]为1
        // 因此nums中所有 第y位为 0 的分为一组, 第y位为1的分为一组
        // 下面寻找x中第一个为 1的位置(二进制数字表示)  y
        int y = 1;  // 若x=111,则实际上y=001; 110,001
        while((y & x) == 0){ // 两个数没有一位相同,则按位&结果为0; 两个数有位相同,则结果一定不为0
            y = y << 1;      // y * 2, y左移1位
        }

        // 3.按照y 将 所有数字分成两组分开异或,最终a和b就是每一组的唯一值
        int a = 0, b = 0;
        for (int i = 0; i < nums.length; i++) {
            if((nums[i] & y) == 0){
                a = a ^ nums[i];
            }else{
                b = b ^ nums[i];
            }
        }
        return new int[]{a, b};

    }
}

class test_offer_56_1{
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        offer_56 test = new offer_56();
        test.singleNumbers(nums);
    }
}
