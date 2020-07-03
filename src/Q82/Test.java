package Q82;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution a = new Solution();
		int[] testCase = {1,1,2,2,3,3,4,4,4,5,5,5,6,7,7,7,8,8,9,9,10};
		ListNode it,head  = new ListNode(testCase[0]);;
		it = head;
		for(int i = 1;i < testCase.length;i++)
		{
			it.next = new ListNode(testCase[i]);
			it = it.next;
		}
		
		for(it = a.deleteDuplicates(head);it != null;it = it.next)
		{
			System.out.printf(" "+it.val);
		}
		
	}

}
