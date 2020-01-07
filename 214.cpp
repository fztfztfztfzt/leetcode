class Solution {
public:
    string shortestPalindrome(string s) {
        string r = s;
        reverse(r.begin(),r.end());
        string t = s+"#"+r;
        vector<int> next(t.size(),0);
        for(int i=1;i<t.size();++i){
            int j = next[i-1];
            while(j>0&&t[i]!=t[j]) j = next[j-1];
            if(t[i]==t[j]) next[i]=j+1;
        }
        return r.substr(0,s.size()-next.back())+s;
    }
};
