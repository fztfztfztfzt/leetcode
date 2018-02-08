class Solution {
    public String[] findRelativeRanks(int[] nums) {
        int[][] pair = new int[nums.length][2];
        for(int i=0;i<nums.length;i++){
            pair[i][0] = nums[i];
            pair[i][1] = i;
        }
        Arrays.sort(pair, (a, b) -> (b[0] - a[0]));
        String[] result = new String[nums.length];
        String temp;
        for(int i=0;i<nums.length;i++){
            if(i==0) temp = "Gold Medal";
            else if(i==1) temp = "Silver Medal";
            else if(i==2) temp = "Bronze Medal";
            else temp = ""+(i+1);
            result[pair[i][1]] = temp;
        }
        return result;
    }
}

class Solution {
    public String[] findRelativeRanks(int[] nums) {
        int maxN = 0;
        int m = nums.length;
        for (int x : nums) if (x > maxN) maxN = x;
        int[] orderedNums = new int[maxN + 1];
        for (int i = 0; i < m; i++) {
            orderedNums[nums[i]] = i + 1;
        }
        String[] result = new String[m];
        int rk = 1;
        for (int j = orderedNums.length - 1; j >= 0; j--) {
            if (orderedNums[j] == 0) continue;
            if (rk == 1) {
                result[orderedNums[j] - 1] = "Gold Medal";
            } else if (rk == 2) {
                result[orderedNums[j] - 1] = "Silver Medal";
            } else if (rk == 3) {
                result[orderedNums[j] - 1] = "Bronze Medal";
            } else {
                result[orderedNums[j] - 1] = Integer.toString(rk);
            }
            rk++;
        }
        return result;
    }
}