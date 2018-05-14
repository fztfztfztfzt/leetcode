class Solution {
public:
    int maxProfitAssignment(vector<int>& difficulty, vector<int>& profit, vector<int>& worker) {
        map<int,int,greater<int>> m;
        for(int i=0;i<profit.size();i++){
            if(m[profit[i]]==0) m[profit[i]]=difficulty[i];
            else m[profit[i]]=min(m[profit[i]],difficulty[i]);
        }
        sort(worker.begin(),worker.end(),greater<int>());
        int res = 0;
        auto iter = m.begin();   
        for(int i=0;i<worker.size();i++){
            while(iter!=m.end()&&worker[i]<iter->second)  iter++;
            res+=(iter==m.end()?0:iter->first);
        }
        return res;
    }
};