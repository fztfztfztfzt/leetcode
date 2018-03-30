class Solution {
    public String minWindow(String s, String t) {
        Map<Character,Integer> map = new HashMap<>();
        for(char c : t.toCharArray()){
            map.put(c,map.getOrDefault(c,0)+1);
        }
        int min = Integer.MAX_VALUE;
        String minString  = "";
        int count = 0;
        int left = 0;
        for(int right=0;right<s.length();right++){
            char c = s.charAt(right);
            if(map.containsKey(c)){
                map.put(c,map.get(c)-1);
                if(map.get(c)>=0) count++;
                while(count>=t.length()){
                    if(right-left+1<min){
                        min=right-left+1;
                        minString = s.substring(left,right+1);
                    }
                    char cl = s.charAt(left);
                    if(map.containsKey(cl)){
                        map.put(cl,map.get(cl)+1);
                        if(map.get(cl)>0) count--;
                    }
                    left++;
                }
            }
        }
        return minString;
    }
}