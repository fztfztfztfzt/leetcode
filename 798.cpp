class Solution {
public:
    int bestRotation(vector<int>& A) {
        int n = A.size();
        vector<int> change(n,0);
        for(int i=0;i<n;++i) change[(i-A[i]+1+n)%n]-=1;
        for(int i=1;i<n;++i) change[i]+=change[i-1]+1;
        return max_element(change.begin(), change.end())-change.begin();
    }
};
