class Solution {
    public String getHint(String secret, String guess) {
        int[] number = new int[10];
        int bull = 0;
        int cow = 0;
        for(int i=0;i<secret.length();i++){
            int s = secret.charAt(i)-'0';
            int g = guess.charAt(i)-'0';
            if(g==s) bull++;
            else{
                if(number[s]<0) cow++;
                if(number[g]>0) cow++;
                number[s]++;
                number[g]--;
            }
        }
        return bull+"A"+cow+"B";
    }
}