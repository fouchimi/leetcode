
public class Problem166 {

    public String fractionToDecimal(int numerator, int denominator) {

        if(denominator == 0) return null;
        StringBuilder sb = new StringBuilder();

        String sign = numerator < 0 || denominator < 0 ? "-" : "+";

        numerator = Math.abs(numerator);
        denominator = Math.abs(denominator);

        while (numerator < denominator) {
            if(sb.length() == 0) sb.append("0.");
            else sb.append("0");
            numerator *= 10;
        }

        while (numerator % denominator != 0) {
            int r = numerator % denominator;
            numerator /= denominator;
            String val = String.valueOf(numerator);
            String str = sb.toString();
            if(!str.isEmpty() && str.length() >= 2) str = str.substring(2);
            else if(!str.isEmpty()) {
                sb.append(".");
                str = sb.toString().substring(2);
            }
            int index = str.indexOf(val);
            if(index >= 0) {
                sb.insert(index+2, "(");
                sb.append(")");
                break;
            }
            sb.append(val);
            numerator = r * 10;
        }

        if(numerator % denominator == 0 && !sb.toString().contains("(")) sb.append(String.valueOf(numerator/denominator));

        if(sign.equals("-")) sb.insert(0, sign);

        return sb.length() == 0 ? String.valueOf(numerator) : sb.toString();
    }

    public static void main(String[] args) {
        Problem166 problem166 = new Problem166();
        System.out.println(problem166.fractionToDecimal(1, 6));
        System.out.println(problem166.fractionToDecimal(-2, 3));
        System.out.println(problem166.fractionToDecimal(2, 1));
        System.out.println(problem166.fractionToDecimal(4, 9));
        System.out.println(problem166.fractionToDecimal(4, 333));
        System.out.println(problem166.fractionToDecimal(1, 90));
        System.out.println(problem166.fractionToDecimal(22, 7));
        System.out.println(problem166.fractionToDecimal(1, 2));
        System.out.println(problem166.fractionToDecimal(1, 8));
    }
}
