import java.util.*;

public class Problem929 {

    public int numUniqueEmails(String[] emails) {

        Set<String> set = new HashSet<>();
        for(String email : emails) {
            int index = email.indexOf('@');
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < index; i++) {
                char ch = email.charAt(i);
                if(ch == '+') break;
                else if(ch == '.') continue;
                sb.append(ch);
            }
            for(int i = index; i < email.length(); i++) {
                sb.append(email.charAt(i));
            }
            set.add(sb.toString());
        }
        return set.size();
    }

    public static void main(String[] args) {
        Problem929 problem929 = new Problem929();
        String[] emails = {"test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"};
        System.out.println(problem929.numUniqueEmails(emails));
    }
}
