class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        int len = s.length();
        for(int a=1;a<=3&&a<=len;a++){
            for(int b=a+1;b<=a+3&&b<=len;b++){
                for(int c=b+1;c<=b+3&&c<=len;c++){
                    String s1 = s.substring(0,a);
                    String s2 = s.substring(a,b);
                    String s3 = s.substring(b,c);
                    String s4 = s.substring(c,s.length());
                    if(valid(s1)&&valid(s2)&&valid(s3)&&valid(s4)){
                        result.add(s1+"."+s2+"."+s3+"."+s4);
                    }
                }
            }
        }
        return result;
    }
    private boolean valid(String s){
        if(s.length()==0) return false;
        if(s.length()>3) return false;
        if(s.length()>1&&s.charAt(0)=='0') return false;
        System.out.println(s);
        if(Integer.valueOf(s)>255) return false;
        return true;
    }
}