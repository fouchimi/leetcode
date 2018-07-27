import java.util.ArrayList;
import java.util.List;

public class Problem254 {

    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> finalList = new ArrayList<>();
        getFactorsUtil(n, 2, new ArrayList<>(),   finalList);
        return finalList;
    }

    private void getFactorsUtil(int n, int lower, List<Integer> list, List<List<Integer>> finalList) {
        if(n <= 1) return;
        int upper = (int) Math.sqrt(n);
        for(int i = lower; i <= upper; i++) {
            if(n % i == 0) {
                list.add(i);
                list.add(n/i);
                finalList.add(new ArrayList<>(list));
                list.remove(list.size()-1);
                getFactorsUtil(n/i, i,  list, finalList);
                list.remove(list.size()-1);
            }
        }
    }

    public static void main(String[] args) {
        Problem254 problem254 = new Problem254();
        List<List<Integer>> resultList = problem254.getFactors(12);
        for(List<Integer> list : resultList) System.out.print( list + " ");
    }
}
