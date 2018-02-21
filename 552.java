class Solution {
    public int checkRecord(int n) {
        long A1L2,A1L1,A1L0,A0L2,A0L1,A0L0;
        A1L2 = 0;
        A1L1 = 0;
        A1L0 = 1;
        A0L2 = 0;
        A0L1 = 1;
        A0L0 = 1;
        for(int i=1;i<n;i++){
            long temp1 = (A0L2+A0L1+A0L0)%1000000007;
            long temp2 = (A1L2+A1L1+A1L0+temp1)%1000000007;
            A1L2 = A1L1;
            A1L1 = A1L0;
            A1L0 = temp2;
            A0L2 = A0L1;
            A0L1 = A0L0;
            A0L0 = temp1;
        }
        return (int)((A1L2+A1L1+A1L0+A0L2+A0L1+A0L0)%1000000007);
    }
}

class Solution {
    public int checkRecord(int n) {
        if(n==1) return 3;
        long[][] init = {{0},{0},{1},{0},{1},{1}};
        long[][] P = {{0,1,0,0,0,0},{0,0,1,0,0,0},{1,1,1,1,1,1},{0,0,0,0,1,0},{0,0,0,0,0,1},{0,0,0,1,1,1}};
        long[][] G = matPowN(P,n-1);
        long[][] res = mul(G,init);
        return (int)((res[0][0]+res[1][0]+res[2][0]+res[3][0]+res[4][0]+res[5][0])%1000000007);
    }
    private long[][] matPowN(long[][] m,int n){
        if(n==1) return m;
        if(n==2) return mul(m,m);
        long[][] temp = matPowN(m,n/2);
        if((n&1)==0){
            return mul(temp,temp);
        }else{
            return mul(m,mul(temp,temp));
        }
    }
    private long[][] mul(long[][] m1,long[][] m2){
        long[][] res = new long[m1.length][m2[0].length];
        for(int i=0;i<m1.length;i++){
            for(int j=0;j<m2[0].length;j++){
                for(int k=0;k<m2.length;k++){
                    res[i][j]+=m1[i][k]*m2[k][j];
                }
                res[i][j]%=1000000007;
            }
        }
        return res;
    }
}

