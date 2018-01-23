/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class Solution {
    public int[] findRightInterval(Interval[] intervals) {
        int[] result = new int[intervals.length];
        TreeMap<Integer,Integer> intervalsMap = new TreeMap<>();
        for(int i=0;i<intervals.length;i++) intervalsMap.put(intervals[i].start,i);
        for(int i=0;i<intervals.length;i++){
            Integer temp = intervalsMap.ceilingKey(intervals[i].end);
            result[i] = (temp==null)?-1:intervalsMap.get(temp);
        }
        return result;
    }
}

//7ms
/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class Solution {
    public int[] findRightInterval(Interval[] intervals) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (Interval i : intervals) {
            max = Math.max(max, i.start);
            min = Math.min(min, i.start);
        }
        min = min < 0 ? min : 0;
        int[] starts = new int[max - min + 1];
        Arrays.fill(starts, -1);
        for (int i = 0; i < intervals.length; i++) {
            starts[intervals[i].start - min] = i;
        }
        for (int i = max - min - 1; i >= 0; i--) {
            if (starts[i] == -1) {
                starts[i] = starts[i + 1];
            }
        }
        int[] right = new int[intervals.length];
        for (int i = 0; i < right.length; i++) {
            if (intervals[i].end > max) {
                right[i] = -1;
            } else {
                right[i] = starts[intervals[i].end - min];
            }
        }
        return right;
    }
}