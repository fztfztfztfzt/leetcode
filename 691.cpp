class Solution {
public:
    int minStickers(vector<string>& stickers, string target) {
        int n = target.size();
        int m = 1<<n;
        unordered_map<char,vector<int>> tmap;
        for(int i=0;i<n;i++) tmap[target[i]].push_back(i);
        vector<int> dp(m,INT_MAX);
        dp[0] = 0;
        for(int i=0;i<m;i++){
            if(dp[i]==INT_MAX) continue;
            for(string& sticker : stickers){
                int cur = i;
                for(char c : sticker){
                    for(int j : tmap[c]){
                        if(((cur>>j)&1)==0){
                            cur |= (1<<j);
                            break;
                        }
                    }
                }
                dp[cur] = min(dp[cur],dp[i]+1);
            }
        }
        return dp[m-1]==INT_MAX?-1:dp[m-1];
    }

};
