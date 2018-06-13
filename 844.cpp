class Solution {
public:
    bool backspaceCompare(string S, string T) {
        int sl = helper(S);
        int pl = helper(T);
        if(sl!=pl) return false;
        for(int i=0;i<sl;i++){
            if(S[i]!=T[i]) return false;
        }
        return true;
    }
private:
    int helper(string &str){
        int p = 0;
        for(int i=0;i<str.size();i++){
            if(str[i]=='#') p=max(0,p-1);
            else str[p++]=str[i];
        }
        return p;
    }
};