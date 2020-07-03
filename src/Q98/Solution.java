package Q98;

import java.util.Stack;

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
         this.right = right;
      }
}
 
class Solution {
    public boolean isValidBST(TreeNode root) {
    	return treeValid(root,null,null);
    }
    public boolean treeValid(TreeNode root,Integer lowbound,Integer upbound)
    {
    	boolean left_result = false, right_result = false,low_test = true,up_test = true;
    	if(root == null)
    		return true;
    	
    	left_result = treeValid(root.left,lowbound,root.val);
    	right_result = treeValid(root.right,root.val,upbound);
    	if(lowbound != null)
    		low_test = (root.val > lowbound);
    	if(upbound != null)
    		up_test = (root.val < upbound);
    	
    	return left_result && right_result && low_test && up_test;
    }
}