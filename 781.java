class Solution {
    public int numRabbits(int[] answers) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int answer : answers) map.put(answer,map.getOrDefault(answer,0)+1);
        int res = 0;
        for(Map.Entry<Integer,Integer> entry : map.entrySet()) {
            res+=(entry.getValue()%(entry.getKey()+1)==0)?entry.getValue():(entry.getValue()/(entry.getKey()+1)+1)*(entry.getKey()+1);
        }
        return res;
    }
}