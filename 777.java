class Solution {
    public boolean canTransform(String start, String end) {
        int n = start.length();
        if(n!=end.length()) return false;
        String ss="",ee="";
        int sl=0,sr=0,el=0,er=0;
        for(int i=0;i<n;i++){
            char s = start.charAt(i);
            char e = end.charAt(i);
            if(s=='R'){ss+='R';sr++;}
            if(s=='L'){ss+='L';sl++;}
            if(e=='R'){ee+='R';er++;}
            if(e=='L'){ee+='L';el++;}
            if(sr<er||sl>el) return false;
        }
        return ss.equals(ee);
    }
}