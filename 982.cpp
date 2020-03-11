class Solution {
public:
    int countTriplets(vector<int>& A) {
        int n = *max_element(A.begin(),A.end());
        vector<int> count(n+1);
        for(const auto& a1: A)
            for(const auto& a2 : A)
                count[a1&a2]++;
        int res = 0;
        for(const auto& a : A)
            for(int i=0;i<=n;i++)
                if((i&a)==0)
                    res += count[i];
        return res;
    }
};
