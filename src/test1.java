import java.util.ArrayList;

public class test1 {
    public static void main(String[] args) {
        // 1.测试一下,使用有参构造创建列表数组,且容量为0时的容量大小. 结果注释在源码44行
        ArrayList arrayList = new ArrayList(0);
        System.out.println(arrayList.size());
    }
}
