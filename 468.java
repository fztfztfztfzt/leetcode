class Solution {
    public String validIPAddress(String IP) {
        if(IP.equals("")) return "Neither";
        if(IP.charAt(IP.length()-1)=='.') return "Neither";
        String[] ipv4 = IP.split("\\.");
        //System.out.print(Arrays.toString(ipv4));
        if(ipv4.length==4){
            for(String temp : ipv4) if(!validIpv4(temp)) return "Neither";
            return "IPv4";
        }
        if(IP.charAt(IP.length()-1)==':') return "Neither";
        String[] ipv6 = IP.split(":");
        if(ipv6.length==8){
            for(String temp : ipv6) if(!validIpv6(temp)) return "Neither";
            return "IPv6";
        }
        return "Neither";
    }
    private boolean validIpv6(String num){
        if(num.equals("")) return false;
        if(num.equals("0")) return true;
        if(num.length()>4) return false;
        char temp;
        for(int i=0;i<num.length();i++){
            temp = num.charAt(i);
            if(!(((temp>='0')&&(temp<='9'))||((temp>='A')&&(temp<='F'))||((temp>='a')&&(temp<='f')))) return false;
        }
        return true;
        
    }
    private boolean validIpv4(String num){
        if(num.equals("")) return false;
        if(num.equals("0")) return true;
        else if(num.charAt(0)=='0') return false;
        else if(num.charAt(0)=='-') return false;
        else{
            try{
                int temp = Integer.parseInt(num);
                if((temp<=255)&&(temp>=0)) return true;
                return false;
            }catch(NumberFormatException nfe) {
		        return false;
	        }
        }
    }
}