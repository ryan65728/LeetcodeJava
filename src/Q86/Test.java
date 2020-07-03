package Q86;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution a = new Solution();
		int [] test_array = {-1,-1};
		ListNode temp = null, head  = new ListNode(test_array[0]);
		temp = head;
		//ListNode temp = null, head = null;

		for(int i = 1;i < test_array.length;i++,temp = temp.next)
		{			
				temp.next = new ListNode(test_array[i]);
				
				//System.out.printf(" "+temp.val);				
		}
		
		head = a.partition(head, 0);
		
		for(ListNode i = head;i != null;i = i.next)
		{			
				System.out.printf(" "+i.val);
		}
	}

}
