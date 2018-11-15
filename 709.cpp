class Solution {
public:
    string toLowerCase(string str) {
        string res = "";
        for(int i=0;i<str.size();i++){
            char tmp = str[i];
            if(tmp>='A'&&tmp<='Z'){
                tmp+=0x20;
            }
            res+=tmp;
        }
        return res;
    }
};
