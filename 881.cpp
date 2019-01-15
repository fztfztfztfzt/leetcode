class Solution {
public:
    int numRescueBoats(vector<int>& people, int limit) {
        sort(people.begin(),people.end());
        int i=0,j=people.size()-1,sum=0;
        while(i<j){
            while(i<j&&people[i]+people[j]>limit){
                j--;
                sum++;
            }
            j--;
            i++;
            sum++;
        }
        if(i==j) sum++;
        return sum;
    }
};
