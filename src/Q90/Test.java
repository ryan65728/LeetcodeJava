package Q90;

import java.util.Iterator;
import java.util.List;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution a = new Solution();
		int[] testCase = {1,2,2};
		List<List<Integer>> result = a.subsetsWithDup(testCase);
		Iterator<List<Integer>> it = result.iterator();
		while(it.hasNext())
		{
			System.out.printf("\n");
			List<Integer> temp = it.next();
			Iterator<Integer> jt = temp.iterator();
			while(jt.hasNext())
			{
				System.out.printf(jt.next()+" ");
			}
		}
	}

}
