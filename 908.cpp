class Solution {
public:
    int smallestRangeI(vector<int>& A, int K) {
        sort(A.begin(),A.end());
        int small = A[0];
        int big   = A[A.size()-1];
        if((big-small)<2*K){
            return 0;
        }else{
            return big-small-2*K;
        }
    }
};
