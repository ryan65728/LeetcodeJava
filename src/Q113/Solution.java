package Q113;

import java.util.ArrayList;
import java.util.List;

class Solution {
	List<Integer> numpath = new ArrayList<Integer>();
	List<List<Integer>> result = new ArrayList<List<Integer>>();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
    	if(root != null)
    		path_(root,sum,0);
    	return result;
    }
    public void path_(TreeNode it,int sum,int partsum)
    {
    	numpath.add(it.val);
    	if(it.left == null && it.right == null && partsum+it.val == sum)
    		result.add(new ArrayList<Integer>(numpath));    	
    	else
    	{
    		if(it.left != null)
    		  path_(it.left,sum,partsum+it.val);
    		if(it.right != null)
    		  path_(it.right,sum,partsum+it.val);    		
    	}
    	numpath.remove(numpath.size()-1);

    }
}

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
