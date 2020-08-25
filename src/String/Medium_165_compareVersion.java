package String;

public class Medium_165_compareVersion {
    public static void main(String[] args){
        String v1 = "0.1";
        String v2 = "1.0";
        int x = compareVersion(v1, v2);
        System.out.print(x);

    }
    public static int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");

        int len = v1.length <= v2.length ? v1.length : v2.length;
        int v1str = 0, v2str = 0;
        int i = 0;
        for(i = 0; i < len; i++){
            v1str = Integer.parseInt(v1[i]);
            v2str = Integer.parseInt(v2[i]);
            if(v1str > v2str)return 1;
            else if(v1str < v2str)return -1;
        }
        if( v1.length == v2.length){ // return res;
        }else{
            if(i == v1.length){//说明v1完了
                for(i = i + 0; i < v2.length; i++){
                    v2str = Integer.parseInt(v2[i]);
                    if(v2str > 0)return -1;
                }
            }else{
                for(i = i + 0; i < v1.length; i++){
                    v1str = Integer.parseInt(v1[i]);
                    if(v1str > 0)return 1;
                }
            }
        }
        return 0;
    }

}
