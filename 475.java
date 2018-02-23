class Solution {
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(heaters);
        int res = Integer.MIN_VALUE;
        for (int house : houses) {
            int index = Arrays.binarySearch(heaters, house);
            if (index < 0) {
        	    index = -(index + 1);
            }
            int dist1 = index>=1?house-heaters[index-1]:Integer.MAX_VALUE;
            int dist2 = index<heaters.length?heaters[index]-house:Integer.MAX_VALUE;
            res = Math.max(res, Math.min(dist1, dist2));
        }
        return res;
    }
}