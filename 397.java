class Solution {
    public int integerReplacement(int n) {
        if(n==1) return 0;
        if(n==2) return 1;
        int s = 0;
        while(n!=1){
            if(n%2==0){
                n=n>>>1;
                s++;
            }else{
                return s+1+Math.min(integerReplacement(n-1),integerReplacement(n+1));
            }
        }
        return s;
    }
}

class Solution {
    public int integerReplacement(int n) {
        int c=0;
        while(n!=1){
            if((n&1)==1){
                if((n!=3)&&((n&2)==2)) n++;
                else n--;
            }else{
                n = n>>>1;
            }
            c++;
        }
        return c;
    }
}