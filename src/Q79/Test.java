package Q79;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution a = new Solution();
		char[][] testCase = {{'A','B','C','E'},
							 {'S','F','E','S'},
							 {'A','D','E','E'}};
		String findString = "ABCESEEEFS";
		System.out.printf("ans "+a.exist(testCase, findString));
	}

}
