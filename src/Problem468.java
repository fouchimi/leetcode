public class Problem468 {

    public String validIPAddress(String IP) {
        if(IP == null || IP.length() == 0 ||
                (!Character.isDigit(IP.charAt(IP.length()-1)) &&
                !Character.isLetter(IP.charAt(IP.length()-1)))) return  "Neither";
        if(isIPv4Address(IP)) return "IPv4";
        if(isIPv6Address(IP)) return "IPv6";
        return "Neither";
    }

    private boolean isIPv4Address(String ip) {
        if(ip.indexOf(':') > 0) return false;
        String[] fields = ip.split("\\.");
        if(fields.length != 4) return false;
        for(String field : fields) {
            if(field.length() == 0 || (field.length() > 1 &&  field.charAt(0) == '0')) return false;
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < field.length(); i++) {
                if(!Character.isDigit(field.charAt(i))) return false;
                sb.append(field.charAt(i));
            }
            if(sb.length() > 3) return false;
            String value = sb.toString();
            if(Integer.parseInt(value) < 0 || Integer.parseInt(value) > 255) return false;
        }
        return true;
    }

    private boolean isIPv6Address(String ip) {
        if(ip.indexOf('.') > 0) return false;
        String[] fields = ip.split(":");
        if(fields.length != 8) return false;
        for(String field : fields) {
            field = field.toLowerCase();
            if(field.length() > 4 || field.length() == 0) return false;
            for(int i = 0; i < field.length(); i++) {
                char ch = field.charAt(i);
                if(!Character.isDigit(ch) && !Character.isLetter(ch) || (Character.isLetter(ch) && ch > 'f')) return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Problem468 problem468 = new Problem468();
        System.out.println(problem468.validIPAddress("172.16.254.1"));
        System.out.println(problem468.validIPAddress("2001:0db8:85a3:0:0:8A2E:0370:7334"));
        System.out.println(problem468.validIPAddress("256.256.256.256"));
        System.out.println(problem468.validIPAddress("2001:0db8:85a3:0:0:8A2E:0370:7334:"));
    }
}
