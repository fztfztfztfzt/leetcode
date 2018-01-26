class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        return wordBreak(s,0,wordDict,new HashMap<Integer,List<String>>());
    }
    private List<String> wordBreak(String s,int start,List<String> wordDict,Map<Integer,List<String>> map){
        if(map.containsKey(start)){
            return map.get(start);
        }
        List<String> result = new ArrayList<>();
        for(String c : wordDict){
            if(s.startsWith(c,start)){
                if(start+c.length()==s.length()){
                    result.add(c);
                }else{
                    List<String> temp = wordBreak(s,start+c.length(),wordDict,map);
                    for(String t : temp){
                        result.add(c+" "+t);
                    }
                }
            }
        }
        map.put(start,result);
        return result;
    }
}