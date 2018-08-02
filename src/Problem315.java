import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem315 {

    class Node {
        Node left;
        Node right;
        int val;
        int count = 1;
        public Node(int val) {
            this.val = val;
        }
    }

    public List<Integer> countSmaller(int[] nums) {
        List<Integer> res = new ArrayList<>();
        if(nums == null || nums.length == 0) return res;
        Node root = new Node(nums[nums.length - 1]);
        res.add(0);
        for(int i = nums.length - 2; i >= 0; i--) {
            int count = insertNode(root, nums[i]);
            res.add(count);
        }
        Collections.reverse(res);
        return res;
    }

    public int insertNode(Node root, int val) {
        int thisCount = 0;
        while(true) {
            if(val <= root.val) {
                root.count++;
                if(root.left == null) {
                    root.left = new Node(val); break;
                } else {
                    root = root.left;
                }
            } else {
                thisCount += root.count;
                if(root.right == null) {
                    root.right = new Node(val); break;
                } else {
                    root = root.right;
                }
            }
        }
        return thisCount;
    }

    public static void main(String[] args){
        Problem315 problem315 = new Problem315();
        int[] nums = {2, 0, 1};
        System.out.println(problem315.countSmaller(nums));
    }
}
