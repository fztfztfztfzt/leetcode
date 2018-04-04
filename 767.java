class Solution {
    public String reorganizeString(String S) {
        Map<Integer,Integer> map = new HashMap<>();
        for(char c : S.toCharArray()){
            int t = map.getOrDefault((int)c,0)+1;
            if(t>(S.length()+1)/2) return "";
            map.put((int)c,t);
        }
        Queue<int[]> pq =  new PriorityQueue<int[]>((a,b)->(b[1]-a[1]));
        for (Map.Entry<Integer,Integer> entry : map.entrySet()){  
            pq.add(new int[]{entry.getKey(),entry.getValue()});   
        }
        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()){
            int[] first = pq.poll();
            if(sb.length()==0||sb.charAt(sb.length()-1)!=(char)(first[0])){
                first[1]--;
                sb.append((char)first[0]);
                if(first[1]>0) pq.add(first);
            }else{
                int[] second = pq.poll();
                pq.add(first);
                second[1]--;
                sb.append((char)second[0]);
                if(second[1]>0) pq.add(second);
            }
        }
        return sb.toString();
    }
}


class Solution {
    public String reorganizeString(String S) {
        int[] data = new int[26];
        int max = 0;
        int maxi = -1;
        for(char c : S.toCharArray()){
            data[c-'a']++;
            if(data[c-'a']>max){
                max=data[c-'a'];
                maxi=c-'a';
            }
            if(max>(1+S.length())/2) return "";
        }
        char[] res = new char[S.length()];
        int index = 0;
        for(int i=0;i<max;i++){
            res[index] = (char)(maxi+'a');
            index+=2;
        }
        data[maxi]=0;
        for(int i=0;i<26;i++){
            int count = data[i];
            for(int j=0;j<count;j++){
                if(index>=S.length()) index=1;
                res[index]=(char)(i+'a');
                index+=2;
            }
        }
        return new String(res);
    }
}