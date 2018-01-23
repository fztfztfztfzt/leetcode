class Solution {
    public int rangeBitwiseAnd(int m, int n) {
        if(m==0) return 0;
        int move = 0;
        while(m!=n){
            m = m>>1;
            n = n>>1;
            move++;
        }
        return m<<move;
    }
}