class Solution {
    public String largestNumber(int[] nums) {
        String[] data = new String[nums.length];
        for(int i=0;i<nums.length;i++) data[i]=String.valueOf(nums[i]);
        
        Comparator<String> comp = new Comparator<String>(){
		    @Override
		    public int compare(String str1, String str2){
		        String s1 = str1 + str2;
			    String s2 = str2 + str1;
			    return s2.compareTo(s1);
		    }
	    };
        Arrays.sort(data,comp);
        if(data[0].charAt(0)=='0') return "0";
        StringBuilder sb = new StringBuilder();
        for(String d : data) sb.append(d);
        return sb.toString();
    }
}