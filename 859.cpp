class Solution {
public:
    bool buddyStrings(string A, string B) {
        if(A.size()!=B.size()) return false;
        int pos[2] = {-1,-1};
        int p = 0;
        int map[26];
        for(int i=0;i<26;i++) map[i]=0;
        bool flag = false;
        for(int i=0;i<A.size();i++){
            if(A[i]!=B[i]){
                if(p>1) return false;
                pos[p++] = i;
            }else if(!flag){
                if(map[A[i]-'a']==0) map[A[i]-'a']=1;
                else flag = true;
            }
        }
        if(p==0) return flag;
        else if(p==1) return false;
        return A[pos[0]]==B[pos[1]]&&A[pos[1]]==B[pos[0]];
    }
};
