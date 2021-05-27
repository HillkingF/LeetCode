package offer;

public class offer_33 {
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
        return false;
    }
}
