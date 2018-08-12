public class Problem492 {

    public int[] constructRectangle(int area){
        int[] res = new int[2];
        int limit = (int) Math.sqrt(area);
        for(int i = 1; i <= limit; i++) {
            if(area%i == 0) {
                res[0] = area / i;
                res[1] = i;
            }
        }
        return res;
    }

    public static void main(String[] args){
        Problem492 problem492 = new Problem492();
        int[] res = problem492.constructRectangle(12);
        System.out.println("L: " + res[0] + " ");
        System.out.println("W: " + res[1] + " ");
    }
}
