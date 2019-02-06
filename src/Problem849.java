public class Problem849 {

    public int maxDistToClosest(int[] seats) {
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < seats.length; i++) {
            if(seats[i] == 1) continue;
            else {
                int j = i, leftDist = 0;
                // Go left;
                while (j >= 0 && seats[j] == 0) {
                    leftDist++;
                    j--;
                }

                int k = i, rightDist = 0;
                while (k < seats.length && seats[k] == 0) {
                    rightDist++;
                    k++;
                }
                if((j < 0 && seats[j+1] == 0) || (k == seats.length && seats[k-1] == 0)) max = Math.max(max, Math.max(leftDist, rightDist));
                else max = Math.max(max, Math.min(leftDist, rightDist));
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Problem849 problem849 = new Problem849();
        System.out.println(problem849.maxDistToClosest(new int[]{1, 0, 0, 0}));
    }
}
