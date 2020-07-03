package Q147;

class Solution {
    public ListNode insertionSortList(ListNode head) {
    	ListNode prei = null;
        for(ListNode i = head;i != null;i = i.next )
        {
        	if(i != head) {
        		if(i.val < prei.val)
        		{
        			ListNode prek = null;
        			for(ListNode k = head;k != i;k = k.next ) 
        			{      				
        				if(k.val > i.val)
        				{
        					head = LinkedlistInsertSwap(head,prek,k,prei,i);
        					break;
        				}
        				prek = k;
        			}
        			i = prei;
        		}
        	}
        	prei = i;
        }
        return head;
    }
	
    public ListNode LinkedlistInsertSwap(ListNode head,ListNode pre1, ListNode temp1,ListNode pre2, ListNode temp2)//insert temp2 into front temp1
    {
    	if(temp1 == temp2) return head;
      		
        if(temp1 != null && temp2 != null)
        {
        	//System.out.printf(" tmp1:"+temp1.val+" tmp2:"+temp2.val);//+" pre1:"+pre1.val);//+" pre2:"+pre2.val); 
        	ListNode temp = temp2.next;
        	temp2.next = temp1;
        	pre2.next = temp;             	          	
     	    if(pre1 != null) 
        		pre1.next = temp2;
     	    else
     	    	return temp2;
        }       	       	
        return head;     
    }
}
