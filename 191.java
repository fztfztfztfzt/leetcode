public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int num = 0;
        for(int i=0;i<32;i++){
            num+=(n&1);
            n = n>>>1;
        }
        return num;
    }
}