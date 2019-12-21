int optimization = []() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    return 0;
}(); 

class Solution {
public:
    int maxSumSubmatrix(vector<vector<int>>& matrix, int k) {
        if(matrix.empty()||matrix[0].empty()) return 0;
        int m=matrix.size(),n=matrix[0].size(),res=INT_MIN;
        for(int i=0;i<m;++i){
            vector<int> sums(n,0);
            for(int j=i;j<m;++j){
                for(int jj=0;jj<n;++jj){
                    sums[jj] += matrix[j][jj];
                    if(sums[jj]==k||matrix[j][jj]==k) return k;
                }
                int cur_sum = 0;
                for(auto sum : sums){
                    cur_sum += sum;
                    if(cur_sum==k) return k;
                    if(cur_sum<k&&cur_sum>res) res = cur_sum;
                    if(cur_sum<0) cur_sum=0;
                }
                if(cur_sum<k) continue;
                cur_sum = 0;
                set<int> st{{0}};
                for(auto sum : sums){
                    cur_sum += sum;
                    auto it = st.lower_bound(cur_sum-k);
                    if(it!=st.end()) res = max(res,cur_sum-*it);
                    st.insert(cur_sum);
                }
            }
        }
        return res;
    }
};