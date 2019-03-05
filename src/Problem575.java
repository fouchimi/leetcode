import java.util.*;

public class Problem575 {

    public int distributeCandies(int[] candies) {
        Set<Integer> kinds = new HashSet<>(candies.length);
        for(int candy : candies) kinds.add(candy);
        int mean = candies.length / 2;
        return kinds.size() >= mean ? mean: kinds.size();
    }

    public static void main(String[] args) {
        Problem575 problem575 = new Problem575();
        int[] candies = {1, 1, 2, 3};
        System.out.println(problem575.distributeCandies(candies));
        int[] candies2 = {1, 1, 2, 2, 3, 3};
        System.out.println(problem575.distributeCandies(candies2));
    }

}
