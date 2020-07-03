package Q78;

import java.util.Iterator;
import java.util.List;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution a = new Solution();
		List<List<Integer>> result = a.subsets(new int[]{4,5,6,7});
		//System.out.printf("ans = "+a.isPalindrome(1234554321));
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
