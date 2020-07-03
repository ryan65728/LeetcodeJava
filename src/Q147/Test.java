package Q147;


public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution a = new Solution();
		ListNode head = null;
		int[] testCase = {1,-1,0,0,2,5,4,4,4,1,1,-1};
		head = new ListNode(testCase[0]);
		ListNode it = head,temp1 = null,temp2 = null;
		for(int i = 1;i < testCase.length;i++)
		{
			it.next = new ListNode(testCase[i]);
			it = it.next;
			//System.out.printf(" "+it.val);
		}
		head = a.insertionSortList(null);
		for(it = head;it != null;it = it.next)
		{
			System.out.printf(" "+it.val);

		}
		
		//System.out.printf("ans = "+a.detectCycle(head).val);
	}


}
