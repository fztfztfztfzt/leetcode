class Solution {
public:
    int countRangeSum(vector<int>& nums, int lower, int upper) {
        int res = 0;
        long long sum = 0;
        multiset<long long> sums;
        sums.insert(0);
        for(int num : nums){
            sum += num;
            res += distance(sums.lower_bound(sum-upper),sums.upper_bound(sum-lower));
            sums.insert(sum);
        }
        return res;
    }
};

class Solution {
public:
    int countRangeSum(vector<int>& nums, int lower, int upper) {
        vector<long> sums(nums.size()+1,0);
        for(int i=0;i<nums.size();++i) sums[i+1] = sums[i]+nums[i];
        return countAndMergeSort(sums,0,sums.size(),lower,upper);
    }
private:
    int countAndMergeSort(vector<long>& sums, int start, int end, int lower, int upper){
        if(end-start<=1) return 0;
        int mid = start + ((end-start)>>1);
        int cnt = countAndMergeSort(sums,start,mid,lower,upper)+countAndMergeSort(sums,mid,end,lower,upper);
        int j = mid,k=mid,l=mid,ci=0;
        vector<long> cache(end-start,0);
        for(int i=start;i<mid;i++){
            while(j<end&&sums[j]-sums[i]<lower) ++j;
            while(k<end&&sums[k]-sums[i]<=upper) ++k;
            cnt += (k-j);
            while(l<end&&sums[l]<sums[i]) cache[ci++]=sums[l++];
            cache[ci++] = sums[i];
        }
        copy(cache.begin(),cache.begin()+l-start,sums.begin()+start);
        return cnt;
    }
};