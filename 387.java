class Solution {
    public int firstUniqChar(String s) {
        int[] result = new int[26];
        for(int i=0;i<s.length();i++) result[s.charAt(i)-'a']++;
        for(int i=0;i<s.length();i++) if(result[s.charAt(i)-'a']==1) return i;
        return -1;
    }
}