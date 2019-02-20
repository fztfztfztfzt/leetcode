class Solution {
public:
    string countAndSay(int n) {
        if(n==1){
            string s = "1";
            return s;
        }
        string tmp = countAndSay(n-1);
        int t = 0;
        string res = "";
        for(int i=0;i<tmp.size();++i){
            t++;
            if(tmp[i]!=tmp[i+1]){
                res += (t+48);
                res += tmp[i];
                t=0;
            }
        }
        return res;
    }
};
