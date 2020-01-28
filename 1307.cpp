class Solution {
public:
    bool isSolvable(vector<string>& words, string result) {
        int maxsize = 0;
        for(string& word : words){
            maxsize = max(maxsize,(int)word.size());
            if(word.size()>result.size()) return false;
        }
        if(result.size()!=maxsize&&result.size()!=maxsize+1) return false;
        memset(digital,false,sizeof(digital));
        memset(letter,-1,sizeof(letter));
        w = words;
        for(auto& d : w){
            reverse(d.begin(),d.end());
        }
        res = result;
        reverse(res.begin(),res.end());
        return dfs(0,0,0);
    }
private:
    vector<string> w;
    bool digital[10];
    int letter[26];
    string res;
    bool dfs(int num, int len,int sum){
        if(len==res.size()) return sum==0;
        if(num==w.size()){
            if(letter[res[len]-'A']!=-1){
                if(letter[res[len]-'A']==sum%10){
                    return dfs(0,len+1,sum/10);
                }
            }else if(!digital[sum%10]){
                if((len==res.size()-1)&&(sum%10==0)) return false;
                digital[sum%10]=true;
                letter[res[len]-'A']=sum%10;
                bool tmp = dfs(0,len+1,sum/10);
                digital[sum%10]=false;
                letter[res[len]-'A']=-1;
                return tmp;
            }
            return false;
        }
        if(len>=w[num].size()) return dfs(num+1,len,sum);
        if(letter[w[num][len]-'A']!=-1){
            if((len!=w[num].size()-1)||(letter[w[num][len]-'A']!=0))
                return dfs(num+1,len,sum+letter[w[num][len]-'A']);
            return false;
        }
        for(int i=0;i<10;++i){
            if(digital[i]) continue;
            if((len==w[num].size()-1)&&i==0) continue;
            digital[i]=true;
            letter[w[num][len]-'A']=i;
            bool tmp = dfs(num+1,len,sum+i);
            digital[i]=false;
            letter[w[num][len]-'A']=-1;
            if(tmp) return true;
        }
        return false;
    }
};
