package Q94;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Solution {
	List<Integer> result = new ArrayList<Integer>();
	Stack<TreeNode> Tstack = new Stack<TreeNode>();
    public List<Integer> inorderTraversal(TreeNode root) {
    	//Tstack.push(root);
    	while(true)
    	{
    		
    		if(root != null) 
    		{
    			Tstack.push(root);
    			root = root.left;
    		}
    		else
    		{
    			if(Tstack.isEmpty())
    				break;
    			TreeNode temp =  Tstack.pop();
    			result.add(temp.val);
    			root = temp.right;
    			
    		}

    	}
    	return result;
    }
    void inorder(TreeNode root)
    {
    	if(root == null)
    		return ;
    	else
    	{
    		inorder(root.left);
    		result.add(root.val);
    		inorder(root.right);
    	}
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
 