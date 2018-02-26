class Solution {
    public List<List<String>> findDuplicate(String[] paths) {
        Map<String,List<String>> map = new HashMap<>();
        for(String path : paths){
            String[] temp = path.split(" ");
            for(int i=1;i<temp.length;i++){
                int t = temp[i].indexOf("(");
                String file = temp[i].substring(0,t);
                String content = temp[i].substring(t+1,temp[i].length()-1);
                if(!map.containsKey(content)) map.put(content,new ArrayList<String>());
                map.get(content).add(temp[0]+"/"+file);
            }
        }
        List<List<String>> result = new ArrayList<>();
        for(List<String> value : map.values()){  
            if(value.size()>1) result.add(value); 
        }
        return result;
    }
}