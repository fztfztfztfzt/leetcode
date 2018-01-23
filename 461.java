class Solution {
    public int hammingDistance(int x, int y) {
        int r = x^y;
        int n=0;
        while(r!=0){
            if((r&1)!=0){
                n++;
            }
            r=r>>1;
        }
        return n;
    }
}