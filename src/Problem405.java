public class Problem405 {

    public String toHex(int num) {

        if(num == 0) return "0";
        String result = "";
        char[] map = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        while (num != 0) {
            result = map[(num & 15)] + result;
            num = num >>> 4;
        }
        return result;
    }

    public static void main(String[] args) {
        Problem405 problem405 = new Problem405();
        System.out.println(problem405.toHex(10));
        System.out.println(problem405.toHex(26));
        System.out.println(problem405.toHex(-1));
    }
}
