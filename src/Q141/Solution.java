package Q141;


public class Solution {
    public boolean hasCycle(ListNode head) {
    	ListNode it = head,it2 = null;
    	if(head == null || head.next == null)
    		return false;
    	it2 = head.next;
    	int i = 0,i2 = 1;
    	
    	while(true)
    	{
    		if(it == it2)
    			return true;
    		   		
    		if(it2.next != null && it2.next.next != null)
    		{
    			it2 = it2.next;
    			it2 = it2.next;
    		}
    		else
    			return false;
    		
    		if(it.next != null)
    			it = it.next;

    		//i++;
    		//i2+=2;
    	}
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
 