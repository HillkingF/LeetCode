package String;

import java.util.TreeMap;

public class Medium_468_validIPAddress {
    public static void main(String[] args){
        String IPv4 = "1e1.4.5.6";
        String IPv6 = "20EE:FGb8:85a3:0:0:8A2E:0370:7334";
        String res = validIPAddress(IPv6);
        System.out.println(res);
    }
    public static String validIPAddress(String IP) {
        String[] IPs;
        if(IP.split("\\.").length == 4){
            IPs = IP.split("\\.");  // 按照字符划分
            for(int i = 0; i < 4; i++){
                if(compare(IPs[i], 4) == false)return "Neither";
            }
            if(IP.charAt(0)!='.' && IP.charAt(IP.length()-1) != '.')return "IPv4";
            else return "Neither";
        }else if(IP.split(":").length == 8){
            IPs = IP.split(":");  // 按照字符划分
            for(int i = 0; i < 8; i++){
                if(compare(IPs[i], 6) == false) return "Neither";
            }
            if(IP.charAt(0)!=':' && IP.charAt(IP.length()-1) != ':')return "IPv6";
            else return "Neither";
        }else return "Neither";
    }
    public static boolean compare(String str, int version){
        boolean res = true;
        if(version == 4){
            if(str.equals("") || (str.length() > 1 && str.charAt(0) == '0') ) res = false;
            else{
                try{
                    if((Integer.parseInt(str) < 0 )||(Integer.parseInt(str) > 255))res = false;
                }catch (NumberFormatException e) {
                    res = false;
                }
            }
            return res;
        }else if(version == 6){
            String dict = "0123456789abcdefABCDEF";
            if(str.equals("") || str.length() > 4 ||
                    (str.length() > 1 && str.substring(0,2) == "00")) res = false;
            else{
                for(int i = 0; i < str.length(); i++){
                    if(dict.indexOf(str.charAt(i)) == -1){
                        res = false;
                        break;
                    }
                }
            }
            return res;
        }
        return false;
    }
}
