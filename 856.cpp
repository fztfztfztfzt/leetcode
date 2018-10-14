class Solution {
public:
    int scoreOfParentheses(string S) {
        vector<int> stk;
        for(int i=0;i<S.length();i++){
            if(S[i]=='(') stk.push_back(0);
            else{
                if(stk.back()==0){
                    stk.pop_back();
                    if(stk.back()==0) stk.push_back(1);
                    else{
                        int tmp = stk.back();
                        stk.pop_back();
                        stk.push_back(tmp+1);
                    }
                }else{
                    int tmp = stk.back();
                    stk.pop_back();
                    stk.pop_back();
                    if(stk.back()==0) stk.push_back(tmp*2);
                    else{
                        int tmp2 = stk.back();
                        stk.pop_back();
                        stk.push_back(tmp2+tmp*2);
                    }
                }
            }
        }
        return stk[0];
    }
};
