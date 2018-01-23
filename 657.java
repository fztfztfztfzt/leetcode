class Solution {
    public boolean judgeCircle(String moves) {
        int n = moves.length();
        if(n%2!=0){
            return false;
        }
        char[] a = moves.toCharArray();
        int x=0;
        int y=0;
        for(int i=0;i<n;i++){
            if(a[i]=='U') y++;
            else if(a[i]=='D') y--;
            else if(a[i]=='L') x--;
            else if(a[i]=='R') x++;
        }
        if((x==0)&&(y==0)) return true;
        return false;
    }
}

class Solution {
    public boolean judgeCircle(String moves) {
        char[] cs = moves.toCharArray();
		int[] count = new int[128];
		Arrays.fill(count, 0);
		for (char c : cs)
			count[c]++;
		if (count['U'] == count['D'] && count['L'] == count['R'])
			return true;
		return false;
    }
}