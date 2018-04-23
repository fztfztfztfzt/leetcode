class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
        Map<String,Integer> map = new HashMap<>();
        for(String s : cpdomains){
            String[] ss = s.split(" ");
            int val = Integer.parseInt(ss[0]);
            String name = ss[1];
            while(true){
                map.put(name,map.getOrDefault(name,0)+val);
                int index = name.indexOf(".");
                if(index==-1) break;
                name = name.substring(index+1);
            }
        }
        List<String> res = new ArrayList<>();
        for(Map.Entry<String, Integer> entry : map.entrySet()){  
            res.add(""+entry.getValue()+" "+entry.getKey());
        } 
        return res;
    }
}