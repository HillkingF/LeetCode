package Tree;

public class test {
    public static void main(String[] args){
//        int i =1;
//        int sum = 0;
//        while(i <= 100){
//            sum = sum + i;
//            i+= 1;
//        }
//        System.out.print(sum);  //5050
        System.out.print(add(0,0));


    }
    public static int add(int a, int b){
        int sum = a;
        if( b < 100){
            sum = add(sum + b, b + 1);
        }else{
            sum = sum + b;
        }
        return sum;
    }
}
