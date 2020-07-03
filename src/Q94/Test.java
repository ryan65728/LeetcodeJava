package Q94;

import java.util.Iterator;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution a = new Solution();
		TreeNode root = new TreeNode(1);
		TreeNode t = root;
		//int[] testCase = {};
		t.right = new TreeNode(2);
		t = t.right;
		t.left = new TreeNode(3);
		Iterator<Integer> it = a.inorderTraversal(root).iterator() ;
		while(it.hasNext())
		{
			Integer temp = it.next();
			System.out.printf(" "+temp);
		}

	}

}
