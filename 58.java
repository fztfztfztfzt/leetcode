class Solution {
    public int lengthOfLastWord(String s) {
        int len = s.length();
        int r=0;
        while(len>0&&s.charAt(len-1)==' ') len--;
        while(len>0&&s.charAt(len-1)!=' '){
            len--;
            r++;
        }
        return r;
    }
}