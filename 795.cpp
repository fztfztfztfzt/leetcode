static int Static_X = [](){
    std::ios::sync_with_stdio(false);
    cin.tie(NULL);
    return 0;
}();

class Solution {
public:
    int numSubarrayBoundedMax(vector<int>& A, int L, int R) {
        int res = 0;
        int left = -1;
        int right = -1;
        for(int i=0;i<A.size();i++){
            if(A[i]>=L) right = i;
            if(A[i]>R) left = i;
            res += (right-left);
        }
        return res;
    }
};
