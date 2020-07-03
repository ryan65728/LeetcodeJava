package Q80;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution a = new Solution();
		int[] testCase = {0,0,0};
		int length = a.removeDuplicates(testCase);
		for(int i = 0;i <length ;i++) 
		{
			System.out.printf(" "+testCase[i]);
		}
		
	}

}
