static int x=[](){std::ios::sync_with_stdio(false); std::cin.tie(NULL); return 0;}();
class Solution {
public:
    string lastSubstring(string s) {
        int i=0,j=1,k=0,n=s.size();
        while(j+k<n){
            if(s[i+k]==s[j+k]) k++;
            else if(s[i+k]<s[j+k]){
                i=j++;
                k=0;
            }else if(s[i+k]>s[j+k]){
                j+=(k+1);
                k=0;
            }
        }
        return s.substr(i);
    }
};
