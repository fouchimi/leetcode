import java.util.ArrayList;
import java.util.List;

public class Problem220 {

    class Node {
        Node left, right;
        int index, val;

        Node(int index, int val) {
            this.index = index;
            this.val = val;
        }
    }

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if(t < 0) return false;
        Node root = null;
        for(int i = 0; i < nums.length; i++) root = addToTree(root, i, nums[i]);
        List<Node> list = new ArrayList<>();
        for(int i = 0; i < nums.length; i++) {
            int min = Math.min(nums[i], t);
            int max = Math.max(nums[i], t);
            int diff = Math.abs(min-max);
            if(diff == Integer.MAX_VALUE) {
                for(int j = max+min; j <= max; j++) {
                    search(root, i, -j, list);
                    if(check(list, i, k)) return true;
                    if(!list.isEmpty()) list.remove(0);
                }
            } else if(diff == Integer.MIN_VALUE && max == Integer.MAX_VALUE) continue;
            else if(diff < 0) {
                for(int j=max-min; j <= max; j++) {
                    search(root, i, -j, list);
                    if(check(list, i, k)) return true;
                    if(!list.isEmpty()) list.remove(0);
                }
            }else if(diff > 0) {
                if(min == Integer.MIN_VALUE) {
                    search(root, i, -Integer.MAX_VALUE, list);
                    if(check(list, i, k)) return true;
                    if(!list.isEmpty()) list.remove(0);
                }
                else if(max == 0) {
                    search(root, i, min, list);
                    if(check(list, i, k)) return true;
                    if(!list.isEmpty()) list.remove(0);
                }
                else if(min == nums[i]) {
                    for(int j=0; j <= min+max; j++) {
                        search(root, i, j, list);
                        if(check(list, i, k)) return true;
                        if(!list.isEmpty()) list.remove(0);
                    }
                }else {
                    for(int j = max-min; j <= min+max; j++) {
                        search(root, i, j, list);
                        if(check(list, i, k)) return true;
                        if(!list.isEmpty()) list.remove(0);
                    }
                }
            }else {
                if(min == max && max == Integer.MAX_VALUE) continue;
                else if(min+max < 0) {
                    search(root, i, 0, list);
                    if(check(list, i, k)) return true;
                    if(!list.isEmpty()) list.remove(0);
                }else {
                    for(int j = 0; j <= min; j++) {
                        search(root, i, j,list);
                        if(check(list, i, k)) return true;
                        if(!list.isEmpty()) list.remove(0);
                    }
                }
            }

        }
        return false;
    }

    private boolean check(List<Node> list, int index, int k) {
        for(int j = 0; j < list.size(); j++)
            if(Math.abs(list.get(j).index - index) <= k) return true;
        return false;
    }

    private Node addToTree(Node x, int index, int val) {
        if(x == null) {
             x = new Node(index, val);
             return x;
        }
        if(x.val <= val) x.right = addToTree(x.right, index, val);
        else x.left = addToTree(x.left, index, val);
        return x;
    }

    private void search(Node x, int currentIndex, long val, List<Node> list) {
        if(x == null) return;
        if(currentIndex != x.index && x.val == (int) val) {
            list.add(x);
            return;
        }
        if(x.val > val) search(x.left, currentIndex, val, list);
        else search(x.right, currentIndex, val, list);
    }

    public static void main(String[] args) {
        Problem220 problem220 = new Problem220();
        /*int[] nums = {1, 2, 3, 1};
        System.out.println(problem220.containsNearbyAlmostDuplicate(nums, 3, 0));
        int[] nums1 = {1, 0, 1, 1};
        System.out.println(problem220.containsNearbyAlmostDuplicate(nums1, 1, 2));
        int[] nums3 = {1, 3, 1};
        System.out.println(problem220.containsNearbyAlmostDuplicate(nums3, 2, 1));
        int[] nums4 = {0, 2147483647};
        System.out.println(problem220.containsNearbyAlmostDuplicate(nums4, 1, 2147483647));
        int[] nums5 = {-214783648, -2147483647};
        System.out.println(problem220.containsNearbyAlmostDuplicate(nums5, 3, 3));
        int[] nums6 = {2, 0, -2, 2};
        System.out.println(problem220.containsNearbyAlmostDuplicate(nums6, 2, 1));
        int[] nums2 = {1, 5, 9, 1, 5, 9};
        System.out.println(problem220.containsNearbyAlmostDuplicate(nums2, 2, 3));
        int[] nums7 = {-1, 2147483647};
        System.out.println(problem220.containsNearbyAlmostDuplicate(nums7, 1, 2147483647)); */
        int[] nums8 = {-2147483648, -2147483647};
        System.out.println(problem220.containsNearbyAlmostDuplicate(nums8, 3, 3));

    }
}
