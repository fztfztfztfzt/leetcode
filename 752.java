class Solution {
    public int openLock(String[] deadends, String target) {
        Set<String> begin = new HashSet<>();
        Set<String> end = new HashSet<>();
        Set<String> deads = new HashSet<>(Arrays.asList(deadends));
        Set<String> temp; 
        int step = 0;
        begin.add("0000");
        end.add(target);
        while(!end.isEmpty()&&!begin.isEmpty()){
            if(end.size()<begin.size()){
                temp = end;
                end = begin;
                begin = temp;
            }
            temp = new HashSet<>();
            for(String s : begin){
                if(end.contains(s)) return step;
                if(deads.contains(s)) continue;
                deads.add(s);
                for(int i=0;i<4;i++){
                    char c = s.charAt(i);
                    String t1 = s.substring(0,i)+(c=='9'?'0':(char)(c+1))+s.substring(i+1,4);
                    if(!deads.contains(t1)) temp.add(t1);
                    String t2 = s.substring(0,i)+(c=='0'?'9':(char)(c-1))+s.substring(i+1,4);
                    if(!deads.contains(t2)) temp.add(t2);
                }               
            }
            begin = temp;
            step++;
        }
        return -1;
    }
}