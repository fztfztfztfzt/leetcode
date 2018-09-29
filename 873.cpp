class Solution {
public:
    int lenLongestFibSubseq(vector<int>& A) {
        int n = A.size();
        int lenmax = 0;
        unordered_map<int,int> map;
        for(int i=0;i<n;i++){
            map[A[i]]=i;
        }
        int dp[1001][1001];
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                dp[i][j]=2;
            }
        }
        int pre;
        for(int i=1;i<n-1;i++){
            for(int j=i+1;j<n;j++){
                pre = A[j]-A[i];
                //printf("%d %d %d %d %d %d %d\n",i,j,A[i],A[j],pre,dp[i][j],lenmax);
                if(map.find(pre)!=map.end()&&map[pre]<i){
                    dp[i][j]=dp[map[pre]][i]+1;
                    lenmax = max(lenmax,dp[i][j]);   
                }
            }
        }
        return lenmax;
    }
};
