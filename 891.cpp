class Solution {
public:
    int sumSubseqWidths(vector<int>& A) {
        sort(A.begin(),A.end());
        int n = A.size();
        long exp;
        exp = 2;
        long mod = 1000000007;
        long dp[2];
        dp[0] = 0;
        dp[1] = A[1]-A[0];
        for(int i=2;i<n;i++){
            exp = (exp<<1)%mod;
            dp[i&1]=(3*dp[(i-1)&1]-2*dp[(i)&1]+(A[i]-A[i-1])*(exp-1))%mod;
        }
        return (int)(dp[(n-1)&1]+mod)%mod;
    }
};
