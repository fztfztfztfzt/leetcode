class Solution {
public:
    vector<string> findAllConcatenatedWordsInADict(vector<string>& words) {
        unordered_set<string> s;
        vector<string> res;
        for(auto word : words) s.insert(word);
        for(auto word : words) if(isConcatenated(s,word)) res.push_back(word);
        return res;
    }
private:
    bool isConcatenated(unordered_set<string>& s, string word){
        //printf("%s\n",word.c_str());
        vector<int> dp(word.length()+1,0);
        dp[word.length()]=1;
        for(int i=1;i<word.length();i++){
            if(s.find(word.substr(0,i))!=s.end()){
                //printf("%d\n",i);
                if(isConcatenated(s,word,dp,i)){
                    return true;
                }
            }
        }
        return false;
    }
    bool isConcatenated(unordered_set<string>& s, string word, vector<int>& dp, int n){
        if(dp[n]==1) return true;
        if(dp[n]==-1) return false;
        //printf("in %s %d\n",word.c_str(),n);
        for(int i=n+1;i<=word.length();i++){
            if(s.find(word.substr(n,i-n))!=s.end()){
                //printf("in %s %d %d\n",word.c_str(),n,i);
                if(isConcatenated(s,word,dp,i)){
                    dp[i]=true;
                    return true;
                }
            }
        }
        dp[n]=false;
        return false;
    }
};
