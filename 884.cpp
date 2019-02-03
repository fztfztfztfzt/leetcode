class Solution {
public:
    vector<string> uncommonFromSentences(string A, string B) {
        unordered_map<string,int> map;
        vector<string> splitA = split(A," ");
        vector<string> splitB = split(B," ");
        vector<string> res; 
        for(auto tmp : splitA){
            map[tmp]++;
        }
        for(auto tmp : splitB){
            map[tmp]++;
        }
        for(auto tmp : map){
            if(tmp.second==1)
                res.push_back(tmp.first);
        }
        return res;
    }
private:
    vector<string> split(const string& s, const string& c){
        std::string::size_type pos1, pos2;
        pos2 = s.find(c);
        pos1 = 0;
        vector<string> res;
        while(std::string::npos != pos2){
            res.push_back(s.substr(pos1, pos2-pos1));
            pos1 = pos2 + c.size();
            pos2 = s.find(c, pos1);
        }
        if(pos1 != s.length())
            res.push_back(s.substr(pos1));
        return res;
    }
};
