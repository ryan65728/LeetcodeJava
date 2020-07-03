package Q141;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution a = new Solution();
		ListNode head = null;
		int[] testCase = {1,4,2,3,5,4,6};
		head = new ListNode(testCase[0]);
		ListNode it = head;
		for(int i = 1;i < testCase.length;i++)
		{
			it.next = new ListNode(testCase[i]);
			//System.out.printf(" "+it.val);
			it = it.next;
		}
		it.next = it;
		//for(it = head;it != null;it = it.next)
		{
			System.out.printf(" "+it.val);

		}
		
		System.out.printf("ans = "+a.hasCycle(head));
	}

}
