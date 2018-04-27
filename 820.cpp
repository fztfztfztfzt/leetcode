class Solution {
public:
    int minimumLengthEncoding(vector<string>& words) {
        unordered_set<string> s(words.begin(), words.end());
        for(string word : words){
            for(int i=1;i<word.size();i++){
                s.erase(word.substr(i));
            }
        }
        int res = 0;
        for(string c : s) res+=(c.size()+1);
        return res;
    }
};