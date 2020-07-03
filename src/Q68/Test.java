package Q68;

import java.util.Iterator;
import java.util.List;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution a = new Solution();
		String [] testcase = {"Science","is","what","we","understand","well","enough","to","explain",
		         "to","a","computer.","Art","is","everything","else","we","do"};
		List<String> ans = a.fullJustify(testcase,20);
		for(Iterator<String> it = ans.iterator();it.hasNext();)
		{
			String show = it.next();
			System.out.println("|"+show+"|");
		}
		
	}

}
