class Solution {
    public String longestWord(String[] words) {
        List<Set<String>> list = new ArrayList<>();
        for(int i=0;i<31;i++) list.add(new HashSet<>());
        for(String word : words){
            list.get(word.length()).add(word);
        }
        String res="";
        for(int i=30;i>=0;i--){
            Iterator<String> it = list.get(i).iterator();
            while(it.hasNext()){
                String s = it.next();
                if(res.length()!=0&&s.compareTo(res)>=0) continue;
                boolean flag = true;
                for(int j=s.length()-1;j>0;j--){
                    if(!list.get(j).contains(s.substring(0,j))){
                        flag = false;
                        break;
                    }
                }
                if(flag) res=s;
            }
            if(res.length()!=0) return res;
        }
        return res;
        
    }
}