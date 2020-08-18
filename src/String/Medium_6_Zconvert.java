package String;

public class Medium_6_Zconvert {
    public static void main(String[] args){
        String s = "PAYPALISHIRING";
        int n = 9;
        String a = convert(s,n);
        System.out.print(a);

    }
    public static String convert(String s, int numRows) {
        String[][] stemp = new String[numRows][1];
        if(s.length() <= numRows || numRows == 1) return s;
        for(int c = 0; c < numRows; c++) stemp[c][0] = "";
        int onepart = 2*numRows - 2;
        int yushu = s.length() % onepart == 0 ? 0 : 1;
        int layers = s.length()/(onepart) + yushu;
        int rows, dirc, end;
        int num;
        for(int i = 1; i <= layers; i++){
            rows = 0;
            dirc = 0;
            num = onepart * (i - 1);
            if(yushu == 1 && i == layers)end = s.length();
            else end = num + onepart;
            for (int j = num; j < end; j++){
                if(rows == numRows){
                    dirc = 1;
                    stemp[rows-2][0] += s.substring(j, j + 1);
                    rows = rows - 3;
                }else{
                    if(dirc == 1)stemp[rows--][0] += s.substring(j, j + 1);
                    else stemp[rows++][0] += s.substring(j, j + 1);
                }
            } // for 2
        }// for 1
        for(int k = 1; k < numRows; k++ )stemp[0][0] += stemp[k][0];
        return stemp[0][0];

    }
}
