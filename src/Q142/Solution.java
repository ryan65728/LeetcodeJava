package Q142;


public class Solution {
	public ListNode detectCycle(ListNode head) {
    	ListNode it = head,it2 = head;
    	if(head == null || head.next == null)
    		return null;
    	
    	while(true)
    	{ 		   		
    		if(it2.next != null && it2.next.next != null)
    		{
    			it2 = it2.next;
    			it2 = it2.next;
    		}
    		else
    			return null;
    		
    		if(it.next != null)
    			it = it.next;

    		if(it == it2)
    			break;
    	}
    	
    	it = head;
    	while(it != it2)
    	{
    		it = it.next;
    		it2 = it2.next;
    	}
    	return it;
    }
}




 class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
 }
 