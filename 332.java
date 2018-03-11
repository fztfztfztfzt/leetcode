class Solution {
    Map<String, PriorityQueue<String>> map;
    List<String> path;
    public List<String> findItinerary(String[][] tickets) {
        path = new LinkedList<>();
        map = new HashMap<>();
        for(String[] pairs : tickets){
            if(!map.containsKey(pairs[0])) map.put(pairs[0],new PriorityQueue<>());
            map.get(pairs[0]).add(pairs[1]);
        }
        dfs("JFK");
        return path;
    }
    private void dfs(String airport){
        PriorityQueue<String> queue = map.get(airport);
        while(map.containsKey(airport)&&!queue.isEmpty())
            dfs(queue.poll());
        path.add(0,airport);
    }
}