class Solution {
    public boolean hasAlternatingBits(int n) {
        int c = n&1;
        while(n>0){
            int temp = n&1;
            if(temp!=c) return false;
            n = n>>1;
            c=1-c;
        }
        return true;
    }
}