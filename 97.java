class Solution {
    boolean[][] invalid;
    public boolean isInterleave(String s1, String s2, String s3) {
        invalid = new boolean[s1.length()+1][s2.length()+1];
        if(s1.length()+s2.length()!=s3.length()) return false;
        return isInterleave(s1,s2,s3,0,0,0);
    }
    private boolean isInterleave(String s1, String s2, String s3, int i1, int i2, int i3){
        if(invalid[i1][i2]) return false;
        if(i3==s3.length()){
            if(s1.length()==i1&&s2.length()==i2) return true;
            else return false;
        }
        char c = s3.charAt(i3);
        boolean valid = (i1<s1.length()&&s1.charAt(i1)==c&&isInterleave(s1,s2,s3,i1+1,i2,i3+1))|| 
            (i2<s2.length()&&s2.charAt(i2)==c&&isInterleave(s1,s2,s3,i1,i2+1,i3+1));
        if(!valid) invalid[i1][i2]=true;
        return valid;
    }
}