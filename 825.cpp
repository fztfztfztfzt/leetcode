class Solution {
public:
    int numFriendRequests(vector<int>& ages) {
        int agesArray[121] = {0};
        int sumArray[121] = {0};
        int res = 0;
        for(int age: ages) agesArray[age]++;
        for(int age = 15;age<=120;age++) sumArray[age] = sumArray[age-1]+agesArray[age];
        for(int age = 15;age<=120;age++){
            if(agesArray[age]==0) continue;
            res += agesArray[age]*(sumArray[age]-sumArray[(age/2)+7]-1);
        }
        return res;
    }
};
