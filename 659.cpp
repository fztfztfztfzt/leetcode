class Solution {
public:
    bool isPossible(vector<int>& nums) {
        unordered_map<int,int> need,freq;
        for(int num : nums) ++freq[num];
        for(int num : nums){
            if(freq[num]==0) continue;
            if(need[num]>0){
                --need[num];
                ++need[num+1];
                --freq[num];
            }else if(freq[num+1]>0&&freq[num+2]){
                --freq[num];
                --freq[num+1];
                --freq[num+2];
                ++need[num+3];
            }else return false;
        }
        return true;
    }
};