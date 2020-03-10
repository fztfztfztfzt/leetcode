class Solution {
public:
    int longestDecomposition(string text) {
        t = text;
        n = text.size();
        return helper(0);
    }
private:
    string t;
    int n;
    int helper(int start) {
        int end = n-start;
        if(end==start) return 0;
        int l = (end-start)/2;
        for(int i=1;i<=l;++i){
            if(t.substr(start,i)==t.substr(end-i,i)){
                int tmp = helper(start+i);
                return tmp+2;
            }
        }
        return 1;
    }
};
