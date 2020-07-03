package Q130;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution a = new Solution();
		char[][] testCase = {{'X','O','X','O','X'},
							 {'X','X','O','X','X'},
							 {'X','O','O','O','O'},
							 {'X','O','O','X','X'},
							 {'X','O','X','O','X'},
							 {'X','O','X','X','O'}};
		a.solve(testCase);
		for(int i = 0;i < testCase.length;i++)
		{
			for(int j = 0;j < testCase[0].length;j++)
				System.out.printf(testCase[i][j]+",");			
			System.out.printf("\n");
		}
	}

}
