package Q75;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution a = new Solution();
		int [] testCase = {2,0,2,1,1,0,2,0,2,0,0,1,2,0,1};
		a.sortColors(testCase);
		for(int i = 0;i < testCase.length;i++)
		{
			System.out.printf(testCase[i]+" ");
		}
		
	}

}
