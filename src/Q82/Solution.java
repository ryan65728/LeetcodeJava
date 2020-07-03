package Q82;


class Solution {
    public ListNode deleteDuplicates(ListNode head) {
    	ListNode pre = null,new_head = null, i = null;
    	boolean temp_used = false;
    	int temp = -1 ;
    	if(head == null || head.next == null)
    		return head;
    	for(i = head;i.next != null;i = i.next)
    	{
    		if(!temp_used && i.next.val != i.val)
    		{
    			if(pre == null) 
    			{
    				pre = i;
    				new_head = i;
    			}
    		}
    		else if(temp_used && i.next.val != i.val && i.val != temp)
    		{
    			if(pre == null) 
    			{
    				pre = i;
    				new_head = i;
    			}
    			else 
    			{
    				pre.next = i;
    				pre = pre.next;
    			}
    		}
    		temp = i.val;
    		temp_used = true;
    	}
    	
    	if(temp != i.val) 
    	{
			if(pre == null) 
			{
				pre = i;
				new_head = i;
			}
			else {
				pre.next = i;
				pre = pre.next;
			}
    	}
    	if(pre != null)
    		pre.next = null;

    	return new_head;
    }
}