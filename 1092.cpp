class Solution {
public:
    string shortestCommonSupersequence(string str1, string str2) {
        int n1 = str1.size();
        int n2 = str2.size();
        int i1,i2;
        vector<vector<int>> dp(n1+1,vector<int>(n2+1,0));
        for(i1=1;i1<=n1;++i1){
            for(i2=1;i2<=n2;++i2){
                if(str1[i1-1]==str2[i2-1])
                    dp[i1][i2] = dp[i1-1][i2-1]+1;
                else
                    dp[i1][i2] = max(dp[i1-1][i2],dp[i1][i2-1]);
            }
        }
        string LCS;
        i1=n1;i2=n2;
        while(i1!=0&&i2!=0){
            if(str1[i1-1]==str2[i2-1]){
                LCS+=str1[i1-1];
                i1--;
                i2--;
            }else{
                if(dp[i1-1][i2]<dp[i1][i2-1])
                    i2--;
                else
                    i1--;
            }
        }
        reverse(LCS.begin(),LCS.end());
        //printf("%s\n",LCS.c_str());
        string res;
        i1=0;i2=0;
        for(int i=0;i<LCS.size();++i){
            while(i1<n1&&str1[i1]!=LCS[i]) res+=str1[i1++];
            while(i2<n2&&str2[i2]!=LCS[i]) res+=str2[i2++];
            res+=LCS[i];
            i1++;i2++;
        }
        while(i1<n1) res+=str1[i1++];
        while(i2<n2) res+=str2[i2++];
        return res;
    }
};
