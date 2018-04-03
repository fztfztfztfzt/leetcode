class Solution {
    public String licenseKeyFormatting(String S, int K) {
        StringBuilder sb = new StringBuilder();
        int pos = S.length()-1;
        int i=0;
        while(pos>=0){
            while(pos>=0&&S.charAt(pos)=='-') pos--;
            if(pos<0) break;
            char c = S.charAt(pos);
            if(c-'a'>=0) c=(char)(c-'a'+'A');
            i++;
            sb.append(c);
            if(i==K){
                sb.append('-');
                i=0;
            }
            pos--;
        }
        String res = sb.reverse().toString();
        if(res.equals("")) return res;
        if(res.charAt(0)=='-') return res.substring(1,res.length());
        return res;
    }
}