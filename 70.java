class Solution {
    public int climbStairs(int n) {
        if(n==1) return 1;
        if(n==2) return 2;
        int a,b;
        a = 1;
        b = 2;
        for(int i=2;i<n;i++){
            int c = a+b;
            a = b;
            b = c;
        }
        return b;
    }
}