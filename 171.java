class Solution {
    public int titleToNumber(String s) {
        char[] ss = s.toCharArray();
        int result = 0;
        for(char sss : ss){
            result *= 26;
            result+=(sss-'A'+1);
        }
        return result;
    }
}