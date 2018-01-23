class Solution {
    public boolean detectCapitalUse(String word) {
        if(word.length()==1) return true;
        char temp = word.charAt(1);
        if(((int)temp>=65)&&((int)temp<=90)){
            for(int i=0;i<word.length();i++){
                temp = word.charAt(i);
                if(!(((int)temp>=65)&&((int)temp<=90))) return false;
            }
        }else{
            for(int i=2;i<word.length();i++){
                temp = word.charAt(i);
                if(((int)temp>=65)&&((int)temp<=90)) return false;
            }
        }
        return true;
    }
}