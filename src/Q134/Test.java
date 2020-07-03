package Q134;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution a = new Solution();
		int[] gas = {2,3,4,5,3,6,1,9};
		int[] cost = {3,4,3,2,6,2,5,3};
		System.out.printf("ans = "+a.canCompleteCircuit(gas, cost));
	}

}
