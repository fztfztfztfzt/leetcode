static int x = []() {std::ios::sync_with_stdio(false); cin.tie(0); return 0; }();
class Solution {
public:
    int countPalindromicSubsequences(string S) {
        const int M = 1000000007;
        int n = S.size();
        vector<vector<int>> dp(n,vector<int>(n,0));
        unordered_map<char,vector<int>> c2v;
        unordered_map<char,unordered_map<int,int>> c2p2v; 
        for(int i=0;i<n;++i){
            dp[i][i]=1;
            c2v[S[i]].push_back(i);
            c2p2v[S[i]][i] = c2v[S[i]].size()-1;
        }
        for(int len=1;len<n;++len){
            for(int i=0;i<n-len;++i){
                int j = i+len;
                if(S[i]==S[j]){
                    int left = c2p2v[S[i]][i];
                    int right = c2p2v[S[i]][j];
                    dp[i][j] = dp[i+1][j-1]*2;
                    if(left+1==right) dp[i][j]+=2;
                    else if(left+2==right) dp[i][j]+=1;
                    else{
                        left = c2v[S[i]][left+1]+1;
                        right = c2v[S[i]][right-1]-1;
                        dp[i][j]=dp[i][j]-dp[left][right];
                    }
                }else{
                    dp[i][j] = dp[i+1][j]+dp[i][j-1]-dp[i+1][j-1];
                }
                dp[i][j] = (dp[i][j]<0?dp[i][j]+M:dp[i][j])%M;
            }
        }
        return dp[0][n-1];
    }
};
