import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Problem721 {

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        boolean[] visited = new boolean[accounts.size()];
        List<List<String>> res = new ArrayList<>();
        int i = 0;
        for(; i < accounts.size(); i++) {
            if(!visited[i]) {
                visited[i] = true;
                List<String> currentAccount = accounts.get(i);
                List<String> newAccountList = new ArrayList<>();
                Queue<String> queue = new ArrayDeque<>();
                newAccountList.add(currentAccount.remove(0));
                for(String email : currentAccount) queue.offer(email);
                while (!queue.isEmpty()) {
                    String currentEmail = queue.poll();
                    if(newAccountList.size() == 1) newAccountList.add(currentEmail);
                    else if(!newAccountList.contains(currentEmail)) {
                        int k = 1;
                        for(; k < newAccountList.size(); k++) {
                            if(currentEmail.compareTo(newAccountList.get(k)) < 0) break;
                        }
                        if(k < newAccountList.size()) newAccountList.add(k, currentEmail);
                        else newAccountList.add(currentEmail);
                    }
                    for(int j = i+1; j < accounts.size(); j++) {
                        if(visited[j]) continue;
                        List<String> neighborAccount = accounts.get(j);
                        if(neighborAccount.contains(currentEmail)) {
                            visited[j] = true;
                            neighborAccount.remove(0);
                            neighborAccount.remove(currentEmail);
                            for(String neighborEmail : neighborAccount) queue.offer(neighborEmail);
                        }
                    }
                }
                res.add(newAccountList);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Problem721 problem721 = new Problem721();
        List<List<String>> accounts = new ArrayList<>();
        List<String> firstAccount = new ArrayList<>();
        firstAccount.add("John");
        firstAccount.add("johnsmith@mail.com");
        firstAccount.add("john00@mail.com");
        List<String> secondAccount = new ArrayList<>();
        secondAccount.add("John");
        secondAccount.add("johnnybravo@mail.com");
        List<String> thirdAccount = new ArrayList<>();
        thirdAccount.add("John");
        thirdAccount.add("johnsmith@mail.com");
        thirdAccount.add("john_newyork@mail.com");
        List<String> fourthAccount = new ArrayList<>();
        fourthAccount.add("Mary");
        fourthAccount.add("mary@mail.com");
        accounts.add(firstAccount);
        accounts.add(secondAccount);
        accounts.add(thirdAccount);
        accounts.add(fourthAccount);
        List<List<String>> res = problem721.accountsMerge(accounts);
        for(List<String> list : res) System.out.println(list);


    }
}
