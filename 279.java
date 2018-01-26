class Solution {
    public int numSquares(int n) {
        if(is_square(n)) return 1;
        while((n&3)==0) n=n>>>2;
        if((n&7)==7) return 4;
        int sqrt_n = (int)(Math.sqrt(n));
        for(int i=0;i<=sqrt_n;i++){
            if(is_square(n-i*i)) return 2;
        }
        return 3;
    }
    private boolean is_square(int n){
        int t = (int)(Math.sqrt(n));
        return t*t==n;
    }
}