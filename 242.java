class Solution {
    public boolean isAnagram(String s, String t) {
        int[] alpha = new int[128];
        for(char c : s.toCharArray()){
            alpha[c]++;
        }
        for(char c : t.toCharArray()){
            alpha[c]--;
            if(alpha[c]<0) return false;
        }
        for(int i=0;i<128;i++){
            if(alpha[i]!=0) return false;
        }
        return true;
    }
}