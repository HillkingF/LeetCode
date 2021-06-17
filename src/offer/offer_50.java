package offer;

public class offer_50 {
    public char firstUniqChar(String s) {
        return ' ';
    }
}
class test_offer_50{
    public static void main(String[] args) {
        String x= "azuwcvuw";
        String y = x.replace('a', ' ');
        String z = x.replaceAll("a", "");
        System.out.println(y);
        System.out.println(x);
        System.out.println(z);

    }
}
