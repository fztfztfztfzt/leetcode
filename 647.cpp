class Solution {
public:
    int countSubstrings(string s) {
        int dp[1000][1000];
        int n = s.length();
        int res = 0;
        for(int i=n-1;i>=0;i--){
            for(int j=i;j<n;j++){
               dp[i][j] = (s[i]==s[j])&&((j-i<3)||dp[i+1][j-1]);
               if(dp[i][j]!=0) res+=dp[i][j];
            }
        }
        return res;
    }
};