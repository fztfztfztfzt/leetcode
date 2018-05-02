class Solution {
public:
    int numMatchingSubseq(string S, vector<string>& words) {
        vector<string> data[26];
        int res = 0;
        for(int i=0;i<words.size();i++){
            data[words[i][0]-'a'].push_back(words[i]);
        }
        for(int i=0;i<S.size();i++){
            //printData(data);
            vector<string> temp = data[S[i]-'a'];
            data[S[i]-'a'].clear();
            for(int j=0;j<temp.size();j++){
                string t = temp[j];
                if(t.size()==1) res++;
                else data[t[1]-'a'].push_back(t.substr(1));
            }
        }
        return res;
    }
    void printData(vector<string>* data){
        printf("======================\n");
        for(int i=0;i<26;i++){
            for(int j=0;j<data[i].size();j++){
                printf("%s ",data[i][j].c_str());
            }
            if(data[i].size()!=0) printf("\n");
        }
        printf("======================\n");
    }
};