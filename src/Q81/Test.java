package Q81;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution a = new Solution();
		int[] testCase = {1};//{2,2,2,2,2,2,2,3,3,3,3,3,3,3,3,3,3,4,4,4,4,4,4,4,4,4,4,1,2};//{0,0,0,0,0,0,0,0,0,1,2,0,0};
		boolean result = a.search(testCase, 1);
		System.out.printf("ans = "+result);
	}

}
