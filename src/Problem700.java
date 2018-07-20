public class Problem700 {

    TreeNode searchedNode = null;
    public TreeNode searchBST(TreeNode root, int val) {
        if(root == null) return null;
        if(root.val == val) searchedNode = root;
        searchBST(root.left, val);
        searchBST(root.right, val);
        return searchedNode;
    }

    public static void main(String[] args){
        Problem700 problem700 = new Problem700();
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
    }
}
