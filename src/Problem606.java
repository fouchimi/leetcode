
public class Problem606 {

    public String tree2str(TreeNode t) {
        if(t == null) return "";
        String result = t.val + "";
        String left = tree2str(t.left);
        String right = tree2str(t.right);
        if(left.equals("") && right.equals("")) return result;
        if(left.equals("")) return result + "()" + "(" + right + ")";
        if(right.equals("")) return result + "(" + left + ")";
        return result + "(" + left + ")" + "(" + right + ")";
    }

    public static void main(String[] args) {
        Problem606 problem606 = new Problem606();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        System.out.println(problem606.tree2str(root));

        TreeNode r = new TreeNode(1);
        r.left = new TreeNode(2);
        r.right = new TreeNode(3);
        r.left.right = new TreeNode(4);
        System.out.println(problem606.tree2str(r));
    }
}
