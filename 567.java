class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int left = 0;
        int right = 0;
        int diff = s1.length();
        int[] hash = new int[26];
        for(char c : s1.toCharArray()) hash[c-'a']++;
        while(right<s2.length()){
            if(hash[s2.charAt(right++)-'a']-- >= 1) diff--;
            if(diff==0) return true;
            if(right-left==s1.length() && hash[s2.charAt(left++)-'a']++>=0) diff++;
        }
        return false;
    }
}