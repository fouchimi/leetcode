
public class Problem592 {

    public String fractionAddition(String expression) {
        String result = "0/1";
        while (expression.length() > 0) {
            int start = 0;
            int end = getFraction(expression);
            String fraction = expression.substring(start, end);
            result = compute(result, fraction);
            expression = expression.substring(end);
        }

        return result;
    }

    private int getFraction(String s) {
        int index = 0;
        if(s.charAt(0) == '-' || s.charAt(0) == '+') index++;
        while (index < s.length()) {
            if(s.charAt(index) == '+' || s.charAt(index) == '-') break;
            index++;
        }
        return index;
    }

    private String compute (String firstFraction, String secondFraction) {
        String[] firstFractionStrs = firstFraction.split("/");
        String[] secondFractionStrs = secondFraction.split("/");
        return addOrSubstract(firstFractionStrs[0], firstFractionStrs[1], secondFractionStrs[0], secondFractionStrs[1]);
    }

    private String addOrSubstract(String m, String n, String p, String q) {
        int numerator = (Integer.parseInt(m) * Integer.parseInt(q)) + (Integer.parseInt(n) * Integer.parseInt(p));
        int denominator = Integer.parseInt(n) * Integer.parseInt(q);
        if(numerator % denominator == 0) {
            numerator /= denominator;
            return numerator + "/1";
        }
        int k = gcd(numerator, denominator);
        numerator /= k;
        denominator /= k;
        if(denominator < 0) {
            denominator *=-1;
            numerator *= -1;
        }
        return numerator + "/" + denominator;
    }

    private int gcd(int a, int b) {
        if(a == 0 || b == 0) return a+b;
        return gcd(b, a%b);
    }

    public static void main(String[] args) {
        Problem592 problem592 = new Problem592();
        System.out.println(problem592.fractionAddition("-1/2+1/2"));
        System.out.println(problem592.fractionAddition("-1/2+1/2+1/3"));
        System.out.println(problem592.fractionAddition("1/3-1/2"));
        System.out.println(problem592.fractionAddition("5/3+1/3"));
        System.out.println(problem592.fractionAddition("7/2+2/3-3/4"));
    }

}
