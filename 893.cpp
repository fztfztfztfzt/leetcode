class Solution {
public:
    int numSpecialEquivGroups(vector<string>& A) {
        unordered_set<string> set;
        for(int i=0;i<A.size();i++){
            set.insert(hash(A[i]));
        }
        return set.size();
    }
private:
    string hash(string S){
        string even = "";
        string odd =  "";
        for(int i=0;i<S.size();i+=2) even+=S[i];
        for(int i=1;i<S.size();i+=2) odd+=S[i];
        sort(even.begin(),even.end());
        sort(odd.begin(),odd.end());
        return even+odd;
    }
};
