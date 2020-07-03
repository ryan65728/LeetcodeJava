package Q95;

import java.util.ArrayList;
import java.util.List;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<TreeNode> generateTrees(int n) {
    	if(n == 0)
    		return new ArrayList<TreeNode>();
    	return CreateTree(1,n);
    }
    
    List<TreeNode> CreateTree(int beg,int end)
    {
    	List<TreeNode> list = new ArrayList<TreeNode>();
    	if(end < beg)
    	{
    		list.add(null);
    		return list;
    	}
    	for(int i = beg;i <= end;i++)
    	{
    		List<TreeNode> leftList = CreateTree(beg,i-1);
    		List<TreeNode> rightList = CreateTree(i+1,end);
    		
    		for(TreeNode left:leftList)
    		{
    			for(TreeNode right:rightList)
    			{
    				TreeNode temp = new TreeNode(i);
    				temp.left = left;
    				temp.right =right;
    				list.add(temp);
    			}
    		}
    	}
    	return list;
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