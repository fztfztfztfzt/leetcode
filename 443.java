class Solution {
    public int minMutation(String start, String end, String[] bank) {
        if(start.equals(end)) return 0;
        Set<String> bankSet = new HashSet<>();
        for(String b : bank) bankSet.add(b);
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        char[] genes = new char[]{'A','T','C','G'};
        int level = 0;
        queue.offer(start);
        visited.add(start);
        while(!queue.isEmpty()){
            int size = queue.size();
            while(size-->0){
                String g = queue.poll();
                if(g.equals(end)) return level;
                char[] gc = g.toCharArray();
                for(int i=0;i<gc.length;i++){
                    char old = gc[i];
                    for(char c : genes){
                        gc[i] = c;
                        String gn = new String(gc);
                        if(!visited.contains(gn)&&bankSet.contains(gn)){
                            queue.offer(gn);
                            visited.add(gn);
                        }
                    }
                    gc[i] = old;
                }
            }
            level++;
        }
        return -1;
    }
}