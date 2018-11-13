class Solution {
public:
    string getPermutation(int n, int k) {
        vector<int> vec;
        for(int i=1;i<=n;i++) vec.push_back(i);
        return getPermutation(n,k-1,vec);
    }
private:
    string getPermutation(int n,int k,vector<int>& vec){
        if(n==1) return to_string(vec[0]);
        int f = factorial(n-1);
        int i = k/f;
        int j = k%f;
        int t = vec[i];
        vec.erase(vec.begin()+i);
        return to_string(t)+getPermutation(n-1,j,vec);
        
    }
    int factorial(int n){
        int res=1;
        for(int i=1;i<=n;i++) res*=i;
        return res;
    }
};
