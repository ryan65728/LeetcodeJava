package Q72;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution a = new Solution();
		int [][] testCase = {{1}};
		a.setZeroes(testCase);
		for(int i = 0;i < testCase.length;i++)
		{
			System.out.println("");
			for(int j = 0;j < testCase[0].length;j++)
				System.out.printf(testCase[i][j]+" ");
		}
		
	}

}
