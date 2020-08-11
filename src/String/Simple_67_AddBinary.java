package String;

public class Simple_67_AddBinary {
    public static void main(String[] args){
        String a = "1010";
        String b = "1011";
        String c = addBinary(a,b);
        System.out.print(c);
    }

    public static String addBinary(String a, String b) {
        int pa = a.length() - 1;
        int pb = b.length() -1;
        int sum;
        String s = "";
        char sign = '0';
        while(pa > -1 && pb > -1){
            sum = Integer.parseInt(Character.toString(a.charAt(pa))) +
                    Integer.parseInt(Character.toString(b.charAt(pb))) +
                    Integer.parseInt(Character.toString(sign));
            s = Integer.toString(sum%2) + s;
            if (sum > 1) sign = '1';
            else sign = '0';
            pb--;
            pa--;
        }
        if(pa == -1 && pb == -1){
            if(sign == '1')s = sign + s;
        }else if(pa == -1){
            while(pb > -1){
                sum = Integer.parseInt(Character.toString(b.charAt(pb))) +
                        Integer.parseInt(Character.toString(sign));
                s = Integer.toString(sum%2) + s;
                if (sum > 1) sign = '1';
                else sign = '0';
                pb--;
            }
            if(pb == -1){
                if(sign == '1')s = sign + s;
            }
        }else if(pb == -1){
            while(pa > -1){
                sum = Integer.parseInt(Character.toString(a.charAt(pa))) +
                        Integer.parseInt(Character.toString(sign));
                s = Integer.toString(sum%2) + s;
                if (sum > 1) sign = '1';
                else sign = '0';
                pa--;
            }
            if(pa == -1){
                if(sign == '1')s = sign + s;
            }
        }
        return s;
    }
}
