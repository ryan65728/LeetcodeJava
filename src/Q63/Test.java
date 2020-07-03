package Q63;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution a = new Solution();
		int [][] testCase = {{0,0,0,0,0,0,0,0,1,0,0,0},
							 {0,0,0,1,0,0,0,0,0,0,0,1},
							 {1,0,0,0,0,1,0,0,0,0,0,0},
							 {0,0,0,0,0,0,0,0,0,0,0,0},
							 {0,1,0,0,0,0,0,0,0,1,0,0},
							 {0,0,0,0,0,0,0,0,0,0,0,0},
							 {0,0,1,0,0,0,0,0,0,0,0,0}};
		System.out.printf("ans = "+a.uniquePathsWithObstacles(testCase));
	}

}
