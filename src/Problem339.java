import java.util.List;

public class Problem339 {

    public interface NestedInteger {

        // Constructor initializes an empty nested list.
        // public NestedInteger();

        // Constructor initializes a single integer.
        // public NestedInteger(int value);

        // @return true if this NestedInteger holds a single integer, rather than a nested list.
         public boolean isInteger();

         // @return the single integer that this NestedInteger holds, if it holds a single integer
         // Return null if this NestedInteger holds a nested list
         public Integer getInteger();

         // Set this NestedInteger to hold a single integer.
         public void setInteger(int value);

         // Set this NestedInteger to hold a nested list and adds a nested integer to it.
         public void add(NestedInteger ni);

         // @return the nested list that this NestedInteger holds, if it holds a nested list
         // Return null if this NestedInteger holds a single integer
         public List<NestedInteger> getList();
    }

    //This code works perfectly uncomment it and paste it on leetcode judge
    /*class Solution {
        public int depthSum(List<NestedInteger> nestedList) {
            NestedInteger sumList = new NestedInteger();
            depthSumUtil(nestedList, 1, sumList);
            int sum = 0;
            for(NestedInteger nestedInteger : sumList.getList()) {
                sum += nestedInteger.getInteger();
            }
            return sum;
        }

        private void depthSumUtil(List<NestedInteger> nestedList, int depth, NestedInteger sumList) {
            for(NestedInteger nestedInteger : nestedList) {
                if(nestedInteger.isInteger()) {
                    NestedInteger ni = new NestedInteger(nestedInteger.getInteger()*depth);
                    sumList.add(ni);
                }else depthSumUtil(nestedInteger.getList(), depth+1, sumList);
            }
        }
    } */
}
