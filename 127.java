class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>();
        for(String word : wordList) wordSet.add(word);
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        visited.add(beginWord);
        int level = 1;
        while(!queue.isEmpty()){
            int size = queue.size();
            while(size-->0){
                String word = queue.poll();
                if(word.equals(endWord)) return level;
                char[] wc = word.toCharArray();
                for(int i=0;i<wc.length;i++){
                    char old = wc[i];
                    for(int j=0;j<26;j++){
                        wc[i] = (char)(j+'a');
                        String temp = new String(wc);
                        if(wordSet.contains(temp)&&!visited.contains(temp)){
                            visited.add(temp);
                            queue.offer(temp);
                        }
                        wc[i] = old;
                    }
                }
            }
            level++;
        }
        return 0;
    }
}


class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>();
        for(String word : wordList) wordSet.add(word);
        if(!wordSet.contains(endWord)) return 0;
        Set<String> visited = new HashSet<>();
        Set<String> beginSet = new HashSet<>();
        Set<String> endSet = new HashSet<>();
        beginSet.add(beginWord);
        endSet.add(endWord);
        visited.add(beginWord);
        int level = 1;
        Set<String> temp;
        while(!beginSet.isEmpty()&&!endSet.isEmpty()){
            if(beginSet.size()>endSet.size()){
                temp = beginSet;
                beginSet = endSet;
                endSet = temp;
            }
            temp = new HashSet<>();
            for(String word : beginSet){
                char[] wc = word.toCharArray();
                for(int i=0;i<wc.length;i++){
                    char old = wc[i];
                    for(int j=0;j<26;j++){
                        wc[i] = (char)(j+'a');
                        String t = new String(wc);
                        if(endSet.contains(t)) return level+1;
                        if(wordSet.contains(t)&&!visited.contains(t)){
                            visited.add(t);
                            temp.add(t);
                        }
                        wc[i] = old;
                    }
                }
            }
            level++;
            beginSet = temp;
        }
        return 0;
    }
}