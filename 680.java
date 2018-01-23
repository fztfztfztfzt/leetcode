class Solution {
    public boolean validPalindrome(String s) {
        int end = s.length()-1;
        int start = 0;
        while(start<end){
            if(s.charAt(start)!=s.charAt(end)) return validPalindrome(s,start,end-1)||validPalindrome(s,start+1,end);
            start++;
            end--;
        }
        return true;
    }
    private boolean validPalindrome(String s,int start,int end){
        while(start<end){
            if(s.charAt(start)!=s.charAt(end)) return false;
            start++;
            end--;
        }
        return true;
    }
}