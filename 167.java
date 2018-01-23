class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int low=0;
        int high=numbers.length-1;
        int temp;
        int[] a = new int[2];
        while(low<high){
            temp=numbers[low]+numbers[high];
            if(temp==target){
                a[0]=low+1;
                a[1]=high+1;
                return a;
            }
            else if(temp<target) low++;
            else high--;
        }
        return a;
    }
}