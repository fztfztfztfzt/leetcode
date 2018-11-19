int x = []() {
  std::ios::sync_with_stdio(false);
  std::cin.tie(nullptr);
  return 0;
}();
class Solution {
public:
    vector<int> fairCandySwap(vector<int>& A, vector<int>& B) {
        int sumA = 0;
        int sumB = 0;
        set<int> setA;
        set<int> setB;
        for(int i=0;i<A.size();i++){
            sumA += A[i];
            setA.insert(A[i]);
        }
        for(int i=0;i<B.size();i++){
            sumB += B[i];
            setB.insert(B[i]);
        }
        int diff = (sumB-sumA)/2;
        for(auto a = setA.begin();a!=setA.end();++a){
            int tmp = (*a)+diff;
            if(setB.find(tmp)!=setB.end()){
                vector<int> res(2);
                res[0] = *a;
                res[1] = tmp;
                return res;
            }
        }
    }
};
