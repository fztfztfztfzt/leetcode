class Solution {
    public boolean isPalindrome(String s) {
        int start = 0;
        int end = s.length()-1;
        while(start<end){
            char c1 = s.charAt(start);
            char c2 = s.charAt(end);
            if(!validChar(c1)){
                start++;
            }else if(!validChar(c2)){
                end--;
            }else{
                if(c1>='A'&&c1<='Z') c1=(char)(c1-'A'+'a');
                if(c2>='A'&&c2<='Z') c2=(char)(c2-'A'+'a');
                if(c1!=c2) return false;
                start++;
                end--;
            }
        }
        return true;
    }
    private boolean validChar(char c){
        if((c>='a'&&c<='z')||(c>='A'&&c<='Z')||(c>='0'&&c<='9')) return true;
        return false;
    }
}