class Solution {
    public int distributeCandies(int[] candies) {
        Set result = new HashSet();
        for(int i : candies) result.add(i);
        return Math.min(result.size(),candies.length/2);
    }
}