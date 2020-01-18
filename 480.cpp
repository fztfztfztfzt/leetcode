class Solution {
public:
    vector<double> medianSlidingWindow(vector<int>& nums, int k) {
        vector<double> res;
        multiset<double> s(nums.begin(), nums.begin()+k);
        auto mid = next(s.begin(),k/2);
        res.push_back((*mid+*prev(mid, 1-(k%2)))/2.0);
        for(int i=k;i<nums.size();++i){
            s.insert(nums[i]);
            if(nums[i]<*mid) --mid;
            if(nums[i-k]<=*mid) ++mid;
            s.erase(s.lower_bound(nums[i-k]));
            res.push_back((*mid+*prev(mid, 1-(k%2)))/2.0);
        }
        return res;
    }
};

class Solution {
public:
    vector<double> medianSlidingWindow(vector<int>& nums, int k) {
        multiset<int> small,large;
        vector<double> res;
        for(int i=0;i<nums.size();++i){
            if(i>=k){
                if(small.count(nums[i-k])) small.erase(small.find(nums[i-k]));
                else large.erase(large.find(nums[i-k]));
            }
            if(small.size()<=large.size()){
                if(large.size()==0||nums[i]<=*large.begin()) small.insert(nums[i]);
                else{
                    small.insert(*large.begin());
                    large.erase(large.begin());
                    large.insert(nums[i]);
                }
            }else{
                if(nums[i]>=*small.rbegin()) large.insert(nums[i]);
                else{
                    large.insert(*small.rbegin());
                    small.erase(--small.end());
                    small.insert(nums[i]);
                }
            }
            if(i>=k-1){
                if(k%2==0) res.push_back(((double)*small.rbegin()+*large.begin())/2);
                else res.push_back(*small.rbegin());
            }
        }
        return res;
    }
};
