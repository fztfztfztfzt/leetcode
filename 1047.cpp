class Solution {
public:
    string removeDuplicates(string S) {
        vector<char> stack;
        for(char c : S){
            if(stack.empty()||stack.back()!=c){
                stack.push_back(c);
            }else{
                stack.pop_back();
            }
        }
        string res(stack.begin(),stack.end());
        return res;
    }
};
