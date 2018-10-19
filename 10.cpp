class Solution {
public:
    bool isMatch(string s, string p) {
        bool **dp = new bool*[s.size()+1];
        for(int i=0;i<s.size()+1;i++){
            dp[i] = new bool[p.size()+1];
        }
        dp[0][0] = true;
        for(int i=1;i<=s.size();i++) dp[i][0]=false;
        for(int j=1;j<=p.size();j++) dp[0][j]=j>1&&('*'==p[j-1])&&dp[0][j-2];
        for(int i=1;i<=s.size();i++){
            for(int j=1;j<=p.size();j++){
                if(p[j-1]=='*'){
                    dp[i][j] = dp[i][j-2]||(s[i-1]==p[j-2]||p[j-2]=='.')&&dp[i-1][j];
                }else{
                    dp[i][j] = (s[i-1]==p[j-1]||p[j-1]=='.')&&dp[i-1][j-1];
                }
            }
        }
        return dp[s.size()][p.size()];
    }
};
