package Q221;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution a = new Solution();
		/*char[][] testCase = {{'1','0','1','0','0'},
							 {'1','0','1','1','1'},
							 {'1','1','1','1','1'},
							 {'1','0','1','1','1'}};*/
		char[][] testCase = {{'1','1','1','1'},
							 {'1','0','1','1'},
							 {'1','1','1','1'},
							 {'1','1','1','1'},
							 {'1','0','0','1'}};
		
		System.out.printf("ans = "+a.maximalSquare(testCase));
	}

}
