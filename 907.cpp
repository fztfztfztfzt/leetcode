class Solution {
public:
    int sumSubarrayMins(vector<int>& A) {
        int M = 1e9+7, n = A.size(), res = 0;
        vector<int> dp(n+1);
        stack<int> stk{{-1}};
        for(int i=0;i<n;i++){
            while(stk.top()!=-1&&A[i]<A[stk.top()]){
                stk.pop();
            }
            dp[i+1] = (dp[stk.top()+1]+(i-stk.top())*A[i])%M;
            stk.push(i);
            res = (res+dp[i+1])%M;
        }
        return res;
    }
};

class Solution {
public:
    int sumSubarrayMins(vector<int>& A) {
        int M = 1e9+7, n = A.size(), res = 0;
        stack<int> stk;
        for(int i=0;i<=n;i++){
            int cur = i==n?0:A[i];
            while(!stk.empty()&&cur<A[stk.top()]){
                int index = stk.top();
                stk.pop();
                int left = index-(stk.empty()?-1:stk.top());
                int right = i-index;
                res = (res+A[index]*right*left)%M;
            }
            stk.push(i);
        }
        return res;
    }
};