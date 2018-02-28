class WordFilter {
    Map<String,Integer> map;
    public WordFilter(String[] words) {
        map = new HashMap<>();
        for(int i = 0;i<words.length;i++){
            String word = words[i];
            for(int prefix=0;prefix<=word.length();prefix++){
                for(int suffix=0;suffix<=word.length();suffix++){
                    map.put(word.substring(0,prefix)+"#"+word.substring(suffix),i);
                }
            }
        }
    }
    
    public int f(String prefix, String suffix) {
        return map.getOrDefault(prefix+"#"+suffix,-1);
    }
}

/**
 * Your WordFilter object will be instantiated and called as such:
 * WordFilter obj = new WordFilter(words);
 * int param_1 = obj.f(prefix,suffix);
 */