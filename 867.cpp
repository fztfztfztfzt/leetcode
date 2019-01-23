static auto __ = [] () 
{
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    return 0;
}();

class Solution {
public:
    vector<vector<int>> transpose(vector<vector<int>>& A) {
        int N = A.size();
        if(N==0) return A;
        int M = A[0].size();
        vector<vector<int>> res(M,vector<int>(N,0));
        for(int j=0;j<M;j++){
            for(int i=0;i<N;i++){
                res[j][i] = A[i][j];
            }
        }
        return res;
    }
};

