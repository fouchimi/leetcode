import java.util.*;

public class Problem599 {

    public String[] findRestaurant(String[] list1, String[] list2) {

        int minIndex = Integer.MAX_VALUE;
        List<String> list = new ArrayList<>();
        for(int i = 0; i < list1.length; i++) {
            String current = list1[i];
            for(int j = 0; j < list2.length; j++) {
                if(list2[j].equals(current) && i + j <= minIndex) {
                    minIndex = i+j;
                    list.add(current);
                }
            }
        }

        String[] result = new String[list.size()];
        return list.toArray(result);
    }

    public static void main(String[] args) {
        Problem599 problem599 = new Problem599();
        String[] list1 = new String[] {"Shogun", "Tapioca Express", "Burger King", "KFC"};
        String[] list2 = new String[] {"Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"};

        String[] resultList = problem599.findRestaurant(list1, list2);
        for(String s : resultList) System.out.println(s);
    }
}
