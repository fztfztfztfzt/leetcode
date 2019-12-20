int any = []() {
	ios::sync_with_stdio(false);
	cin.tie(nullptr);
	return 0;
}();

class Solution {
public:
    bool xorGame(vector<int>& nums) {
        int x = 0;
        int n = nums.size();
        for(int num : nums) x^=num;
        return x==0||n%2==0;
    }
};