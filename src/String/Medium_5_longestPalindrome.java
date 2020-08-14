package String;

public class Medium_5_longestPalindrome {
    public static void main(String[] args) {
        String s = "babad";
        String s2 = longestPalindrome(s);
        System.out.print(s2);
    }

    public static String longestPalindrome(String s) {
        int max = 1;
        int start = 0, end = 0;
        int l = 0, r = 0;
        int tstart, tend;
        int t;
        int count = 0;
        if (s.length() <= 1) return s;
        for (r = 1; r < s.length(); r++) {
            if (r == 1) {
                if (s.charAt(r) == s.charAt(r - 1)) {
                    start = l;
                    end = r;
                    max = 2;
                }
            } else {
                if(!(s.charAt(r) == s.charAt(r - 1) && s.charAt(r) == s.charAt(r - 2))){
                    t = r;
                    count = 0;
                    int sign = 0;
                    if(s.charAt(r) == s.charAt(r - 1) && s.charAt(r) != s.charAt(r - 2)){tstart = t; sign = 1;}
                    else {tstart = t-1; sign = 2;}
                    while (t < s.length() && t - 2 * count - sign > -1) {
                        if (s.charAt(t) == s.charAt(t - 2 * count - sign)) {
                            tstart = tstart - 1;
                            tend = t;
                            if (tend - tstart + 1 > max) {
                                max = tend - tstart + 1;
                                start = tstart;
                                end = tend;
                            }
                            count++;
                            t++;
                        } else break;
                    }// while
                } else if (s.charAt(r) == s.charAt(r - 1) && s.charAt(r) == s.charAt(r - 2)) {
                    int y = r-2, z = r;
                    while(y > -1){
                        if(s.charAt(y) == s.charAt(r -2)) y--;
                        else break;
                    }
                    y++;
                    while(z < s.length()){
                        if(s.charAt(z) == s.charAt(r))z++;
                        else break;
                    }
                    z--;
                    int cuowei = 0;
                    t = r;
                    count = 0;
                    if((z-y+1) % 2 == 0) {cuowei = 1; tstart = t;}
                    else {cuowei = 2; tstart = t-1;}
                    while (t < s.length() && t - 2 * count - cuowei > -1) {
                        if (s.charAt(t) == s.charAt(t - 2 * count - cuowei)) {
                            tstart = tstart - 1;
                            tend = t;
                            if (tend - tstart + 1 > max) {
                                max = tend - tstart + 1;
                                start = tstart;
                                end = tend;
                            }
                            count++;
                            t++;
                        } else break;
                    }// while
                }
                }
            }//for
            return s.substring(start, end + 1);
        }
    }
