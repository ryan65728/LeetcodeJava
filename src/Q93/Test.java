package Q93;

import java.util.Iterator;
import java.util.List;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution a = new Solution();
		String testCase = "00010";
		List<String> result = a.restoreIpAddresses(testCase);
		Iterator<String> it = result.iterator();
		while(it.hasNext())
		{
			String temp = it.next();
			System.out.println(temp);
		}
	}

}
