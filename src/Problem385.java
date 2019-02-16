public class Problem385 {

    /* public NestedInteger deserialize(String s) {
        Stack<NestedInteger> stack = new Stack<>();
        int N = s.length();
        for(int i = 0; i < N;) {
            char ch = s.charAt(i);
            if(ch == '[') {
                NestedInteger list = new NestedInteger();
                stack.push(list);
                i++;
            } else if((ch >= '0' && ch <= '9') || ch == '-') {
                StringBuilder sb = new StringBuilder();
                int flag = ch == '-' ? -1 : 1;
                if(flag == -1) i++;
                while(i < N && (s.charAt(i) >= '0' && s.charAt(i) <= '9')) {
                    sb.append(s.charAt(i));
                    i++;
                }
                NestedInteger top = null;
                int val = flag * Integer.parseInt(sb.toString());
                if(!stack.isEmpty()) {
                    top = stack.pop();
                    top.add(new NestedInteger(val));
                }
                else top = new NestedInteger(val);
                stack.push(top);
            } else if(ch == ']') {
                NestedInteger top = stack.pop();
                if(!stack.isEmpty()) stack.peek().add(top);
                else if(top.isInteger()) {
                    NestedInteger l = new NestedInteger();
                    l.add(top);
                    stack.push(l);
                } else stack.push(top);
                i++;
            } else i++;
        }
        return stack.pop();
    } */

}
