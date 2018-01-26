class Solution {
    public int[] anagramMappings(int[] A, int[] B) {
        Map<Integer,List<Integer>> map = new HashMap<>();
        for(int i=0;i<B.length;i++){
            List<Integer> temp = map.getOrDefault(B[i],new ArrayList<>());
            temp.add(i);
            map.put(B[i],temp);
        }
        int[] result = new int[A.length];
        for(int i=0;i<A.length;i++){
            List<Integer> temp = map.get(A[i]);
            result[i] = temp.get(0);
            temp.remove(0);
            map.put(A[i],temp);
        }
        return result;
    }
}