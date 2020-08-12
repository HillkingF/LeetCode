package String;

public class Simple_344_ReverseString {
    public static void main(String[] args){
        char[] s = {'h', 'e', 'l', 'l', 'o', 'p'};
        reverseString(s);

    }
    public static void reverseString(char[] s) {
        int loc = 0;
        char chartemp;
        while(loc < s.length/2){
            chartemp = s[loc];
            s[loc] = s[s.length-1-loc];
            s[s.length-1-loc] = chartemp;
            loc++;
        }
    }
}
