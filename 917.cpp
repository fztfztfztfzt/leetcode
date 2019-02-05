class Solution {
public:
    string reverseOnlyLetters(string S) {
        if(S.size()<=1) return S;
        int left = 0;
        int right = S.size()-1;
        const char* c = S.c_str();
        vector<char> res(right+2);
        while(left<=right){
            while(left<=right&&!isLetter(c[left])){res[left]=c[left];left++;}
            while(left<=right&&!isLetter(c[right])){res[right]=c[right];right--;}
            if(left>right) break;
            res[right] = c[left];
            res[left] = c[right];
            left++;
            right--;
            //printf("%s\n",res);
        }
        string r;
        r.insert(r.begin(),res.begin(),res.end());
        return r;
    }
private:
    bool isLetter(char c){
        return ((c>='a')&&(c<='z'))||((c>='A')&&(c<='Z'));
    }
};
