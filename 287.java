//O(nlongn)
class Solution {
    public int findDuplicate(int[] nums) {
        int low = 1;
        int high = nums.length-1;
        int mid,n;
        while(low<high){
            n = 0;
            mid = (high-low)/2+low;
            for(int i : nums) if(i<=mid) n++;
            if(n<=mid) low = mid+1;
            else high = mid;
        }
        return low;
    }
}

//O(n)
class Solution {
    public int findDuplicate(int[] nums) {
        int slow = 0;
        int fast = 0;
        int t = 0;
        do{
            slow = nums[slow];
            fast = nums[nums[fast]];
        }while(fast!=slow);
        do{
            slow = nums[slow];
            t = nums[t];
        }while(slow!=t);
        return slow;
    }
}