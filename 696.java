class Solution {
    public int countBinarySubstrings(String s) {
        int prev = 0;int cur = 1;int res = 0;
        for(int i=1;i<s.length();i++){
            if(s.charAt(i)==s.charAt(i-1)) cur++;
            else{
                prev = cur;
                cur = 1;
            }
            if(prev>=cur) res++;
        }
        return res;
    }
}