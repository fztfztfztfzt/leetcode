class Solution {
    public String convertToTitle(int n) {
        n--;
        String re = (char)(n%26+'A')+"";
        while(n/26!=0){
            n = n/26-1;
            re = (char)(n%26+'A')+re;
        }
        return re;
    }
}