package Q56;

import java.util.Iterator;
import java.util.LinkedList;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution a = new Solution();
		int [][] example = {},ans;
		//int [][] ans;
		ans = a.merge(example);
		for(int i = 0;i < ans.length;i++)
		{
			for(int j = 0;j < ans[ans.length-1].length;j++)
				System.out.print("("+ans[i][j]+",");
		}

	}

}

