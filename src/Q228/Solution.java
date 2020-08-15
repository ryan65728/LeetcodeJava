package Q228;



import java.util.Iterator;
import java.util.Stack;


 
class Solution {
	int level = 0,level_record = 0,count=0;
	TreeNode thatone = null;
	boolean find_left = false;
    public int countNodes(TreeNode root) {

    	if(root == null)
    		return 0;
    	find_last_(root);

    	return (int) (Math.pow(2, level_record)+count);
    }
    

	boolean find_last_(TreeNode root)
    {
    	if(root.left == null && root.right == null)
    	{
    		if(!find_left) 
    		{
    			find_left = true;
    			level_record = level;
    			count = 0;
    		}
    		else 
    		{
    			if(level_record == level) 
    				count++;
    			else
    				return true;
    		}
    		
    	}
    	else
    	{
    		level++;
    		if(root.left != null) 
    		{
    			if(find_last_(root.left))
    				return true;
    		}
    		if(root.right != null)
    		{
    			if(find_last_(root.right))
    				return true;
    		}
    		level--;
    	}
    	return false;
    }

     public class TreeNode {
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
	
}