package String;

public class Medium_6_Zconvert {
    public static void main(String[] args){
        String s = "PAYPALISHIRING";
        int n = 9;
        String a = convert(s,n);
        System.out.print(a);

    }
    public static String convert(String s, int numRows) {
        if(s.length() <= numRows || numRows == 1) return s;
        String[][] stemp = new String[numRows][1];
//        for(int c = 0; c < numRows; c++){
//            stemp[c][0] = "";
//        }
        int layers = s.length()/(2*numRows - 2);
        // 最后一层先待定
        int sign = 0;
        if(s.length() % (2*numRows - 2) != 0){
            sign = 1;
            layers++;
        }

        int rows;
        int i = 1;
        int j = 0;
        int dirc = 0;
        for(i = 1; i <= layers; i++){
            rows = 0;
            if(sign == 1 && i == layers){
                dirc = 0;
                for ( j = (2*numRows - 2) * (i - 1); j < s.length(); j++){
                    if(rows == 0){
                        stemp[0][0] = stemp[0][0] + s.substring(j, j+1);
                        rows++;
                    }else if(rows == numRows){
                        rows = rows - 2;
                        stemp[rows][0] += s.substring(j, j + 1);
                        dirc = 1;
                    }else {
                        if(dirc == 1){
                            rows--;
                            stemp[rows][0] += s.substring(j, j + 1);
                        }else {
                            stemp[rows][0] += s.substring(j, j + 1);
                            rows ++;
                        }
                    }
                } // for 2
            }else{
                dirc = 0;
                for (j = (2*numRows - 2) * (i - 1); j < (2*numRows - 2) * i; j++){
                    if(j == (2*numRows - 2) * (i - 1)){
                        stemp[0][0] += s.substring(j, j+1);
                        rows++;
                    }else if(rows == numRows){
                        dirc = 1;
                        rows = rows - 2;
                        stemp[rows][0] += s.substring(j, j + 1);
                        rows--;
                    }else if(rows > 0 && rows < numRows){
                        stemp[rows][0] += s.substring(j, j + 1);
                        if(dirc == 1){
                            rows--;
                        }else{
                            rows++;
                        }

                    }
                } // for 2
            }

        }// for 1

        String str = "";
        for(int k = 0; k < numRows; k++ ){
            str += stemp[k][0];
        }
        return str;

    }
}
