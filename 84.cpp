class Solution {
public:
    int largestRectangleArea(vector<int>& heights) {
        stack<int> stk;
        int res = 0;
        heights.push_back(0);
        for(int i=0;i<heights.size();++i) {
            while(!stk.empty()&&heights[i]<heights[stk.top()]){
                int cur = heights[stk.top()];stk.pop();
                res = max(res,cur*(stk.empty()?i:i-stk.top()-1));
            }
            stk.push(i);
        }
        return res;
    }
};
