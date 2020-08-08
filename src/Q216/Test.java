package Q216;

import java.util.ArrayList;
import java.util.List;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution a = new Solution();
		ArrayList<List<Integer>> result =  (ArrayList<List<Integer>>) a.combinationSum3(2, 10);
		for(List<Integer> i:result)
		{
			System.out.println("ans:");
			for(Integer j:i)
			{
				System.out.printf(j+" ");
			}
		}
	}

}
