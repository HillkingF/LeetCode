package offer;



public class offer_20 {
    public boolean isNumber(String s) {
        // 首先删除首尾的空格
        s = s.trim();
        if (s.equals("")) return false;
        // 根据e或者E将s进行分段: 最多只能为两段
        s = s.replace("e", "E");
        if(s.charAt(0)=='E' || s.charAt(s.length()-1) == 'E') return false;
        String[] t = s.split("E");

        if(t.length == 0) return false;
        if (t.length > 2) return false;
        if (t[0].equals("")) return false;
        if (t.length == 2 && t[1].equals("")) return false;

        // 第0段儿可以是小数或者整数
        String s1 = t[0];
        String[] point = s1.split("\\.");
        System.out.println(point[0]);
        System.out.println(point.length);
        if(point.length == 0) return false;
        if (point.length > 2) return false;// 说明有多个点
        if (point.length == 1) {  // 说明没有点
            if (!isNum(point[0])) return false;
        }
        if (point.length == 2) { // 说明有一个点
            if(point[0].equals("") && point[1].equals("")) return false;
            else if(!point[0].equals("") && point[1].equals("")){
                if(!isNum(point[0])) return false;
            }else if(!point[1].equals("") && point[0].equals("")){
                for(int i = 0; i < point[1].length(); i++){
                    if(Character.isDigit(point[1].charAt(i))){
                    }else{
                        return false;
                    }
                }
            }else{
                if(!isNum(point[0])) return false;
                for(int i = 0; i < point[1].length(); i++){
                    if(Character.isDigit(point[1].charAt(i))){
                    }else{
                        return false;
                    }
                }
            }
        }

        //如果有第二段，只能是整数
        if(t.length == 2){
            if(!isNum(t[1])) return false;
        }
        return true;
    }



    public boolean isNum(String s){
        System.out.println(s);
        for(int i = 0; i < s.length(); i++){
            if( i == 0){
                if(s.charAt(0)=='-' || s.charAt(0)=='+'){
                    if(s.length() == 1)return false;
                }else if(Character.isDigit(s.charAt(0))){
                }else return false;
                System.out.println(0);
            }else {
                if(Character.isDigit(s.charAt(i))){
                }else{
                    return false;
                }
                System.out.println(i);
            }
        }
        return true;
    }
}


class t{
    public static void main(String[] args) {
        String x = "123.";
        String[] x1 = x.split(".");
        System.out.println(x1.length);


        String s= "12e";
        offer_20 r = new offer_20();
        boolean res = r.isNumber(s);
        System.out.println(res);
    }
}