package Q127;

import java.util.ArrayList;
import java.util.List;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution a = new Solution();
		String[] test = {"hot","dot","dog","lot","log","cog"};
		List<String> testCase = new ArrayList<String>();
		for(String it:test)
			testCase.add(it);
		
		System.out.printf("ans = "+a.ladderLength("hit", "cog", testCase));
	}

}
