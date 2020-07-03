package Q95;

import java.util.List;
import java.util.Stack;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution a = new Solution();
		List<TreeNode> result = a.generateTrees(1);
		for(TreeNode i:result)
		{
			Stack<TreeNode> st = new Stack<TreeNode>();
			st.push(i);
			while(!st.isEmpty())
			{
				TreeNode it = st.pop();
				System.out.printf(" "+it.val);
				if(it.right != null)
					st.push(it.right);
				if(it.left != null)
					st.push(it.left);					
			}
			System.out.println(" ");
		}
	}

}
