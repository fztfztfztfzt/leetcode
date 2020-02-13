class Solution {
public:
    int numSubmatrixSumTarget(vector<vector<int>>& matrix, int target) {
        int m = matrix.size();
        if(m==0) return 0;
        int n = matrix[0].size();
        if(n==0) return 0;
        vector<vector<int>> sum(m,vector<int>(n+1,0));
        int res = 0;
        for(int i=0;i<m;++i)
            for(int j=1;j<=n;++j)
                sum[i][j] = sum[i][j-1]+matrix[i][j-1];
        for(int i=0;i<n;++i){
            for(int j=i+1;j<=n;++j){
                unordered_map<int,int> map;
                map[0]=1;
                int cur = 0;
                for(int k=0;k<m;++k){
                    cur += (sum[k][j]-sum[k][i]);
                    if(map[cur-target]!=0) res += map[cur-target];
                    map[cur]++;
                }
            }
        }
        return res;
    }
};
