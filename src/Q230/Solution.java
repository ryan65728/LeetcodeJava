package Q230;


 
class Solution {
	int count,value;
	
	public int kthSmallest(TreeNode root, int k) {
	        count = 0;
	        value = 0;
	        kthsmall(root,k);
	        return value;
	}
	
	public void kthsmall(TreeNode root,int k)
	{
		if(root.left == null && root.right == null)
		{			
			count++;
			if(count == k)
				value = root.val;
			return ;
		}
		else
		{
			if(root.left != null)
				kthsmall(root.left,k);
			count++;
			if(count == k) 
			{
				value = root.val;
				return ;
			}

			if(root.right != null)
				kthsmall(root.right,k);
		}
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