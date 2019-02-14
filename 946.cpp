class Solution {
public:
    bool validateStackSequences(vector<int>& pushed, vector<int>& popped) {
        stack<int> s;
        int i=0;
        int j=0;
        while(i<pushed.size()&&j<popped.size()){
            s.push(pushed[i++]);
            while(!s.empty()&&s.top()==popped[j]){
                j++;
                s.pop();
            }
        }
        return s.empty();
    }
};
