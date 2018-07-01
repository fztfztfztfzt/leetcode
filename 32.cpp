class Solution {
public:
    int longestValidParentheses(string s) {
        int dp[65536];
        int len = s.length();
        int res = 0;
        for(int i=1;i<=len;i++){
            int j = i-2-dp[i-1];
            if(s[i-1]=='('||j<0||s[j]==')'){
                dp[i]=0;
            }else{
                dp[i]=dp[i-1]+2+dp[j];
                res = max(res,dp[i]);
            }
        }
        return res;
    }
};


class Solution {
public:
    int longestValidParentheses(string s) {
        stack<pair<int, int>> stk;
        int res = 0;
        int curLen = 0;
        for(int i=0;i<s.length();i++){
            if(s[i]=='('){
                stk.push(make_pair(i,0));
            }else{
                if(stk.empty()||stk.top().second==1){
                    stk.push(make_pair(i,1));
                }else{
                    stk.pop();
                    if(stk.empty()){
                        curLen = i+1;
                    }else{
                        curLen = i-stk.top().first;
                    }
                    res = max(res,curLen);
                }
            }
        }
        return res;
    }
};