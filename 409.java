class Solution {
    public int longestPalindrome(String s) {
        int[] alpha = new int[128];
        boolean flag = false;
        int sum = 0;
        for(char c : s.toCharArray()) alpha[c]++;
        for(int i=0;i<26;i++){
            int temp = alpha[i+'a'];
            if(temp%2==0) sum+=temp;
            else{
                flag = true;
                sum+=temp-1;
            }
            temp = alpha[i+'A'];
            if(temp%2==0) sum+=temp;
            else{
                flag = true;
                sum+=temp-1;
            }
        }
        return sum+(flag?1:0);
    }
}