package Q131;

import java.util.List;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution a = new Solution();
		String testCase = "aabbaa";
		List<List<String>> result = a.partition(testCase);
		for(List<String> i:result)
		{			
			for(String j:i)
			{
				System.out.printf(j+",");
			}
			System.out.println("---");
		}
	}

}
