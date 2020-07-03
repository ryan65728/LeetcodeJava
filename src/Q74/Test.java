package Q74;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution a = new Solution();
		int [][] testCase = { {1,   3,  5,  7},
				  {10, 11, 16, 20},
				  {23, 30, 34, 50}};
		System.out.printf("ans = "+a.searchMatrix(testCase,0));
	}

}
