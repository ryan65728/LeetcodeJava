package Q139;

import java.util.ArrayList;
import java.util.List;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution a = new Solution();
		String[] testCase = {"apple","pen"};
		List<String> wordDict = new ArrayList<String>();
		for(int i = 0;i < testCase.length;i++)
		{
			wordDict.add(testCase[i]);
		}
		System.out.printf("ans = "+a.wordBreak("applepenapple", wordDict));
	}

}
