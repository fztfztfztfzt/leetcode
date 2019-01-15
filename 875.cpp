class Solution {
public:
    int minEatingSpeed(vector<int>& piles, int H) {
        int low = 1;
        int high = 0;
        int mid;
        for(int i=0;i<piles.size();i++) if(piles[i]>high) high = piles[i];
        while(low<high){
            mid = (high-low)/2+low;
            if(canEat(piles, H, mid)){
                high = mid;
            }else{
                low = mid+1;
            }
        }
        return low;
    }
private:
    bool canEat(vector<int>& piles, int H, int K){
        int sum = 0;
        for(int i=0;i<piles.size();i++){
            if(piles[i]%K==0) sum+=(piles[i]/K);
            else sum+=(piles[i]/K+1);
        }
        return H>=sum;
    }
};
