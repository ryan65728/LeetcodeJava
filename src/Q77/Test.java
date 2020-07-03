package Q77;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution a = new Solution();
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		result = a.combine(1, 2);
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
